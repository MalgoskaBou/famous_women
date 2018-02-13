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

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Woman} represents the name of the famous woman we are displaying in the app as well as a profession
 * for the same and image as a picture file for that woman
 */
public class Woman implements Parcelable{

    // String resource id for name
    private String mName;

    // String resource id for profession
    private String mProfession;

    // String resource id for the body text content used in details activity
    private String mDescription;

    // Resource ID for the image used in list view
    private int mListImageId;

    // Resource ID for the flag image
   private int mFlagImageId;

    // Resource ID for the portait image used in details activity
   private int mPortraitImageId;



    public Woman(Context context, String[] womenInfo) {

        mName = womenInfo[0];
        mProfession = womenInfo[1];
        mDescription = womenInfo[2];
        //get drawable ids from the drawable names
        String country = womenInfo[3];
        Resources resources = context.getResources();
        mFlagImageId = resources.getIdentifier(country, "drawable", context.getPackageName());
        String name_root = womenInfo[4];
        String list_image_name = name_root + "_listimg";
        mListImageId = resources.getIdentifier(list_image_name, "drawable", context.getPackageName());
        String portrait_image_name = name_root + "_portrait";
        mPortraitImageId = resources.getIdentifier(portrait_image_name, "drawable", context.getPackageName());
    }

    //Get the string resource ID for the name
    public String getName() {
        return mName;
    }

    //Get the string resource ID for the profession
    public String getProfession() {
        return mProfession;
    }

    //Get the string resource ID for the profession
    public String getDescription(){
        return mDescription;
    }

    //Return the image resource ID of the image used in list view
    public int getListImageId() {
        return mListImageId;
    }

    //Return the image resource ID of the flag image
    public int getFlagImageId() {return mFlagImageId; }

    //Return the image resource ID of the portrait image used in details activity
    public int getPortraitImageId(){
        return mPortraitImageId;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Woman createFromParcel(Parcel in) {
            return new Woman(in);
        }

        public Woman[] newArray(int size) {
            return new Woman[size];
        }
    };

    public Woman(Parcel in){
        mName = in.readString();
        mProfession = in.readString();
        mDescription = in.readString();
        mListImageId = in.readInt();
        mFlagImageId = in.readInt();
        mPortraitImageId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mProfession);
        dest.writeString(mDescription);
        dest.writeInt(mListImageId);
        dest.writeInt(mFlagImageId);
        dest.writeInt(mPortraitImageId);
    }




}