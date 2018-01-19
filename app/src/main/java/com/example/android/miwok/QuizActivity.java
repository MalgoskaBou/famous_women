package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

    public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

        private final static String QUESTIONS_ARRAY_KEY = "questionsArrayKey";
        private final static String CURRENT_QUESTION = "currentQuestion";
        private final static String WRONG_ANSWERS = "wrongQuestions";
        private final static String SCORE = "score";
        private final static String IS_RESULT_SHOWN = "isResultShown";
        float score;
        int currentQuestion;
        int correctAnsNmb;
        int incorrectAnsNmb;
        ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
        ArrayList<Integer> wrongAnswers = new ArrayList<Integer>();
        HashMap<Integer, RadioGroup> rgHmap;
        HashMap<Integer, TextView> questionHmap;
        HashMap<Integer, Button> submitHmap;
        TextView tvResult;
        TextView tvCorrect;
        TextView tvIncorrect;
        ImageView imgCorrect;
        ImageView imgIncorrect;
        boolean isResultShown;
        Button restart;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz); // Temporary -> use array adapt or show 5 questions by default?
            // this is for the arrow in the menu bar to go back to parent activity
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Find views
            // Question 1
            final TextView question1 = findViewById(R.id.tv_question1);
            final RadioGroup rg1 = findViewById(R.id.rg_question1);
            final Button submit1 = findViewById(R.id.tv_submit_1);
            // Question 2
            final TextView question2 = findViewById(R.id.tv_question2);
            final RadioGroup rg2 = findViewById(R.id.rg_question2);
            final Button submit2 =  findViewById(R.id.tv_submit_2);
            // Question 3
            final TextView question3 = findViewById(R.id.tv_question3);
            final RadioGroup rg3 =  findViewById(R.id.rg_question3);
            final Button submit3 = findViewById(R.id.tv_submit_3);
            // Question 4
            final TextView question4 = findViewById(R.id.tv_question4);
            final RadioGroup rg4 = findViewById(R.id.rg_question4);
            final Button submit4 = findViewById(R.id.tv_submit_4);
            // Question 5
            final TextView question5 = findViewById(R.id.tv_question5);
            final RadioGroup rg5 = findViewById(R.id.rg_question5);
            final Button submit5 = findViewById(R.id.tv_submit_5);
            // Result

            tvResult = findViewById(R.id.tv_result);
            tvCorrect = findViewById(R.id.tv_correct);
            tvIncorrect = findViewById(R.id.tv_wrong);
            imgCorrect = findViewById(R.id.img_correct);
            imgIncorrect = findViewById(R.id.img_wrong);

            imgCorrect.setVisibility(View.GONE);
            imgIncorrect.setVisibility(View.GONE);

            //button Restart
            restart = findViewById(R.id.restart);
            restart.setVisibility(View.GONE);



            //HashMaps pair the question numbers with the corresponding questions, answers, and submit buttons.
            // The aim is to be able to put them in a loop, so that we need significantly less lines of code.
            rgHmap = new HashMap<Integer, RadioGroup>();
            rgHmap.put(0, rg1);
            rgHmap.put(1, rg2);
            rgHmap.put(2, rg3);
            rgHmap.put(3, rg4);
            rgHmap.put(4, rg5);

            questionHmap = new HashMap<Integer, TextView>();
            questionHmap.put(0,question1);
            questionHmap.put(1,question2);
            questionHmap.put(2,question3);
            questionHmap.put(3,question4);
            questionHmap.put(4,question5);

            submitHmap = new HashMap<Integer, Button>();
            submitHmap.put(0,submit1);
            submitHmap.put(1,submit2);
            submitHmap.put(2,submit3);
            submitHmap.put(3,submit4);
            submitHmap.put(4,submit5);

            //If the activity is opened for the first time, adds all the questions to the arrayList, shuffles them and then make a sublist with the first 5 questions.
            //The questions after the first one are made invisible.
            if (savedInstanceState == null) {
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
                questions.add(new QuizQuestion(R.string.question11, R.string.answer11_1, R.string.answer11_2, R.string.answer11_3, 3));
                questions.add(new QuizQuestion(R.string.question12, R.string.answer12_1, R.string.answer12_2, R.string.answer12_3, 2));
                questions.add(new QuizQuestion(R.string.question13, R.string.answer13_1, R.string.answer13_2, R.string.answer13_3, 2));
                // Randomized questions
                Collections.shuffle(questions);
                questions = new ArrayList<QuizQuestion>(questions.subList(0,5));
                currentQuestion = 0;
                score = 0;
                isResultShown = false;
                for(int i = 1 ; i<questions.size() ; i++){
                    rgHmap.get(i).setVisibility(View.INVISIBLE);
                    questionHmap.get(i).setVisibility(View.INVISIBLE);
                    submitHmap.get(i).setVisibility(View.INVISIBLE);
                }
                //After rotation, retrieve the list of chosen questions, number of the current question, score and wrong answers up to then
                //Redraw the current state of the views before rotation (visibilities, disabled buttons, right and wrong answer checks etc..)
            } else {
                questions = savedInstanceState.getParcelableArrayList(QUESTIONS_ARRAY_KEY);
                currentQuestion = savedInstanceState.getInt(CURRENT_QUESTION);
                wrongAnswers = (ArrayList<Integer>)savedInstanceState.getSerializable(WRONG_ANSWERS);
                score = savedInstanceState.getFloat(SCORE);
                isResultShown = savedInstanceState.getBoolean(IS_RESULT_SHOWN);
                for(int j = 0; j < currentQuestion ; j++){
                    for (int i = 0; i < rgHmap.get(j).getChildCount(); i++) {
                        rgHmap.get(j).getChildAt(i).setEnabled(false);
                    }
                    correctAnswerCheck(rgHmap.get(j), j);
                    submitHmap.get(j).setEnabled(false);
                    if(wrongAnswers.get(j) != 0){
                        RadioButton selectedAnswer = findViewById(wrongAnswers.get(j));
                        selectedAnswer.setButtonDrawable(R.drawable.ic_cancel);
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) selectedAnswer.getLayoutParams();
                        params.setMargins(16, 0, 0, 0);
                        selectedAnswer.setLayoutParams(params);
                        selectedAnswer.setPadding(16, 0, 0, 0);
                    }
                }
                for(int i = currentQuestion+1 ; i<questions.size() ; i++){
                    rgHmap.get(i).setVisibility(View.INVISIBLE);
                    questionHmap.get(i).setVisibility(View.INVISIBLE);
                    submitHmap.get(i).setVisibility(View.INVISIBLE);
                }

                if(isResultShown){
                    displayResult(score, correctAnsNmb, incorrectAnsNmb);
                }

                if(isResultShown) restart.setVisibility(View.VISIBLE);

            }

            // Display questions and answers
            for(int j = 0; j< questions.size(); j++){
                questionHmap.get(j).setText(questions.get(j).getQuestion());
                RadioButton option1 = (RadioButton) rgHmap.get(j).getChildAt(1);
                RadioButton option2 = (RadioButton) rgHmap.get(j).getChildAt(2);
                RadioButton option3 = (RadioButton) rgHmap.get(j).getChildAt(3);
                option1.setText(questions.get(j).getAnswer1());
                option2.setText(questions.get(j).getAnswer2());
                option3.setText(questions.get(j).getAnswer3());
            }
            // Set a click listeners on submit buttons
            submit1.setOnClickListener(this);
            submit2.setOnClickListener(this);
            submit3.setOnClickListener(this);
            submit4.setOnClickListener(this);
            submit5.setOnClickListener(this);
            }

        //Assign commands to each buttons with a switch statement
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.tv_submit_1: case R.id.tv_submit_2: case R.id.tv_submit_3: case R.id.tv_submit_4:{
                    submit(currentQuestion);
                    break;
                }
                case R.id.tv_submit_5: {
                    submit(currentQuestion);
                    score = score / 5 * 100;


                    correctAnsNmb = correctAnswersNmb();
                    incorrectAnsNmb = questions.size() - correctAnsNmb;
                    displayResult(score, correctAnsNmb, incorrectAnsNmb);

                    restart.setVisibility(View.VISIBLE);
                    isResultShown = true;
                    break;
                }
            }
        }

        //Common submit method for all questions
        public void submit(int numberOfQuestion) {
            //Warn if no answer is selected
            if (rgHmap.get(numberOfQuestion).getCheckedRadioButtonId() == -1) {
                Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                //Correct option is checked whether user gives the right answer or not
                int selectedRadioButtonID = rgHmap.get(numberOfQuestion).indexOfChild(findViewById(rgHmap.get(numberOfQuestion).getCheckedRadioButtonId()));
                correctAnswerCheck(rgHmap.get(numberOfQuestion), numberOfQuestion);
                //if the answer was wrong put a wrong symbol to the option chosen.
                if (questions.get(numberOfQuestion).getCorrectAnswer() != selectedRadioButtonID) {
                    incorrectAnswerCheck(rgHmap.get(numberOfQuestion));
                    //Keep track of wrong answers for rotation
                    wrongAnswers.add(rgHmap.get(numberOfQuestion).getCheckedRadioButtonId());
                } else {
                    score++;
                    wrongAnswers.add(0);
                }
                // For non-checked radio button show ic_notchecked
                for (int i = 1; i < rgHmap.get(numberOfQuestion).getChildCount(); i++){
                    if (i != selectedRadioButtonID && i != questions.get(numberOfQuestion).getCorrectAnswer()){
                        notCheck(rgHmap.get(numberOfQuestion), i);
                    }
                }

                //Disable the previous question once it is submited
                for (int i = 0; i < rgHmap.get(numberOfQuestion).getChildCount(); i++) {
                    rgHmap.get(numberOfQuestion).getChildAt(i).setEnabled(false);
                }
                submitHmap.get(numberOfQuestion).setVisibility(View.GONE);
                //Make the next question visible
                numberOfQuestion++;
                if(numberOfQuestion<questions.size()){
                    questionHmap.get(numberOfQuestion).setVisibility(View.VISIBLE);
                    rgHmap.get(numberOfQuestion).setVisibility(View.VISIBLE);
                    submitHmap.get(numberOfQuestion).setVisibility(View.VISIBLE);
                }
            }
            currentQuestion++;
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

        public void notCheck(RadioGroup rg, int index) {

            RadioButton rb = (RadioButton) rg.getChildAt(index);
            rb.setButtonDrawable(R.drawable.ic_notchecked);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rb.getLayoutParams();
            params.setMargins(20, 0, 0, 0);
            rb.setLayoutParams(params);
            rb.setPadding(16, 4, 4, 4);
        }

        public int correctAnswersNmb() {
            int correctNmb = 0;
            for (int i = 0; i < questions.size(); i++){
                int selectedRadioButtonID = rgHmap.get(i).indexOfChild(findViewById(rgHmap.get(i).getCheckedRadioButtonId()));
                if (selectedRadioButtonID == questions.get(i).getCorrectAnswer()){
                    correctNmb ++;
                }
            }
            return correctNmb;
        }

        public void displayResult(float score, int correctAns, int incorrectAns){
            imgCorrect.setVisibility(View.VISIBLE);
            imgIncorrect.setVisibility(View.VISIBLE);
            tvResult.setText(getString(R.string.quizResult) + (int) score + "%");
            tvCorrect.setText(getString(R.string.quizCorrect) + correctAns);
            tvIncorrect.setText(getString(R.string.quizIncorrect) + incorrectAns);

        }

        // invoked when the activity may be temporarily destroyed, save the instance state here
        @Override
        public void onSaveInstanceState(Bundle outState) {
            // save questions ArrayList when changing state
            outState.putParcelableArrayList(QUESTIONS_ARRAY_KEY, questions);
            outState.putInt(CURRENT_QUESTION, currentQuestion);
            outState.putSerializable(WRONG_ANSWERS, wrongAnswers);
            outState.putFloat(SCORE, score);
            outState.putBoolean(IS_RESULT_SHOWN, isResultShown);
            // call superclass to save any view hierarchy
            super.onSaveInstanceState(outState);
        }

        public void restartactivity (View v){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

