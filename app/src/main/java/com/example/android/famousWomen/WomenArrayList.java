package com.example.android.famousWomen;

import android.content.Context;
import android.os.Build;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Comparator;

public class WomenArrayList {
    private static ArrayList<Woman> women = new ArrayList<Woman>();
    public static ArrayList<Woman> getWomen(Context context) {
        if (women.size() == 0)
            InitData(context);
        return women;
    }

    // Create a list of women

    private static void InitData(Context context) {
        women.add(new Woman(context, R.array.AdaY , R.drawable.ada_yonath, R.drawable.ada_yonath_portrait, R.drawable.israel));
        women.add(new Woman(context, R.array.AmeenahGF, R.drawable.ameenah_gurib_fakim, R.drawable.ameenah_gurib_fakim_portrait, R.drawable.mauritius));
        women.add(new Woman(context, R.array.DaliaG, R.drawable.dalia_grybauskaite, R.drawable.dalia_grybauskaite_portrait, R.drawable.lithuania));
        women.add(new Woman(context, R.array.DoraA, R.drawable.dora_akunyili, R.drawable.dora_akunyili_portrait, R.drawable.nigeria));
        women.add(new Woman(context, R.array.ElisabetaR, R.drawable.elisabeta_rizea, R.drawable.elisabeta_rizea_portrait, R.drawable.romania));
        women.add(new Woman(context, R.array.EllenS, R.drawable.ellen_sirleaf, R.drawable.ellen_sirleaf_portrait, R.drawable.liberia));
        women.add(new Woman(context, R.array.IlhanO, R.drawable.ilhan_omar, R.drawable.ilhan_omar_portrait, R.drawable.united_states_of_america));
        women.add(new Woman(context, R.array.IrenaS, R.drawable.irena_sendler, R.drawable.irena_sendler_portrait, R.drawable.poland));
        women.add(new Woman(context, R.array.MariaC, R.drawable.maria_sklodowska, R.drawable.maria_sklodowska_portrait, R.drawable.poland));
        women.add(new Woman(context, R.array.MariaT, R.drawable.maria_telkes, R.drawable.maria_telkes_portrait, R.drawable.hungary));
        women.add(new Woman(context, R.array.MeriemeC, R.drawable.meriem_chadid, R.drawable.meriem_chadid_portrait, R.drawable.morocco));
        women.add(new Woman(context, R.array.Theresa, R.drawable.mother_theresa, R.drawable.mother_theresa_portrait, R.drawable.macedonia));
        women.add(new Woman(context, R.array.TurkanS, R.drawable.turkan_saylan, R.drawable.turkan_saylan_portrait, R.drawable.turkey));
        women.add(new Woman(context, R.array.ValentinaT, R.drawable.valentina_tereshkova, R.drawable.valentina_tereshkova_portrait, R.drawable.russia));
        women.add(new Woman(context, R.array.WandaR, R.drawable.wanda_rutkiewicz, R.drawable.wanda_rutkiewicz_portrait, R.drawable.poland));

        // sort list by name
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            women.sort(new Comparator<Woman>() {
                @Override
                public int compare(Woman o1, Woman o2) {
                    String name1 = Normalizer.normalize(o1.getName(), Normalizer.Form.NFD);
                    name1 = name1.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                    String name2 = Normalizer.normalize(o2.getName(), Normalizer.Form.NFD);
                    name2 = name2.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                    return name1.compareTo(name2);
                }
            });
        }
    }
}


