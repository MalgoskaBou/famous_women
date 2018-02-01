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
 * {@link Word} represents the name of the famous woman we are displaying in the app as well as a profession
 * for the same and image as a picture file for that woman
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

   private int mDescriptionId;


    public Word(int professionId, int nameId, int imageResourceId, int flagImageId) {

        mProfessionId = professionId;
        mNameId = nameId;
        mImageResourceId = imageResourceId;
        mFlagImageId = flagImageId;
    }

    public Word(int professionId, int descriptionId, int imageResourceId, int flagImageId, int nameId) {

        mProfessionId = professionId;
        mDescriptionId = descriptionId;
        mImageResourceId = imageResourceId;
        mFlagImageId = flagImageId;
        mNameId = nameId;
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

    public int getFlagImageId() {return mFlagImageId; }

    public int getDescriptionId(){
        return mDescriptionId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mNameId=" + mNameId +
                '}';
    }
}