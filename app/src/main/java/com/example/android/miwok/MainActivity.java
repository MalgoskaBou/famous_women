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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // ( ͡° ͜ʖ ͡°)
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.number_one, R.string.miwok_number_one,
                R.drawable.number_one, R.drawable.number_one));
        words.add(new Word(R.string.number_two, R.string.miwok_number_two,
                R.drawable.number_two, R.drawable.number_two));
        words.add(new Word(R.string.number_three, R.string.miwok_number_three,
                R.drawable.number_three, R.drawable.number_three));
        words.add(new Word(R.string.number_four, R.string.miwok_number_four,
                R.drawable.number_four, R.drawable.number_four));
        words.add(new Word(R.string.number_five, R.string.miwok_number_five,
                R.drawable.number_five, R.drawable.number_five));
        words.add(new Word(R.string.number_six, R.string.miwok_number_six,
                R.drawable.number_six, R.drawable.number_six));
        words.add(new Word(R.string.number_seven, R.string.miwok_number_seven,
                R.drawable.number_seven, R.drawable.number_seven));
        words.add(new Word(R.string.number_eight, R.string.miwok_number_eight,
                R.drawable.number_eight, R.drawable.number_eight));
        words.add(new Word(R.string.number_nine, R.string.miwok_number_nine,
                R.drawable.number_nine, R.drawable.number_nine));
        words.add(new Word(R.string.number_ten, R.string.miwok_number_ten,
                R.drawable.number_ten, R.drawable.number_ten));

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

               // Start the new activity
               startActivity(myIntent);


            }
        });
    }

}
