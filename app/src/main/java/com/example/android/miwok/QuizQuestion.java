package com.example.android.miwok;

/**
 * Created by MielcarekA on 12/18/2017.
 */

public class QuizQuestion {
    /** Quiz question */
    private String mQuestion;

    /** Quiz question answer 1 */
    private String mAnswer1;

    /** Quiz question answer 2 */
    private String mAnswer2;

    /** Quiz question answer 3 */
    private String mAnswer3;

    /** Quiz question correct answer */
    private int mCorrectAnswer;

    /** Quiz question index */
    private int mQuestionIndex;

    /**
     * Constructs a new QuizQuestion with initial values for texts.
     */
    public QuizQuestion(String question, String answer1, String answer2, String answer3, int correctAnswer, int questionIndex){
        mQuestion = question;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
        mAnswer3 = answer3;
        mCorrectAnswer = correctAnswer;
        mQuestionIndex = questionIndex;
    }

    /**
     * Gets the question text.
     *
     * @return question text.
     */
    public String getQuestion() {
        return mQuestion;
    }

    /**
     * Gets the answer 1 text.
     *
     * @return answer 1 text.
     */
    public String getAnswer1() {
        return mAnswer1;
    }

    /**
     * Gets the answer 2 text.
     *
     * @return answer 2 text.
     */
    public String getAnswer2() {
        return mAnswer2;
    }

    /**
     * Gets the answer 3 text.
     *
     * @return answer 3 text.
     */
    public String getAnswer3() {
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

    /**
     * Gets the question index.
     *
     * @return question index.
     */
    public int getQuestionIndex() {
        return mQuestionIndex;
    }
}
