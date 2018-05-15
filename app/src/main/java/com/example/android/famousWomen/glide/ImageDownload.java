package com.example.android.famousWomen.glide;

import android.content.Context;
import android.widget.ImageView;

import com.example.android.famousWomen.R;


/**
 * Created by narcy on 07.03.2018.
 */

public class ImageDownload {
    public static void downloadListImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0) {
            GlideApp
                    .with(c)
                    .load(url)
                    .listImage()
                    .into(img);
        }

    }

    public static void downloadDetailsImage(Context c, String url, ImageView img){
        GlideApp
                .with(c)
                .load(url)
                .detailImage()
                .into(img);
    }
}
