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

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // ( ͡° ͜ʖ ͡°)
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.maria_profession, R.string.maria,
                R.drawable.maria_sklodowska_listimg, R.drawable.maria_poland_flag));
        words.add(new Word(R.string.dalia_profession, R.string.dalia,
                R.drawable.dalia_grybauskaite_listimg, R.drawable.dalia_lithuania_flag));
        words.add(new Word(R.string.elisabeta_proffesion, R.string.elisabeta,
                R.drawable.elisabeta_rizea_listimg, R.drawable.elisabeta_rizea_flag));
        words.add(new Word(R.string.mother_theresa_profession, R.string.mother_theresa,
                R.drawable.mother_theresa_listimg, R.drawable.theresa_macedonia_flag));
        words.add(new Word(R.string.wanda_profession, R.string.wanda,
                R.drawable.wanda_rutkiewicz_listimg, R.drawable.maria_poland_flag));
        words.add(new Word(R.string.ameenah_profession, R.string.ameenah,
                R.drawable.ameenah_listing, R.drawable.ameenah_mauritius_flag));
        words.add(new Word(R.string.maria_telkes_profession, R.string.maria_telkes,
                R.drawable.maria_telkes_listimg, R.drawable.maria_hungary_flag));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                int indexOfListItem=position;
                //Get the TextView ID to transfer data to the next activity
                TextView profession = (TextView) view.findViewById(R.id.profession_text_view);
                String profession_text = profession.getText().toString();
                TextView name = (TextView) view.findViewById(R.id.name_text_view);
                String name_text = name.getText().toString();



                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);

                //we get the contents of the downloaded textView to display them in the new activity
                myIntent.putExtra("PROFESSION", profession_text );
                myIntent.putExtra("NAME", name_text);
                myIntent.putExtra("POSITION", indexOfListItem);
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
