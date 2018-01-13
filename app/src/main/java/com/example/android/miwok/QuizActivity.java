package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private final static String QUESTIONS_ARRAY_KEY = "questionsArrayKey";
    private final static String CURRENT_QUESTION = "currentQuestion";
    private final static String WRONG_ANSWERS = "wrongQuestions";
    float score = 0;
    ArrayList<QuizQuestion> allQuestions = new ArrayList<QuizQuestion>();    // ArrayList of all quiz questions
    ArrayList<QuizQuestion> questions;
    int currentQuestion;
    ArrayList<Integer> wrongAnswers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz); // Temporary -> use array adapt or show 5 questions by default?

        // this is for the arrow in the menu bar to go back to parent activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // get questions ArrayList on load if it exists
        if (savedInstanceState != null) {
            questions = savedInstanceState.getParcelableArrayList(QUESTIONS_ARRAY_KEY);
        } else {
            questions.add(new QuizQuestion(R.string.question1, R.string.answer1_1, R.string.answer1_2, R.string.answer1_3, 2));
            questions.add(new QuizQuestion(R.string.question2, R.string.answer2_1, R.string.answer2_2, R.string.answer2_3, 3));
            questions.add(new QuizQuestion(R.string.question3, R.string.answer3_1, R.string.answer3_2, R.string.answer3_3, 2));
            questions.add(new QuizQuestion(R.string.question4, R.string.answer4_1, R.string.answer4_2, R.string.answer4_3, 1));
            questions.add(new QuizQuestion(R.string.question5, R.string.answer5_1, R.string.answer5_2, R.string.answer5_3, 2));
            questions.add(new QuizQuestion(R.string.question6, R.string.answer6_1, R.string.answer6_2, R.string.answer6_3, 1));
            questions.add(new QuizQuestion(R.string.question7, R.string.answer7_1, R.string.answer7_2, R.string.answer7_3, 2 ));
            questions.add(new QuizQuestion(R.string.question8, R.string.answer8_1, R.string.answer8_2, R.string.answer8_3, 3));
            questions.add(new QuizQuestion(R.string.question9, R.string.answer9_1, R.string.answer9_2, R.string.answer9_3, 3));
            questions.add(new QuizQuestion(R.string.question10, R.string.answer10_1, R.string.answer10_2, R.string.answer10_3, 1));

          // Randomized questions
        Collections.shuffle(questions);
        int index = new Random().nextInt(questions.size());
        QuizQuestion currQuestion = questions.remove(index);
        }


        // Temporary code

        // Find views
        // Question 1
        final TextView question1 = (TextView) findViewById(R.id.tv_question1);
        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg_question1);
        final TextView ans1_1 = (TextView) findViewById(R.id.rb_answer1_1);
        final TextView ans1_2 = (TextView) findViewById(R.id.rb_answer1_2);
        final TextView ans1_3 = (TextView) findViewById(R.id.rb_answer1_3);
        final TextView submit1 = (TextView) findViewById(R.id.tv_submit_1);
        // Question 2
        final TextView question2 = (TextView) findViewById(R.id.tv_question2);
        final RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg_question2);
        final TextView ans2_1 = (TextView) findViewById(R.id.rb_answer2_1);
        final TextView ans2_2 = (TextView) findViewById(R.id.rb_answer2_2);
        final TextView ans2_3 = (TextView) findViewById(R.id.rb_answer2_3);
        final TextView submit2 = (TextView) findViewById(R.id.tv_submit_2);
        // Question 3
        final TextView question3 = (TextView) findViewById(R.id.tv_question3);
        final RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg_question3);
        final TextView ans3_1 = (TextView) findViewById(R.id.rb_answer3_1);
        final TextView ans3_2 = (TextView) findViewById(R.id.rb_answer3_2);
        final TextView ans3_3 = (TextView) findViewById(R.id.rb_answer3_3);
        final TextView submit3 = (TextView) findViewById(R.id.tv_submit_3);
        // Question 4
        final TextView question4 = (TextView) findViewById(R.id.tv_question4);
        final RadioGroup rg4 = (RadioGroup) findViewById(R.id.rg_question4);
        final TextView ans4_1 = (TextView) findViewById(R.id.rb_answer4_1);
        final TextView ans4_2 = (TextView) findViewById(R.id.rb_answer4_2);
        final TextView ans4_3 = (TextView) findViewById(R.id.rb_answer4_3);
        final TextView submit4 = (TextView) findViewById(R.id.tv_submit_4);
        // Question 5
        final TextView question5 = (TextView) findViewById(R.id.tv_question5);
        final RadioGroup rg5 = (RadioGroup) findViewById(R.id.rg_question5);
        final TextView ans5_1 = (TextView) findViewById(R.id.rb_answer5_1);
        final TextView ans5_2 = (TextView) findViewById(R.id.rb_answer5_2);
        final TextView ans5_3 = (TextView) findViewById(R.id.rb_answer5_3);
        final TextView submit5 = (TextView) findViewById(R.id.tv_submit_5);

        // Result
        final TextView result = (TextView) findViewById(R.id.tv_result);

        // get questions ArrayList on load if it exists

        allQuestions.add(new QuizQuestion(R.string.question1, R.string.answer1_1, R.string.answer1_2, R.string.answer1_3, 2));
        allQuestions.add(new QuizQuestion(R.string.question2, R.string.answer2_1, R.string.answer2_2, R.string.answer2_3, 3));
        allQuestions.add(new QuizQuestion(R.string.question3, R.string.answer3_1, R.string.answer3_2, R.string.answer3_3, 2));
        allQuestions.add(new QuizQuestion(R.string.question4, R.string.answer4_1, R.string.answer4_2, R.string.answer4_3, 1));
        allQuestions.add(new QuizQuestion(R.string.question5, R.string.answer5_1, R.string.answer5_2, R.string.answer5_3, 2));
        allQuestions.add(new QuizQuestion(R.string.question6, R.string.answer6_1, R.string.answer6_2, R.string.answer6_3, 1));
        allQuestions.add(new QuizQuestion(R.string.question7, R.string.answer7_1, R.string.answer7_2, R.string.answer7_3, 2 ));
        allQuestions.add(new QuizQuestion(R.string.question8, R.string.answer8_1, R.string.answer8_2, R.string.answer8_3, 3));
        allQuestions.add(new QuizQuestion(R.string.question9, R.string.answer9_1, R.string.answer9_2, R.string.answer9_3, 3));
        // Randomized questions
        Collections.shuffle(allQuestions);
        HashMap<Integer, RadioGroup> rgHmap = new HashMap<Integer, RadioGroup>();
        rgHmap.put(0, rg1);
        rgHmap.put(1, rg2);
        rgHmap.put(2, rg3);
        rgHmap.put(3, rg4);
        rgHmap.put(4, rg5);

        HashMap<Integer, TextView> questionHmap = new HashMap<Integer, TextView>();
        questionHmap.put(0,question1);
        questionHmap.put(1,question2);
        questionHmap.put(2,question3);
        questionHmap.put(3,question4);
        questionHmap.put(4,question5);

        HashMap<Integer, TextView> submitHmap = new HashMap<Integer, TextView>();
        submitHmap.put(0,submit1);
        submitHmap.put(1,submit2);
        submitHmap.put(2,submit3);
        submitHmap.put(3,submit4);
        submitHmap.put(4,submit5);

        if (savedInstanceState == null) {
            questions = new ArrayList<QuizQuestion>(allQuestions.subList(0,5));
            currentQuestion = 0;
            question2.setVisibility(View.INVISIBLE);
            rg2.setVisibility(View.INVISIBLE);
            submit2.setVisibility(View.INVISIBLE);
            question3.setVisibility(View.INVISIBLE);
            rg3.setVisibility(View.INVISIBLE);
            submit3.setVisibility(View.INVISIBLE);
            question4.setVisibility(View.INVISIBLE);
            rg4.setVisibility(View.INVISIBLE);
            submit4.setVisibility(View.INVISIBLE);
            question5.setVisibility(View.INVISIBLE);
            rg5.setVisibility(View.INVISIBLE);
            submit5.setVisibility(View.INVISIBLE);
            //int index = new Random().nextInt(questions.size());
            //QuizQuestion currQuestion = questions.remove(index);
        } else {
            questions = savedInstanceState.getParcelableArrayList(QUESTIONS_ARRAY_KEY);
            currentQuestion = savedInstanceState.getInt(CURRENT_QUESTION);
            wrongAnswers = (ArrayList<Integer>)savedInstanceState.getSerializable(WRONG_ANSWERS);
            for(int j = 0; j < currentQuestion ; j++){
                for (int i = 0; i < rgHmap.get(j).getChildCount(); i++) {
                    rgHmap.get(j).getChildAt(i).setEnabled(false);
                }
                correctAnswerCheck(rgHmap.get(j), j);
                if(wrongAnswers.get(j) != 0){
                    RadioButton selectedAnswer = findViewById(wrongAnswers.get(j));
                    selectedAnswer.setButtonDrawable(R.drawable.ic_cancel);
                }

            }
            for(int i = currentQuestion+1 ; i<5 ; i++){
                rgHmap.get(i).setVisibility(View.INVISIBLE);
                questionHmap.get(i).setVisibility(View.INVISIBLE);
                submitHmap.get(i).setVisibility(View.INVISIBLE);
            }
        }

        // Display questions and answers
        question1.setText(questions.get(0).getQuestion());
        ans1_1.setText(questions.get(0).getAnswer1());
        ans1_2.setText(questions.get(0).getAnswer2());
        ans1_3.setText(questions.get(0).getAnswer3());

        question2.setText(questions.get(1).getQuestion());
        ans2_1.setText(questions.get(1).getAnswer1());
        ans2_2.setText(questions.get(1).getAnswer2());
        ans2_3.setText(questions.get(1).getAnswer3());

        question3.setText(questions.get(2).getQuestion());
        ans3_1.setText(questions.get(2).getAnswer1());
        ans3_2.setText(questions.get(2).getAnswer2());
        ans3_3.setText(questions.get(2).getAnswer3());

        question4.setText(questions.get(3).getQuestion());
        ans4_1.setText(questions.get(3).getAnswer1());
        ans4_2.setText(questions.get(3).getAnswer2());
        ans4_3.setText(questions.get(3).getAnswer3());

        question5.setText(questions.get(4).getQuestion());
        ans5_1.setText(questions.get(4).getAnswer1());
        ans5_2.setText(questions.get(4).getAnswer2());
        ans5_3.setText(questions.get(4).getAnswer3());

        // Question 1 submit
        if (submit1 != null) {
            // Set a click listener on that View
            submit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg1.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        int selectedRadioButtonID = rg1.indexOfChild(findViewById(rg1.getCheckedRadioButtonId()));
                        correctAnswerCheck(rg1, 0);
                        if (questions.get(0).getCorrectAnswer() != selectedRadioButtonID) {
                            incorrectAnswerCheck(rg1);
                            wrongAnswers.add(rg1.getCheckedRadioButtonId());
                        } else {
                            score++;
                            wrongAnswers.add(0);
                        }
                        for (int i = 0; i < rg1.getChildCount(); i++) {
                            rg1.getChildAt(i).setEnabled(false);
                        }
                        question2.setVisibility(View.VISIBLE);
                        rg2.setVisibility(View.VISIBLE);
                        submit2.setVisibility(View.VISIBLE);
                        currentQuestion = 1;
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
                        Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        int selectedRadioButtonID = rg2.indexOfChild(findViewById(rg2.getCheckedRadioButtonId()));
                        correctAnswerCheck(rg2, 1);

                        if (questions.get(1).getCorrectAnswer() != selectedRadioButtonID) {
                            incorrectAnswerCheck(rg2);
                            wrongAnswers.add(rg2.getCheckedRadioButtonId());
                        } else {
                            score++;
                            wrongAnswers.add(0);
                        }
                        for (int i = 0; i < rg2.getChildCount(); i++) {
                            rg2.getChildAt(i).setEnabled(false);
                        }
                        question3.setVisibility(View.VISIBLE);
                        rg3.setVisibility(View.VISIBLE);
                        submit3.setVisibility(View.VISIBLE);
                        currentQuestion = 2;
                    }
                }
            });
        }
        // Question 3 submit
        if (submit3 != null) {
            // Set a click listener on that View
            submit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg3.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        int selectedRadioButtonID = rg3.indexOfChild(findViewById(rg3.getCheckedRadioButtonId()));
                        correctAnswerCheck(rg3, 2);

                        if (questions.get(2).getCorrectAnswer() != selectedRadioButtonID) {
                            incorrectAnswerCheck(rg3);
                            wrongAnswers.add(rg3.getCheckedRadioButtonId());
                        } else {
                            score++;
                            wrongAnswers.add(0);
                        }
                        for (int i = 0; i < rg3.getChildCount(); i++) {
                            rg3.getChildAt(i).setEnabled(false);
                        }
                        question4.setVisibility(View.VISIBLE);
                        rg4.setVisibility(View.VISIBLE);
                        submit4.setVisibility(View.VISIBLE);
                        currentQuestion = 3;
                    }
                }
            });
        }
        // Question 4 submit
        if (submit4 != null) {
            // Set a click listener on that View
            submit4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg4.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        int selectedRadioButtonID = rg4.indexOfChild(findViewById(rg4.getCheckedRadioButtonId()));
                        correctAnswerCheck(rg4, 3);

                        if (questions.get(3).getCorrectAnswer() != selectedRadioButtonID) {
                            incorrectAnswerCheck(rg4);
                            wrongAnswers.add(rg4.getCheckedRadioButtonId());
                        } else {
                            score++;
                            wrongAnswers.add(0);
                        }
                        for (int i = 0; i < rg4.getChildCount(); i++) {
                            rg4.getChildAt(i).setEnabled(false);
                        }
                        question5.setVisibility(View.VISIBLE);
                        rg5.setVisibility(View.VISIBLE);
                        submit5.setVisibility(View.VISIBLE);
                        currentQuestion = 4;
                    }
                }
            });
        }
        // Question 5 submit
        if (submit5 != null) {
            // Set a click listener on that View
            submit5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg5.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                    } else {
                        int selectedRadioButtonID = rg5.indexOfChild(findViewById(rg5.getCheckedRadioButtonId()));
                        correctAnswerCheck(rg5, 4);

                        if (questions.get(4).getCorrectAnswer() != selectedRadioButtonID) {
                            incorrectAnswerCheck(rg5);
                            wrongAnswers.add(rg5.getCheckedRadioButtonId());
                        } else {
                            score++;
                            wrongAnswers.add(0);
                        }
                        for (int i = 0; i < rg5.getChildCount(); i++) {
                            rg5.getChildAt(i).setEnabled(false);
                        }

                        score = score / 5 * 100;
                        result.setText("Your score is: " + (int) score + "%");
                    }
                }
            });
        }
    }

    public void correctAnswerCheck(RadioGroup rg, int numberOfQuestion) {
        RadioButton correctAnswer = (RadioButton) findViewById(rg.getChildAt(questions.get(numberOfQuestion).getCorrectAnswer()).getId());
        correctAnswer.setButtonDrawable(R.drawable.ic_check);
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) correctAnswer.getLayoutParams();
        params1.setMargins(16, 0, 0, 0);
        correctAnswer.setLayoutParams(params1);
        correctAnswer.setPadding(16, 0, 0, 0);

    }

    public void incorrectAnswerCheck(RadioGroup rg) {

        RadioButton selectedAnswer = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        selectedAnswer.setButtonDrawable(R.drawable.ic_cancel);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) selectedAnswer.getLayoutParams();
        params.setMargins(16, 0, 0, 0);
        selectedAnswer.setLayoutParams(params);
        selectedAnswer.setPadding(16, 0, 0, 0);

    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // save questions ArrayList when changing state
        outState.putParcelableArrayList(QUESTIONS_ARRAY_KEY, questions);
        outState.putInt(CURRENT_QUESTION, currentQuestion);
        outState.putSerializable(WRONG_ANSWERS, wrongAnswers);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
