package com.example.android.miwok;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

        private final static String QUESTIONS_ARRAY_KEY = "questionsArrayKey";
        private final static String CURRENT_QUESTION = "currentQuestion";
        private final static String WRONG_ANSWERS = "wrongQuestions";
        private final static String SCORE = "score";
        private final static String IS_RESULT_SHOWN = "isResultShown";
        private final static String SCROLL_X = "scrollX";
        private final static String SCROLL_Y = "scrollY";
        private final static String CORRECT_COUNT = "number of correct answers";
        private final static String WRONG_COUNT = "number of wrong answers";

        float score;
        int currentQuestion, correctAnsNmb, incorrectAnsNmb, arrayLength;
        ArrayList<QuizQuestion> questions = new ArrayList<>();
        ArrayList<Integer> wrongAnswers = new ArrayList<>();
        SparseArray<RadioGroup> rgSparse;
        SparseArray<TextView> questionSparse;
        SparseArray<Button> submitSparse;
        boolean isResultShown;
        ActivityQuizBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz);
            // this is for the arrow in the menu bar to go back to parent activity
            setSupportActionBar(binding.toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Hide result views
            binding.layoutResult.setVisibility(View.GONE);
            //HashMaps pair the question numbers with the corresponding questions, answers, and submit buttons.
            // The aim is to be able to put them in a loop, so that we need significantly less lines of code.
            rgSparse = new SparseArray<>();
            rgSparse.put(0, binding.rgQuestion1);
            rgSparse.put(1, binding.rgQuestion2);
            rgSparse.put(2, binding.rgQuestion3);
            rgSparse.put(3, binding.rgQuestion4);
            rgSparse.put(4, binding.rgQuestion5);

            questionSparse = new SparseArray<>();
            questionSparse.put(0,binding.tvQuestion1);
            questionSparse.put(1,binding.tvQuestion2);
            questionSparse.put(2,binding.tvQuestion3);
            questionSparse.put(3,binding.tvQuestion4);
            questionSparse.put(4,binding.tvQuestion5);

            submitSparse = new SparseArray<>();
            submitSparse.put(0,binding.tvSubmit1);
            submitSparse.put(1,binding.tvSubmit2);
            submitSparse.put(2,binding.tvSubmit3);
            submitSparse.put(3,binding.tvSubmit4);
            submitSparse.put(4,binding.tvSubmit5);

            //If the activity is opened for the first time, adds all the questions to the arrayList, shuffles them and then make a sublist with the first 5 questions.
            //The questions after the first one are made invisible.
            if (savedInstanceState == null) {
                questions = extractQuestions();
                currentQuestion = 0;
                score = 0;
                isResultShown = false;
                arrayLength = questions.size();
                for(int i = 1 ; i<arrayLength ; i++){
                    rgSparse.get(i).setVisibility(View.INVISIBLE);
                    questionSparse.get(i).setVisibility(View.INVISIBLE);
                    submitSparse.get(i).setVisibility(View.INVISIBLE);
                }
                //After rotation, retrieve the list of chosen questions, number of the current question, score and wrong answers up to then
                //Redraw the current state of the views before rotation (visibilities, disabled buttons, right and wrong answer checks etc..)
            } else {
                questions = savedInstanceState.getParcelableArrayList(QUESTIONS_ARRAY_KEY);
                currentQuestion = savedInstanceState.getInt(CURRENT_QUESTION);
                wrongAnswers = (ArrayList<Integer>)savedInstanceState.getSerializable(WRONG_ANSWERS);
                score = savedInstanceState.getFloat(SCORE);
                isResultShown = savedInstanceState.getBoolean(IS_RESULT_SHOWN);
                correctAnsNmb = savedInstanceState.getInt(CORRECT_COUNT);
                incorrectAnsNmb = savedInstanceState.getInt(WRONG_COUNT);
                final int x = savedInstanceState.getInt(SCROLL_X);
                final int y = savedInstanceState.getInt(SCROLL_Y);
                binding.scrollView.post(new Runnable(){
                    public void run(){
                        binding.scrollView.scrollTo(x, y);
                    }
                });
                for(int j = 0; j < currentQuestion ; j++){
                    for (int i = 0; i < rgSparse.get(j).getChildCount(); i++) {
                        rgSparse.get(j).getChildAt(i).setEnabled(false);
                    }
                    correctAnswerCheck(rgSparse.get(j), j);
                    submitSparse.get(j).setVisibility(View.GONE);
                    if(wrongAnswers.get(j) != 0){
                        RadioButton selectedAnswer = findViewById(wrongAnswers.get(j));
                        selectedAnswer.setButtonDrawable(R.drawable.ic_cancel);
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) selectedAnswer.getLayoutParams();
                        params.setMargins(16, 0, 0, 0);
                        selectedAnswer.setLayoutParams(params);
                        selectedAnswer.setPadding(16, 0, 0, 0);
                    }
                }
                arrayLength = questions.size();
                for(int i = currentQuestion+1 ; i<arrayLength ; i++){
                    rgSparse.get(i).setVisibility(View.INVISIBLE);
                    questionSparse.get(i).setVisibility(View.INVISIBLE);
                    submitSparse.get(i).setVisibility(View.INVISIBLE);
                }

                // Display result
                if(isResultShown)
                    displayResult(score, correctAnsNmb, incorrectAnsNmb);

            }

            // Display questions and answers
            for(int j = 0; j< arrayLength; j++){
                questionSparse.get(j).setText(questions.get(j).getQuestion());
                RadioButton option1 = (RadioButton) rgSparse.get(j).getChildAt(1);
                RadioButton option2 = (RadioButton) rgSparse.get(j).getChildAt(2);
                RadioButton option3 = (RadioButton) rgSparse.get(j).getChildAt(3);
                option1.setText(questions.get(j).getAnswer1());
                option2.setText(questions.get(j).getAnswer2());
                option3.setText(questions.get(j).getAnswer3());
            }
            // Set a click listeners on submit buttons
            binding.tvSubmit1.setOnClickListener(this);
            binding.tvSubmit2.setOnClickListener(this);
            binding.tvSubmit3.setOnClickListener(this);
            binding.tvSubmit4.setOnClickListener(this);
            binding.tvSubmit5.setOnClickListener(this);
            }

        //Assign commands to each buttons with a switch statement
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.tv_submit_1:
                case R.id.tv_submit_2:
                case R.id.tv_submit_3:
                case R.id.tv_submit_4:
                case R.id.tv_submit_5: {
                    submit(currentQuestion);
                    break;
                }
            }
        }

        public ArrayList<QuizQuestion> extractQuestions(){
            Resources resources = getResources();
            TypedArray typedArray = resources.obtainTypedArray(R.array.quiz_questions);
            int length = typedArray.length();
            for (int i = 0; i < length; ++i) {
                int id = typedArray.getResourceId(i, 0);
                String[] question = resources.getStringArray(id);
                questions.add(new QuizQuestion(question));
            }
            typedArray.recycle();

            // Randomized questions
            Collections.shuffle(questions);
            questions = new ArrayList<>(questions.subList(0,5));
            return questions;
        }

        //Common submit method for all questions
        public void submit(int numberOfQuestion) {
            //Warn if no answer is selected
            if (rgSparse.get(numberOfQuestion).getCheckedRadioButtonId() == -1) {
                Toast.makeText(getBaseContext(), "Select answer!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                //Correct option is checked whether user gives the right answer or not
                int selectedRadioButtonID = rgSparse.get(numberOfQuestion).indexOfChild(findViewById(rgSparse.get(numberOfQuestion).getCheckedRadioButtonId()));
                correctAnswerCheck(rgSparse.get(numberOfQuestion), numberOfQuestion);
                //if the answer was wrong put a wrong symbol to the option chosen.
                if (questions.get(numberOfQuestion).getCorrectAnswer() != selectedRadioButtonID) {
                    incorrectAnswerCheck(rgSparse.get(numberOfQuestion));
                    //Keep track of wrong answers for rotation
                    wrongAnswers.add(rgSparse.get(numberOfQuestion).getCheckedRadioButtonId());
                } else {
                    score++;
                    wrongAnswers.add(0);
                }
                // For non-checked radio button show ic_notchecked
                for (int i = 1; i < rgSparse.get(numberOfQuestion).getChildCount(); i++){
                    if (i != selectedRadioButtonID && i != questions.get(numberOfQuestion).getCorrectAnswer()){
                        notCheck(rgSparse.get(numberOfQuestion), i);
                    }
                }

                //Disable the previous question once it is submitted
                for (int i = 0; i < rgSparse.get(numberOfQuestion).getChildCount(); i++) {
                    rgSparse.get(numberOfQuestion).getChildAt(i).setEnabled(false);
                }
                submitSparse.get(numberOfQuestion).setVisibility(View.GONE);
                //Make the next question visible
                numberOfQuestion++;
                if(numberOfQuestion<arrayLength){
                    questionSparse.get(numberOfQuestion).setVisibility(View.VISIBLE);
                    rgSparse.get(numberOfQuestion).setVisibility(View.VISIBLE);
                    submitSparse.get(numberOfQuestion).setVisibility(View.VISIBLE);
                }
                // Automatically scroll to next question's submit button
                if (numberOfQuestion < arrayLength)
                    submitSparse.get(numberOfQuestion).getParent().requestChildFocus(submitSparse.get(numberOfQuestion), submitSparse.get(numberOfQuestion));
                // Last question - display result
                if (numberOfQuestion == arrayLength){
                    score = score / 5 * 100;
                    correctAnsNmb = correctAnswersNmb();
                    incorrectAnsNmb = arrayLength - correctAnsNmb;
                    displayResult(score, correctAnsNmb, incorrectAnsNmb);
                    isResultShown = true;
                }
            }
            currentQuestion++;
        }

        public void correctAnswerCheck(RadioGroup rg, int numberOfQuestion) {
            RadioButton correctAnswer = findViewById(rg.getChildAt(questions.get(numberOfQuestion).getCorrectAnswer()).getId());
            correctAnswer.setButtonDrawable(R.drawable.ic_check);
            LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) correctAnswer.getLayoutParams();
            params1.setMargins(16, 0, 0, 0);
            correctAnswer.setLayoutParams(params1);
            correctAnswer.setPadding(16, 0, 0, 0);
        }

        public void incorrectAnswerCheck(RadioGroup rg) {

            RadioButton selectedAnswer = findViewById(rg.getCheckedRadioButtonId());
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
            for (int i = 0; i < arrayLength; i++){
                int selectedRadioButtonID = rgSparse.get(i).indexOfChild(findViewById(rgSparse.get(i).getCheckedRadioButtonId()));
                if (selectedRadioButtonID == questions.get(i).getCorrectAnswer()){
                    correctNmb ++;
                }
            }
            return correctNmb;
        }

        public void displayResult(float score, int correctAns, int incorrectAns){
            // Make views visible
            binding.layoutResult.setVisibility(View.VISIBLE);
            // Automatically scroll reset button
            binding.restart.getParent().requestChildFocus(binding.restart, binding.restart);
            //imgCorrect.setVisibility(View.VISIBLE);
            //imgIncorrect.setVisibility(View.VISIBLE);
            binding.tvResult.setText(getString(R.string.quizResult) + (int) score + "%");
            binding.tvCorrect.setText(getString(R.string.quizCorrect) + correctAns);
            binding.tvWrong.setText(getString(R.string.quizIncorrect) + incorrectAns);
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
            outState.putInt(CORRECT_COUNT, correctAnsNmb);
            outState.putInt(WRONG_COUNT, incorrectAnsNmb);
            outState.putInt(SCROLL_X, binding.scrollView.getScrollX());
            outState.putInt(SCROLL_Y, binding.scrollView.getScrollY());
            // call superclass to save any view hierarchy
            super.onSaveInstanceState(outState);
        }

        public void restartactivity (View v){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

