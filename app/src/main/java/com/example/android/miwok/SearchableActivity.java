package com.example.android.miwok;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.MainActivity.words;

/**
 * Created by Oya on 24-01-18.
 */

public class SearchableActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    public void doMySearch(String input){
        final ArrayList<String> searchResults = new ArrayList<String>();
        final ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i< MainActivity.words.size(); i++){
            String name = getResources().getString(words.get(i).getNameId());
            if(name.toLowerCase().contains(input.toLowerCase())){
                searchResults.add(name);
                positions.add(i);
            }
            Log.v("search results", "size "+searchResults.size());
        }
        if(searchResults.isEmpty()){
            searchResults.add("No results found");
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchResults);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                String name = searchResults.get(position);
                int indexOfWoman = positions.get(position);

                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(SearchableActivity.this, DetailsActivity.class);

                //we get the contents of the downloaded textView to display them in the new activity
                myIntent.putExtra("NAME", name);
                myIntent.putExtra("POSITION", indexOfWoman);
                // Start the new activity
                startActivity(myIntent);
            }
        });
    }
}
