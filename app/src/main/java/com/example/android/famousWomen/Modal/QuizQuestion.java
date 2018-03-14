package com.example.android.famousWomen.Modal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MielcarekA on 12/18/2017.
 */

public class QuizQuestion implements Parcelable {
    /**
     * Quiz question
     */
    private String mQuestion;

    /**
     * Quiz question answer 1
     */
    private String mAnswer1;

    /**
     * Quiz question answer 2
     */
    private String mAnswer2;

    /**
     * Quiz question answer 3
     */
    private String mAnswer3;

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
    public QuizQuestion(String question, String option1, String option2, String option3, int correctOption) {
        mQuestion = question;
        mAnswer1 = option1;
        mAnswer2 = option2;
        mAnswer3 = option3;
        mCorrectAnswer = correctOption;
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

    /*
    * Implementation of Parcelable interface
    */

    public QuizQuestion(Parcel in) {
        mQuestion = in.readString();
        mAnswer1 = in.readString();
        mAnswer2 = in.readString();
        mAnswer3 = in.readString();
        mCorrectAnswer = in.readInt();
        mQuestionIndex = in.readInt();
    }

    public static final Creator<QuizQuestion> CREATOR = new Creator<QuizQuestion>() {
        @Override
        public QuizQuestion createFromParcel(Parcel in) {
            return new QuizQuestion(in);
        }

        @Override
        public QuizQuestion[] newArray(int size) {
            return new QuizQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mQuestion);
        dest.writeString(mAnswer1);
        dest.writeString(mAnswer2);
        dest.writeString(mAnswer3);
        dest.writeInt(mCorrectAnswer);
        dest.writeInt(mQuestionIndex);
    }
}