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
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private ImageView portraitImageView;
    private TextView profession, descriptionTextView;
    CollapsingToolbarLayout name;
    private ImageView flagImageView;
    public static final String POSITION = "position";
    AppBarLayout appBarLayout;

    // Array list contains IDs for: name, description on image
    private ArrayList<Word> details = new ArrayList<Word>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //we collect the transferred data from the previous activity
        int position= getIntent().getIntExtra(POSITION,0);

        name = findViewById(R.id.collapsing_toolbar);
        profession =  findViewById(R.id.profession_text);
        portraitImageView= findViewById(R.id.portrait_image);
        descriptionTextView=  findViewById(R.id.description_text);
        flagImageView= findViewById(R.id.flag_of_country);
        appBarLayout= findViewById(R.id.appbar);

        this.initDetailsArray();
        this.displaySelectedWomanInfo(position);


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

    // Initialize details array
    private void initDetailsArray(){
        // ToDo: Fix wrong Word constructor usage
        details.add(new Word(R.string.maria_profession, R.string.body_details_descriprion_maria_sklodowska,
                R.drawable.maria_portrait, R.drawable.maria_poland_flag, R.string.maria));
        details.add(new Word(R.string.dalia_profession, R.string.body_details_description_dalia,
                R.drawable.dalia_portrait, R.drawable.dalia_lithuania_flag, R.string.dalia));
        details.add(new Word(R.string.elisabeta_proffesion, R.string.body_details_description_elisabeta,
                R.drawable.elisabeta_portrait, R.drawable.elisabeta_rizea_flag, R.string.elisabeta));
        details.add(new Word(R.string.mother_theresa_profession,R.string.body_details_description_mother_theresa,
                R.drawable.theresa_portrait, R.drawable.theresa_macedonia_flag, R.string.mother_theresa));
        details.add(new Word(R.string.wanda_profession, R.string.body_details_description_wanda,
                R.drawable.wanda_rutkiewicz_portrait, R.drawable.maria_poland_flag, R.string.wanda));
        details.add(new Word(R.string.ameenah_profession, R.string.body_details_description_ameenah,
                R.drawable.ameenah_portrait, R.drawable.ameenah_mauritius_flag, R.string.ameenah));
        details.add(new Word(R.string.sirleaf_profession, R.string.body_details_description_sirleaf,
                R.drawable.sirleaf_portrait, R.drawable.sirleaf_liberia_flag, R.string.ellen_Sirleaf));
        details.add(new Word(R.string.maria_telkes_profession, R.string.body_details_description_maria_telkes,
                R.drawable.maria_telkes_portrait, R.drawable.maria_hungary_flag, R.string.maria_telkes));
        details.add(new Word(R.string.meriem_profession, R.string.body_details_description_meriem,
                R.drawable.meriem_portrait, R.drawable.meriem_morocco_flag, R.string.Merieme_Chadid));
        details.add(new Word(R.string.irena_profession, R.string.body_details_description_irena,
                R.drawable.irena_portrait, R.drawable.maria_poland_flag, R.string.irena));
        details.add(new Word(R.string.ada_profession, R.string.body_details_description_ada,
                R.drawable.ada_yonath_portrait, R.drawable.israel_flag, R.string.ada));
        details.add(new Word(R.string.ilhan_profession, R.string.body_details_description_ilhan,
                R.drawable.ilhan_portrait, R.drawable.ilhan_flag, R.string.ilhan));
        details.add(new Word(R.string.valentina_profession, R.string.body_details_description_valentina,
                R.drawable.valentina_portrait, R.drawable.russia_flag, R.string.valentina));
    }

    // set selected woman info
    private void displaySelectedWomanInfo(int position){
        setTitle(details.get(position).getNameId());
        profession.setText(details.get(position).getProfessionId());
        portraitImageView.setImageResource(details.get(position).getImageResourceId());
        // this line is actually set body_details_description. Caused by wrong usage of Word class constructor
        // ToDo: should be changed after fixing bug in initDetailsArray() method
        descriptionTextView.setText(details.get(position).getDescriptionId());
        flagImageView.setImageResource(details.get(position).getFlagImageId());
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
