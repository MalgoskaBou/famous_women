package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

public class WomenArrayList {
    private static ArrayList<Woman> women = new ArrayList<Woman>();

    public static ArrayList<Woman> getWomen(Context context) {
        if (women.size() == 0)
            InitData(context);
        return women;
    }

    // Create a list of women
    private static void InitData(Context context) {
        Resources resources = context.getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.women_info);
        int length = typedArray.length();
        for (int i = 0; i < length; ++i) {
            int id = typedArray.getResourceId(i, 0);
            String [] women_info = resources.getStringArray(id);
            String list_image_name = "list_" + i;
            String flag_image_name = "flag_" + i;
            String portrait_image_name = "portrait_" + i;
            int[] imageIds = new int[3];
            imageIds[0] = resources.getIdentifier(list_image_name, "drawable", context.getPackageName());
            imageIds[1] = resources.getIdentifier(flag_image_name, "drawable", context.getPackageName());
            imageIds[2] = resources.getIdentifier(portrait_image_name, "drawable", context.getPackageName());
            women.add(new Woman(women_info, imageIds));
        }
        typedArray.recycle();
    }
}


