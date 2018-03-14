package com.example.android.famousWomen.Data;

import android.provider.BaseColumns;

/**
 * Created by Oya on 13-03-18.
 */

public final class WomenContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public WomenContract() {
    }

    public static final class WomenEntry implements BaseColumns {

        //Name of database table for women information
        public final static String TABLE_NAME = "women";

        //Unique ID number for the woman (only for use in the database table) Type: INTEGER
        public final static String _ID = BaseColumns._ID;

        //Name of the woman Type: TEXT
        public final static String COLUMN_WOMAN_NAME ="Name";

        //Profession of the woman Type: TEXT
        public final static String COLUMN_WOMAN_PROFESSION = "Profession";

        //Details about the woman Type: TEXT
        public final static String COLUMN_WOMAN_DETAILS = "Details";

        //File path for the list image id Type: TEXT
        public final static String COLUMN_LIST_IMAGE_ID = "ListImageId";

        //File path for the portrait image id Type: TEXT
        public final static String COLUMN_PORTRAIT_IMAGE_ID = "PortraitImageId";

        //File path for the flag image id Type: TEXT
        public final static String COLUMN_FLAG_IMAGE_ID = "FlagImageId";
    }

    public static final class QuizEntry implements BaseColumns {

        //Name of database table for quiz questions
        public final static String TABLE_NAME = "Questions";

        //Unique ID number for the question (only for use in the database table) Type: INTEGER
        public final static String _ID = BaseColumns._ID;

        //Question Type: TEXT
        public final static String COLUMN_QUESTION = "Question";

        //Option 1 Type: TEXT
        public final static String COLUMN_OPTION1 = "Option1";

        //Option 2 Type: TEXT
        public final static String COLUMN_OPTION2 = "Option2";

        //Option 3 Type: TEXT
        public final static String COLUMN_OPTION3 = "Option3";

        //Correct option Type: INTEGER
        public final static String COLUMN_CORRECT_OPTION = "CorrectOption";
    }
}
