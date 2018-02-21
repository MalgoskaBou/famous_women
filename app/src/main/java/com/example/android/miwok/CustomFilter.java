package com.example.android.miwok;

/**
 * Created by narcy on 19.02.2018.
 */

//import android.graphics.Movie;
import android.widget.Filter;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


public class CustomFilter extends Filter {

    ArrayList<Woman> filterList;
    WomanAdapter adapter;

    public CustomFilter(ArrayList<Woman> filterList, WomanAdapter adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    //FILTERING
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        //RESULTS
        FilterResults results = new FilterResults();

        //VALIDATION
        if (constraint != null && constraint.length() > 0) {

            ArrayList<Woman> filteredWoman = new ArrayList<Woman>();

            //LOOP THRU FILTER LIST
            for (Woman row: filterList) {
                //CHANGE TO UPPER FOR CONSISTENCY
                String query = constraint.toString().toUpperCase();
                //STrip accents for a accent insensitive search
                String name = Normalizer.normalize(row.getName(), Normalizer.Form.NFD);
                name = name.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                query = Normalizer.normalize(query, Normalizer.Form.NFD);
                query = query.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                //FILTER
                if (name.toUpperCase().contains(query)) {
                    filteredWoman.add(row);
                }
            }

            results.count = filteredWoman.size();
            results.values = filteredWoman;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    //PUBLISH RESULTS

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.setFilteredData((List<Woman>) results.values);

//        adapter.women= (ArrayList<Woman>) results.values;
//        adapter.notifyDataSetChanged();

    }
}


