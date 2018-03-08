package com.example.android.famousWomen;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;

/**
 * Created by narcy on 07.03.2018.
 */

public class ImageDownload {
    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            GlideApp.with(c).load(url).into(img);

        }else {
            GlideApp.with(c).load(R.drawable.ic_cloud).into(img);
        }
    }
}
