package com.example.android.famousWomen.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;


import com.example.android.famousWomen.activities.DetailsActivity;
import com.example.android.famousWomen.activities.MainActivity;
import com.example.android.famousWomen.data.Constants;
import com.example.android.famousWomen.glide.ImageDownload;
import com.example.android.famousWomen.model.Woman;
import com.example.android.famousWomen.R;

import java.util.ArrayList;


/**
 * Created by narcy on 24.02.2018.
 */

public class WomenAdapterRecycle extends RecyclerView.Adapter<WomenHolder> implements Filterable {

    //we need to know the context to the intent
    //thanks to the change to RecyclerView we can opt out of the additional list (now is women -whole list and filterList)
    private final Context context;
    ArrayList<Woman> women;
    private ArrayList<Woman> filterList;
    private CustomFilter filter;

    public WomenAdapterRecycle(Context context, ArrayList<Woman> women){
        this.context = context;
        this.women = women;
        this.filterList = women;
    }

    //create ViewHolder - I implemented in an external class = WomenHolder
    @Override
    public WomenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new WomenHolder(view);
    }

    //Bind data to holder and add clickListener
    @Override
    public void onBindViewHolder(@NonNull WomenHolder holder, int position) {
        Woman currentWoman = women.get(position);

        holder.nameTextView.setText(currentWoman.getName());
        holder.professionTextView.setText(currentWoman.getProfession());

        ImageDownload.downloadImage(context,currentWoman.getListImageId(),holder.imageView);
        //holder.imageView.setImageResource(currentWoman.getListImageId());

        ImageDownload.downloadImage(context,currentWoman.getFlagImageId(),holder.flagImage);
        //holder.flagImage.setImageResource(currentWoman.getFlagImageId());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(context, DetailsActivity.class);
                myIntent.putExtra(Constants.CHOSEN_WOMAN, women.get(pos));
                      // Start the new activity
               context.startActivity(myIntent);

               }
        });

    }

    //size od whole list
    @Override
    public int getItemCount() {

        return women.size();
    }

    //filterList data
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }

}
