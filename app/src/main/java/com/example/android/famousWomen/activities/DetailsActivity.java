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
package com.example.android.famousWomen.activities;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.famousWomen.data.Constants;
import com.example.android.famousWomen.glide.ImageDownload;
import com.example.android.famousWomen.model.Woman;
import com.example.android.famousWomen.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageView portraitImageView;
    private TextView profession, descriptionTextView;
    private CollapsingToolbarLayout name;
    private ImageView flagImageView;
    private AppBarLayout appBarLayout;
    // Array list contains IDs for: name, description on image
    private Woman chosenWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //return our back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //we collect the transferred data from the previous activity
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            chosenWoman = bundle.getParcelable(Constants.CHOSEN_WOMAN);
        }

        name = findViewById(R.id.collapsing_toolbar);
        profession = findViewById(R.id.profession_text);
        portraitImageView = findViewById(R.id.portrait_image);
        descriptionTextView = findViewById(R.id.description_text);
        flagImageView = findViewById(R.id.flag_of_country);
        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {flagImageView.setVisibility(View.INVISIBLE);
                    //  Collapsed
                }
                else
                {flagImageView.setVisibility(View.VISIBLE);
                    //Expanded
                }
            }
        });

        //Display the information and images of the chosen woman
        setTitle(chosenWoman.getName());
        profession.setText(chosenWoman.getProfession());

        ImageDownload.downloadImage(getApplicationContext(),chosenWoman.getPortraitImageId(),portraitImageView);
        //portraitImageView.setImageResource(chosenWoman.getPortraitImageId());
        descriptionTextView.setText(Html.fromHtml(chosenWoman.getDescription()));
        descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());

        ImageDownload.downloadImage(getApplicationContext(),chosenWoman.getFlagImageId(),flagImageView);
        //flagImageView.setImageResource(chosenWoman.getFlagImageId());

        // TEMPORARY CODE - OPEN QUIZ
        // Find View that opens Quiz
        TextView quiz = findViewById(R.id.tv_quiz);
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

    // this is to create the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu_no_search, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_application:
                Intent intent1 = new Intent(this, AboutApplication.class);
                finish();
                this.startActivity(intent1);
                return true;
            case R.id.quiz:
                Intent intent2 = new Intent(this, QuizActivity.class);
                finish();
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}