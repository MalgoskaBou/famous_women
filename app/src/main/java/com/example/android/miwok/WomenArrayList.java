package com.example.android.miwok;

import java.util.ArrayList;

public class WomenArrayList {
    private static ArrayList<Woman> women = new ArrayList<Woman>();

    public static ArrayList<Woman> getWomen() {
        if (women.size() == 0)
            InitData();
        return women;
    }

    // Create a list of women
    private static void InitData() {
        women.add(new Woman(R.string.maria, R.string.maria_profession, R.string.body_details_descriprion_maria_sklodowska,
                R.drawable.maria_sklodowska_listimg, R.drawable.maria_poland_flag, R.drawable.maria_portrait));
        women.add(new Woman(R.string.dalia, R.string.dalia_profession, R.string.body_details_description_dalia,
                R.drawable.dalia_grybauskaite_listimg, R.drawable.dalia_lithuania_flag, R.drawable.dalia_portrait));
        women.add(new Woman(R.string.elisabeta, R.string.elisabeta_proffesion, R.string.body_details_description_elisabeta,
                R.drawable.elisabeta_rizea_listimg, R.drawable.elisabeta_rizea_flag, R.drawable.elisabeta_portrait));
        women.add(new Woman(R.string.mother_theresa, R.string.mother_theresa_profession, R.string.body_details_description_mother_theresa,
                R.drawable.mother_theresa_listimg, R.drawable.theresa_macedonia_flag, R.drawable.theresa_portrait));
        women.add(new Woman(R.string.wanda, R.string.wanda_profession, R.string.body_details_description_wanda,
                R.drawable.wanda_rutkiewicz_listimg, R.drawable.maria_poland_flag, R.drawable.wanda_rutkiewicz_portrait));
        women.add(new Woman(R.string.ameenah, R.string.ameenah_profession, R.string.body_details_description_ameenah,
                R.drawable.ameenah_listing, R.drawable.ameenah_mauritius_flag, R.drawable.ameenah_portrait));
        women.add(new Woman(R.string.ellen_Sirleaf, R.string.sirleaf_profession, R.string.body_details_description_sirleaf,
                R.drawable.sirleaf_listing, R.drawable.sirleaf_liberia_flag, R.drawable.sirleaf_portrait));
        women.add(new Woman(R.string.maria_telkes, R.string.maria_telkes_profession, R.string.body_details_description_maria_telkes,
                R.drawable.maria_telkes_listimg, R.drawable.maria_hungary_flag, R.drawable.maria_telkes_portrait));
        women.add(new Woman(R.string.Merieme_Chadid, R.string.meriem_profession, R.string.body_details_description_meriem,
                R.drawable.meriem_listimg, R.drawable.meriem_morocco_flag, R.drawable.meriem_portrait));
        women.add(new Woman(R.string.irena, R.string.irena_profession, R.string.body_details_description_irena,
                R.drawable.irena_sendler_listimg, R.drawable.maria_poland_flag, R.drawable.irena_portrait));
        women.add(new Woman(R.string.ada, R.string.ada_profession, R.string.body_details_description_ada,
                R.drawable.ada_yonath_listimg, R.drawable.israel_flag, R.drawable.ada_yonath_portrait));
        women.add(new Woman(R.string.ilhan, R.string.ilhan_profession, R.string.body_details_description_ilhan,
                R.drawable.ilhan_listing, R.drawable.ilhan_flag, R.drawable.ilhan_portrait));
        women.add(new Woman(R.string.valentina, R.string.valentina_profession, R.string.body_details_description_valentina,
                R.drawable.valentina_tereshkova_listimg, R.drawable.russia_flag, R.drawable.valentina_portrait));
        women.add(new Woman(R.string.prof_dora, R.string.prof_dora_profession, R.string.body_details_descriprion_prof_dora,
                R.drawable.dora_akunyili_listimg, R.drawable.dora_nigeria_flag, R.drawable.dora_portrait));
    }
}


