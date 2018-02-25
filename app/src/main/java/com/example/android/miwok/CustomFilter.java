package com.example.android.miwok;

/**
 * Created by narcy on 19.02.2018.
 */

//import android.graphics.Movie;
import android.widget.Filter;

import java.util.ArrayList;


public class CustomFilter extends Filter {

    ArrayList<Woman> filterList;
    WomenAdapterRecycle adapter;

    public CustomFilter(ArrayList<Woman> filterList, WomenAdapterRecycle adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    //FILTERING
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Woman> filteredPlayers=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }


    //PUBLISH RESULTS

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.women= (ArrayList<Woman>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}


