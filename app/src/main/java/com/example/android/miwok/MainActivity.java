/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Woman> women = new ArrayList<>();
    public static final String CHOSEN_WOMAN = "chosen_woman";
    public static final String WOMEN_LIST = "women_list";
    public static final String SEARCH_CLICKED = "search_clicked";
    SearchView searchView;
    WomanAdapter adapter;
    //boolean searchClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ( ͡° ͜ʖ ͡°)

        women = WomenArrayList.getWomen(this);
        /*if(savedInstanceState == null){
            // Get the list of all women
            women = WomenArrayList.getWomen(this);
        } else {
            //Get the list of all or filtered women
            women = (ArrayList<Woman>)savedInstanceState.getSerializable(WOMEN_LIST);
            searchClicked = savedInstanceState.getBoolean(SEARCH_CLICKED);
        }*/

        // Create an {@link WomanAdapter}, whose data source is a list of {@link Woman}s. The

        // adapter knows how to create list items for each item in the list.
        adapter = new WomanAdapter(this, women);
        women = adapter.filterList;
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            adapter.getFilter().filter(query);
        }

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WomanAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Woman} in the list.
        listView.setAdapter(adapter);


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);
                myIntent.putExtra(CHOSEN_WOMAN, women.get(position));
                      // Start the new activity
               startActivity(myIntent);
            }
        });

    }

    // this is to create the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        Log.d("onCreateOptionsMenu", "");
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        /*if(searchClicked){
            menu.getItem(2).expandActionView();
            searchView.onActionViewExpanded();
            Log.d("search clicked?", "" + searchClicked);
        }*/
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //added filter to list (dynamic change)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                //searchClicked = true;
                Log.v("what I write search f ", query);
                Log.v("size of table changing ", adapter.women.size()+"");
                return false;
            }
        });

        return true;
    }

    // this is to create the different parts of the menu bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_application:
                Intent intent1 = new Intent(this, AboutApplication.class);
                this.startActivity(intent1);
                return true;
            case R.id.quiz:
                Intent intent2 = new Intent(this, QuizActivity.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(WOMEN_LIST, women);
        outState.putBoolean(SEARCH_CLICKED, searchClicked);
        super.onSaveInstanceState(outState);
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}
