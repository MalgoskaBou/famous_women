package com.example.android.famousWomen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by narcy on 25.02.2018.
 */

public class WomenHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    ImageView imageView, flagImage;
    TextView nameTextView,professionTextView;

    ItemClickListener itemClickListener;


    public WomenHolder(View itemView) {
        super(itemView);

        this.nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        this.professionTextView = (TextView) itemView.findViewById(R.id.profession_text_view);
        this.imageView = (ImageView) itemView.findViewById(R.id.image);
        this.flagImage = (ImageView) itemView.findViewById(R.id.flag);


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic)
    {

        this.itemClickListener=ic;
    }
}
