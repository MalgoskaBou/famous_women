package com.example.android.famousWomen.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.android.famousWomen.R;

public class AboutApplication extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_application);

        // this is for the arrow in the menu bar to go back to parent activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView link = findViewById(R.id.link);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}