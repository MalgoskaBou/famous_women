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
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WomanAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Woman} objects.
 */
public class WomanAdapter extends ArrayAdapter<Woman>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WomanAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param women is the list of {@link Woman}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of women
     */
    public WomanAdapter(Context context, ArrayList<Woman> women, int colorResourceId) {
        super(context, 0, women);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Woman} object located at this position in the list
        Woman currentWoman = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name of the woman from the currentWoman object and set this text on
        // the name TextView.
        nameTextView.setText(currentWoman.getNameId());

        // Find the TextView in the list_item.xml layout with the ID profession_text_view.
        TextView professionTextView = (TextView) listItemView.findViewById(R.id.profession_text_view);
        // Get the default translation from the currentWoman object and set this text on
        // the profession TextView.
        professionTextView.setText(currentWoman.getProfessionId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentWoman.getListImageId());//currentWoman.getImageResourceId());//

        //Find the ImageViev for flag
        ImageView flagImage = (ImageView) listItemView.findViewById(R.id.flag);

        flagImage.setImageResource(currentWoman.getFlagImageId());



        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView
        return listItemView;
    }
}