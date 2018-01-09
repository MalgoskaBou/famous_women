package com.example.android.miwok;

/**
 * Created by MielcarekA on 12/18/2017.
 */

public class QuizQuestion {
    /**
     * Quiz question
     */
    private int mQuestion;

    /**
     * Quiz question answer 1
     */
    private int mAnswer1;

    /**
     * Quiz question answer 2
     */
    private int mAnswer2;

    /**
     * Quiz question answer 3
     */
    private int mAnswer3;

    /**
     * Quiz question correct answer
     */
    private int mCorrectAnswer;

    /**
     * Quiz question index
     */
    private int mQuestionIndex;

    /**
     * Constructs a new QuizQuestion with initial values for texts.
     */
    public QuizQuestion(int question, int answer1, int answer2, int answer3, int correctAnswer) {
        mQuestion = question;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
        mAnswer3 = answer3;
        mCorrectAnswer = correctAnswer;
    }

    /**
     * Gets the question text.
     *
     * @return question text.
     */
    public int getQuestion() {
        return mQuestion;
    }

    /**
     * Gets the answer 1 text.
     *
     * @return answer 1 text.
     */
    public int getAnswer1() {
        return mAnswer1;
    }

    /**
     * Gets the answer 2 text.
     *
     * @return answer 2 text.
     */
    public int getAnswer2() {
        return mAnswer2;
    }

    /**
     * Gets the answer 3 text.
     *
     * @return answer 3 text.
     */
    public int getAnswer3() {
        return mAnswer3;
    }

    /**
     * Gets the correct answer number.
     *
     * @return correct answer number.
     */
    public int getCorrectAnswer() {
        return mCorrectAnswer;
    }
}