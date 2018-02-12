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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ( ͡° ͜ʖ ͡°)

        // Get a list of women
        women = WomenArrayList.getWomen(this);

        // sort list by name
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            women.sort(new Comparator<Woman>() {
                @Override
                public int compare(Woman o1, Woman o2) {

                    String name1 = o1.getName();
                    String name2 = o2.getName();
                    return name1.compareTo(name2);
                }
            });
        }

        // Create an {@link WomanAdapter}, whose data source is a list of {@link Woman}s. The

        // adapter knows how to create list items for each item in the list.
        WomanAdapter adapter = new WomanAdapter(this, women, R.color.category_numbers);

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

                //We need to pass only the position. We can retrieve the rest from the list on the next page.
                // Others were redundant I erased them(Oya)
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
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

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
}
