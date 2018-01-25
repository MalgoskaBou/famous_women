package com.example.android.miwok;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Created by Oya on 24-01-18.
 */

public class SearchableActivity extends AppCompatActivity{

    public static final String POSITION = "position";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }


    }

    public void doMySearch(String input){
        ArrayList<Word> women = new ArrayList<Word>();
        women.add(new Word(R.string.maria_profession, R.string.maria,
                R.drawable.maria_sklodowska_listimg, R.drawable.maria_poland_flag));
        women.add(new Word(R.string.dalia_profession, R.string.dalia,
                R.drawable.dalia_grybauskaite_listimg, R.drawable.dalia_lithuania_flag));
        women.add(new Word(R.string.elisabeta_proffesion, R.string.elisabeta,
                R.drawable.elisabeta_rizea_listimg, R.drawable.elisabeta_rizea_flag));
        women.add(new Word(R.string.mother_theresa_profession, R.string.mother_theresa,
                R.drawable.mother_theresa_listimg, R.drawable.theresa_macedonia_flag));
        women.add(new Word(R.string.wanda_profession, R.string.wanda,
                R.drawable.wanda_rutkiewicz_listimg, R.drawable.maria_poland_flag));
        women.add(new Word(R.string.ameenah_profession, R.string.ameenah,
                R.drawable.ameenah_listing, R.drawable.ameenah_mauritius_flag));
        women.add(new Word(R.string.sirleaf_profession, R.string.ellen_Sirleaf,
                R.drawable.sirleaf_listing, R.drawable.sirleaf_liberia_flag));
        women.add(new Word(R.string.maria_telkes_profession, R.string.maria_telkes,
                R.drawable.maria_telkes_listimg, R.drawable.maria_hungary_flag));
        women.add(new Word(R.string.meriem_profession, R.string.Merieme_Chadid,
                R.drawable.meriem_listimg, R.drawable.meriem_morocco_flag));
        women.add(new Word(R.string.irena_profession, R.string.irena,
                R.drawable.irena_sendler_listimg, R.drawable.maria_poland_flag));
        women.add(new Word(R.string.ada_profession, R.string.ada,
                R.drawable.ada_yonath_listimg, R.drawable.israel_flag));
        women.add(new Word(R. string.ilhan_profession , R.string.ilhan,
                R.drawable.ilhan_listing, R.drawable.ilhan_flag));
        women.add(new Word(R.string.valentina_profession, R.string.valentina,
                R.drawable.valentina_tereshkova_listimg, R.drawable.russia_flag));
        final ArrayList<String> searchResults = new ArrayList<String>();
        final ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i< women.size(); i++){
            String name = getResources().getString(women.get(i).getNameId());
            //final Collator instance = Collator.getInstance();
            //instance.setStrength(Collator.NO_DECOMPOSITION);
            //
           String withoutAccents = Normalizer.normalize(name, Normalizer.Form.NFD);
            withoutAccents = withoutAccents.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            input = Normalizer.normalize(input, Normalizer.Form.NFD);
            input = input.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            if(withoutAccents.toLowerCase().contains(input.toLowerCase())){
                searchResults.add(name);
                positions.add(i);
            }
            Log.v("search results", "size " + searchResults.size());
        }
        if(searchResults.isEmpty()){
            searchResults.add("No results found");
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchResults);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int indexOfWoman = positions.get(position);

                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(SearchableActivity.this, DetailsActivity.class);
                myIntent.putExtra(POSITION, indexOfWoman);
                // Start the new activity
                startActivity(myIntent);
            }
        });
    }
}
