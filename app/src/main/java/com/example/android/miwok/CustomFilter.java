package com.example.android.miwok;

/**
 * Created by narcy on 19.02.2018.
 */

//import android.graphics.Movie;
import android.widget.Filter;
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

            //CHANGE TO UPPER FOR CONSISTENCY
            constraint = constraint.toString().toUpperCase();

            ArrayList<Woman> filteredWoman = new ArrayList<Woman>();

            //LOOP THRU FILTER LIST
            for (int i = 0; i < filterList.size(); i++) {
                //FILTER
                if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
                    filteredWoman.add(filterList.get(i));
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


