package com.example.android.miwok;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Created by Oya on 24-01-18.
 */

public class SearchableActivity extends AppCompatActivity{

    public static final String CHOSEN_WOMAN = "chosen_woman";
    public static final String WOMEN_LIST = "women_list";
    private ArrayList<Woman> women;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //return our back arrow
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get a list of women
        women = WomenArrayList.getWomen();

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
        for(int i = 0; i< women.size(); i++){
            String name = getString(women.get(i).getNameId());
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
                //we need the position of the chosen woman in the women list(not the position in the searchresults list)
                int indexOfWoman = positions.get(position);
                //send the chosen woman to details activity as an object
                Intent myIntent = new Intent(SearchableActivity.this, DetailsActivity.class);
                myIntent.putExtra(CHOSEN_WOMAN, women.get(indexOfWoman));
                startActivity(myIntent);
            }
        });
    }
}
