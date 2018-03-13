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
package com.example.android.famousWomen.Activities;

import android.app.SearchManager;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.famousWomen.Data.WomenDbHelper;
import com.example.android.famousWomen.R;
import com.example.android.famousWomen.Modal.Woman;
import com.example.android.famousWomen.RecyclerView.WomenAdapterRecycle;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Woman> women = new ArrayList<>();
    public static final String CHOSEN_WOMAN = "chosen_woman";
    public static final String WOMEN_LIST = "women_list";
    SearchView searchView;
    WomenAdapterRecycle adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ( ͡° ͜ʖ ͡°)

        WomenDbHelper dbHelper = new WomenDbHelper(this);
        try {
            dbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dbHelper.openDatabase();
        }catch(SQLException sqle) {
            throw sqle;
        }

        women = dbHelper.getWomenList();

        // Find the {@link RecyclerView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link RecyclerView} with the view ID called list, which is declared in the
        // woman_listt.xml layout file.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // adapter knows how to create list items for each item in the list.
        adapter = new WomenAdapterRecycle(this, women);

        // Make the {@link RecyclerView} use the {@link WomanAdapter} we created above, so that the
        // {@link RecyclerView} will display list items for each {@link Woman} in the list.
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            adapter.getFilter().filter(query);
        }
    }

    // this is to create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //added filter to list (dynamic change input text)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        return true;
    }

    // this is menu Intents
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_application:
                Intent intentAboutApp = new Intent(this, AboutApplication.class);
                this.startActivity(intentAboutApp);
                return true;
            case R.id.quiz:
                Intent intentQuiz = new Intent(this, QuizActivity.class);
                this.startActivity(intentQuiz);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(WOMEN_LIST, women);
        super.onSaveInstanceState(outState);
    }

}
