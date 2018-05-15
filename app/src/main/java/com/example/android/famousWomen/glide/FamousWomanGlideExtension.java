package com.example.android.famousWomen.glide;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.famousWomen.R;

@GlideExtension
public class FamousWomanGlideExtension {

    private FamousWomanGlideExtension(){
    }

    @GlideOption
    public static void listImage(RequestOptions options) {
        options
                .placeholder(R.drawable.ic_cloud)
                .circleCrop()
                .override(60, 60);
    }

    @GlideOption
    public static void detailImage(RequestOptions options) {
        options
                .placeholder(R.drawable.ic_cloud)
                .centerCrop();
    }
}
