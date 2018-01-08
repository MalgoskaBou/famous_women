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

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {


    private ImageView portraitImageView;
    private TextView descriptionTextView;
    private ImageView flagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);

       

        //we collect the transferred data from the previous activity
        String profession_string = getIntent().getStringExtra("PROFESSION");
        String name_string = getIntent().getStringExtra("NAME");
        /**
         * I created a variable that retains the position of the list item that was clicked
         */
        portraitImageView=(ImageView) findViewById(R.id.portrait_image);
        descriptionTextView= (TextView) findViewById(R.id.description_text);
        flagImageView= (ImageView) findViewById(R.id.flag_of_country);
        int position= getIntent().getIntExtra("POSITION",0);

        if(position==0)
        {
            /**
             * Poland
             */


            portraitImageView.setImageResource(R.drawable.maria_portrait);
            descriptionTextView.setText(R.string.body_details_description_dalia);
            flagImageView.setImageResource(R.drawable.maria_poland_flag);
        }
        else if(position==1)
        {
            /**
             * Lithuania
             */


            portraitImageView.setImageResource(R.drawable.dalia_portrait);
            descriptionTextView.setText(R.string.body_details_description_dalia);
            flagImageView.setImageResource(R.drawable.dalia_lithuania_flag);
        }
        else if(position==2)
        {
            /**
             * Romania
             */

            portraitImageView.setImageResource(R.drawable.elisabeta_portrait);
            descriptionTextView.setText(R.string.body_details_description_elisabeta);
            flagImageView.setImageResource(R.drawable.elisabeta_rizea_flag);
        }
        else if (position==3) {
            /**
             * Macedonia
             */

            portraitImageView.setImageResource(R.drawable.mother_theresa);
            descriptionTextView.setText(R.string.body_details_description_mother_theresa);
            flagImageView.setImageResource(R.drawable.macedonia_flag);
        }


        //put data to new textView
        TextView profession = (TextView) findViewById(R.id.profession_text);
        profession.setText(profession_string);
        TextView name = (TextView) findViewById(R.id.name_text);
        name.setText(name_string);


        // TEMPORARY CODE - OPEN QUIZ
        // Find View that opens Quiz
        TextView quiz = (TextView) findViewById(R.id.tv_quiz);
        if (quiz != null) {
            // Set a click listener on that View
            quiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(DetailsActivity.this, QuizActivity.class);
                    startActivity(i);
                }
            });
        }


    }
}
