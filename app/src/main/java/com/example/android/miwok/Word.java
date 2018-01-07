/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class Word {

    /** String resource ID for the default translation of the word */
    private int mNameId;

    /** String resource ID for the Miwok translation of the word */
    private int mProfessionId;

    /** Image resource ID for the word */
    private int mImageResourceId;

   /** Flag image ID **/
   private int mFlagImageId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    public Word(int defaultTranslationId, int miwokTranslationId, int imageResourceId, int flagImageId) {
        mNameId = defaultTranslationId;
        mProfessionId = miwokTranslationId;
        mImageResourceId = imageResourceId;
        mFlagImageId = flagImageId;

    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getNameId() {
        return mNameId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getProfessionId() {
        return mProfessionId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getmFlagImageId() {return mFlagImageId; }




}