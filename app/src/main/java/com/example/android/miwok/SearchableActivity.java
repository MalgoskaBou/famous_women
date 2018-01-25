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

import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Created by Oya on 24-01-18.
 */

public class SearchableActivity extends AppCompatActivity{

    public static final String POSITION = "position";

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
        //create an arraylist of all names of women(in parallel to list words
        ArrayList<String> women = new ArrayList<String>();
        women.add(getString(R.string.maria));
        women.add(getString(R.string.dalia));
        women.add(getString(R.string.elisabeta));
        women.add(getString(R.string.mother_theresa));
        women.add(getString(R.string.wanda));
        women.add(getString(R.string.ameenah));
        women.add(getString(R.string.ellen_Sirleaf));
        women.add(getString(R.string.maria_telkes));
        women.add(getString(R.string.Merieme_Chadid));
        women.add(getString(R.string.irena));
        women.add(getString(R.string.ada));
        women.add(getString(R.string.ilhan));
        women.add(getString(R.string.valentina));

        final ArrayList<String> searchResults = new ArrayList<String>();
        final ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i< women.size(); i++){
            String name = women.get(i);
            //strip accents
            String withoutAccents = Normalizer.normalize(name, Normalizer.Form.NFD);
            withoutAccents = withoutAccents.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            input = Normalizer.normalize(input, Normalizer.Form.NFD);
            input = input.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            //turn all to lower case before search
            if(withoutAccents.toLowerCase().contains(input.toLowerCase())){
                searchResults.add(name);
                positions.add(i);//keep track of positions of the results
            }
            Log.v("search results", "size " + searchResults.size());
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

                int indexOfWoman = positions.get(position);

                //we use INTENT to turn on new ones activity and send position info to details activity
                Intent myIntent = new Intent(SearchableActivity.this, DetailsActivity.class);
                myIntent.putExtra(POSITION, indexOfWoman);
                // Start the new activity
                startActivity(myIntent);
            }
        });
    }
}
