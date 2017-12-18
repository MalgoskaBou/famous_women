package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz); // Temporary -> use array adapt or show 5 questions by default?

        final ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
        questions.add(new QuizQuestion("Question 1", "Answer 11", "Answer 12", "Answer 13", 1, 1));
        questions.add(new QuizQuestion("Question 2", "Answer 21", "Answer 22", "Answer 23", 2, 2));
        questions.add(new QuizQuestion("Question 3", "Answer 31", "Answer 32", "Answer 33", 3, 1));

        final int correctA = questions.get(0).getCorrectAnswer();

        // Temporary code
        // Question 1
        final TextView question1 = (TextView)findViewById(R.id.tv_question1);
        final RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg_question1);
        final TextView ans1_1 = (TextView)findViewById(R.id.rb_answer1_1);
        final TextView ans1_2 = (TextView)findViewById(R.id.rb_answer1_2);
        final TextView ans1_3 = (TextView)findViewById(R.id.rb_answer1_3);
        final TextView submit1 = (TextView) findViewById(R.id.tv_submit_1);
        // Question 2
        final TextView question2 = (TextView)findViewById(R.id.tv_question2);
        final RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg_question2);
        final TextView ans2_1 = (TextView)findViewById(R.id.rb_answer2_1);
        final TextView ans2_2 = (TextView)findViewById(R.id.rb_answer2_2);
        final TextView ans2_3 = (TextView)findViewById(R.id.rb_answer2_3);
        final TextView submit2 = (TextView) findViewById(R.id.tv_submit_2);

        question1.setText(questions.get(0).getQuestion());
        ans1_1.setText(questions.get(0).getAnswer1());
        ans1_2.setText(questions.get(0).getAnswer2());
        ans1_3.setText(questions.get(0).getAnswer3());

        question2.setText(questions.get(1).getQuestion());
        question2.setVisibility(View.INVISIBLE);
        rg2.setVisibility(View.INVISIBLE);
        ans2_1.setText(questions.get(1).getAnswer1());
        ans2_2.setText(questions.get(1).getAnswer2());
        ans2_3.setText(questions.get(1).getAnswer3());
        submit2.setVisibility(View.INVISIBLE);

        // Question 1 submit
        if (submit1 != null) {
            // Set a click listener on that View
            submit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg1.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg1.indexOfChild(findViewById(rg1.getCheckedRadioButtonId()));
                        View child = rg1.getChildAt(questions.get(0).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(0).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg1.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        }
                        for (int i = 0; i < rg1.getChildCount(); i++) {
                            rg1.getChildAt(i).setEnabled(false);
                        }
                        question2.setVisibility(View.VISIBLE);
                        rg2.setVisibility(View.VISIBLE);
                        submit2.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Question 2 submit
        if (submit2 != null) {
            // Set a click listener on that View
            submit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg2.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg2.indexOfChild(findViewById(rg2.getCheckedRadioButtonId()));
                        View child = rg2.getChildAt(questions.get(1).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(1).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg2.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        }
                        for (int i = 0; i < rg2.getChildCount(); i++) {
                            rg2.getChildAt(i).setEnabled(false);
                        }
                        // question3.setVisibility(View.VISIBLE);
                        // rg3.setVisibility(View.VISIBLE);
                        // submit3.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}
