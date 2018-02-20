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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;

import java.util.ArrayList;

/**
 * {@link WomanAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Woman} objects.
 */
public class WomanAdapter extends ArrayAdapter<Woman> {


    //=========NEW CODE
    ArrayList<Woman> women;
    ArrayList<Woman> filterList;
    CustomFilter filter;
    //=========NEW CODE-

    /**
     * Create a new {@link WomanAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param women is the list of {@link Woman}s to be displayed.
     */
    public WomanAdapter(Context context, ArrayList<Woman> women) {
        super(context, 0, women);


       //===========NEW CODE
        this.women = women;
        this.filterList = women;

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
        nameTextView.setText(currentWoman.getName());

        // Find the TextView in the list_item.xml layout with the ID profession_text_view.
        TextView professionTextView = (TextView) listItemView.findViewById(R.id.profession_text_view);
        // Get the default translation from the currentWoman object and set this text on
        // the profession TextView.
        professionTextView.setText(currentWoman.getProfession());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentWoman.getListImageId());//currentWoman.getImageResourceId());//

        //Find the ImageViev for flag
        ImageView flagImage = (ImageView) listItemView.findViewById(R.id.flag);

        flagImage.setImageResource(currentWoman.getFlagImageId());


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView
        return listItemView;
    }

    //=======NEW CODE
    @Override
    public Filter getFilter() {

        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;

    }
    //=======NEW CODE -
}