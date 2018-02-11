package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MielcarekA on 12/18/2017.
 */

public class QuizQuestion implements Parcelable {
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
    QuizQuestion(int question, int answer1, int answer2, int answer3, int correctAnswer) {
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
    int getQuestion() {
        return mQuestion;
    }

    /**
     * Gets the answer 1 text.
     *
     * @return answer 1 text.
     */
    int getAnswer1() {
        return mAnswer1;
    }

    /**
     * Gets the answer 2 text.
     *
     * @return answer 2 text.
     */
    int getAnswer2() {
        return mAnswer2;
    }

    /**
     * Gets the answer 3 text.
     *
     * @return answer 3 text.
     */
    int getAnswer3() {
        return mAnswer3;
    }

    /**
     * Gets the correct answer number.
     *
     * @return correct answer number.
     */
    int getCorrectAnswer() {
        return mCorrectAnswer;
    }

    /*
    * Implementation of Parcelable interface
    */

    private QuizQuestion(Parcel in) {
        mQuestion = in.readInt();
        mAnswer1 = in.readInt();
        mAnswer2 = in.readInt();
        mAnswer3 = in.readInt();
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
        dest.writeInt(mQuestion);
        dest.writeInt(mAnswer1);
        dest.writeInt(mAnswer2);
        dest.writeInt(mAnswer3);
        dest.writeInt(mCorrectAnswer);
        dest.writeInt(mQuestionIndex);
    }
}