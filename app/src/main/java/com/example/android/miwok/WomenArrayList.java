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
            women.add(new Woman(context, women_info));
        }
        typedArray.recycle();

    }
}


