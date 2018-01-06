package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutApplication extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_application);

        // this is for the arrow in the menu bar to go back to parent activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}