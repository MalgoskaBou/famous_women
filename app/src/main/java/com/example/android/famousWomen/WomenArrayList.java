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
        women.add(new Woman(context, R.array.AdaY ,
                "https://user-images.githubusercontent.com/33101796/37155584-eb026e7c-22e3-11e8-986e-7386b4c4e047.jpg",
                "https://user-images.githubusercontent.com/33101796/37155585-eb730b64-22e3-11e8-84e3-45f9d2247950.jpg",
                "https://user-images.githubusercontent.com/33101796/37167132-56deea68-2301-11e8-89bd-9421599c393b.gif"));

        women.add(new Woman(context, R.array.AmeenahGF,
                "https://user-images.githubusercontent.com/33101796/37155587-ebc8c8b0-22e3-11e8-93cf-91a171ccc8ae.jpg",
                "https://user-images.githubusercontent.com/33101796/37155588-ebef5340-22e3-11e8-87f0-5103c6e994e4.jpg",
                "https://user-images.githubusercontent.com/33101796/37178266-495ec608-2322-11e8-9f62-0e7f9c31717e.gif"));

        women.add(new Woman(context, R.array.DaliaG,
                "https://user-images.githubusercontent.com/33101796/37155589-ec164a54-22e3-11e8-9bde-14c050855e57.jpg",
                "https://user-images.githubusercontent.com/33101796/37155591-ec3ddc90-22e3-11e8-9d33-8e01d185264c.jpg",
                "https://user-images.githubusercontent.com/33101796/37167134-572e0832-2301-11e8-994e-a8d1e67bd3b3.gif"));

        women.add(new Woman(context, R.array.DoraA,
                "https://user-images.githubusercontent.com/33101796/37155600-f25aea28-22e3-11e8-8a09-eb84cac6e063.jpg",
                "https://user-images.githubusercontent.com/33101796/37155601-f28b1072-22e3-11e8-8c24-0389e5f57252.jpg",
                "https://user-images.githubusercontent.com/33101796/37167136-5781b5fe-2301-11e8-9f8d-1a81fbad25dd.gif"));

        women.add(new Woman(context, R.array.ElisabetaR,
                "https://user-images.githubusercontent.com/33101796/37155602-f2ad31de-22e3-11e8-9863-15411a6d799b.jpg",
                "https://user-images.githubusercontent.com/33101796/37155603-f2cf2aa0-22e3-11e8-84bf-d819cd1b8f5f.jpg",
                "https://user-images.githubusercontent.com/33101796/37167139-589ffe78-2301-11e8-8dcb-cbed36179b0b.gif"));

        women.add(new Woman(context, R.array.EllenS,
                "https://user-images.githubusercontent.com/33101796/37155604-f2f06e40-22e3-11e8-880b-4f332abff3e6.jpg",
               "https://user-images.githubusercontent.com/33101796/37155605-f3141ea8-22e3-11e8-9584-04dfc670c363.jpg",
                "https://user-images.githubusercontent.com/33101796/37167133-570b62fa-2301-11e8-8ae9-0e684ee96513.gif"));

        women.add(new Woman(context, R.array.IlhanO,
                "https://user-images.githubusercontent.com/33101796/37155616-f96424ce-22e3-11e8-8119-a1827ccfc01a.jpg",
                "https://user-images.githubusercontent.com/33101796/37155617-f988252c-22e3-11e8-9021-3654e97c7991.jpg",
                "https://user-images.githubusercontent.com/33101796/37167142-591e49ae-2301-11e8-90d4-52b7d2c8b0de.gif"));

        women.add(new Woman(context, R.array.IrenaS,
                "https://user-images.githubusercontent.com/33101796/37155618-f9afd95a-22e3-11e8-887e-046debc80f51.jpg",
                "https://user-images.githubusercontent.com/33101796/37155619-f9e3fbea-22e3-11e8-8181-dce6c3be1383.jpg",
                "https://user-images.githubusercontent.com/33101796/37166043-4f47c19c-22fe-11e8-8803-d5c140cd754e.gif"));

        women.add(new Woman(context, R.array.MariaC,
                "https://user-images.githubusercontent.com/33101796/37155632-010456cc-22e4-11e8-8b61-efb5e033e3cd.jpg",
                "https://user-images.githubusercontent.com/33101796/37155633-012fb542-22e4-11e8-9e75-cca5fb8f75ff.jpg",
                "https://user-images.githubusercontent.com/33101796/37166043-4f47c19c-22fe-11e8-8803-d5c140cd754e.gif"));

        women.add(new Woman(context, R.array.MariaT,
                "https://user-images.githubusercontent.com/33101796/37155634-0159df84-22e4-11e8-9afd-615c272928f6.jpg",
                "https://user-images.githubusercontent.com/33101796/37155636-0184b826-22e4-11e8-9e3e-d1c6fd62d66e.jpg",
                "https://user-images.githubusercontent.com/33101796/37167130-56b11106-2301-11e8-91de-af52f890c074.gif"));

        women.add(new Woman(context, R.array.MeriemeC,
                "https://user-images.githubusercontent.com/33101796/37155637-021c5af0-22e4-11e8-904c-2d616c9d3f6d.jpg",
                "https://user-images.githubusercontent.com/33101796/37155638-02546b02-22e4-11e8-90c8-b95a060dcc7d.jpg",
                "https://user-images.githubusercontent.com/33101796/37167135-575229ba-2301-11e8-8e79-01736785d8f0.gif"));

        women.add(new Woman(context, R.array.Theresa,
               "https://user-images.githubusercontent.com/33101796/37155571-e89a038e-22e3-11e8-8f4b-61a4f8c03f4e.jpg",
                "https://user-images.githubusercontent.com/33101796/37155574-e8dc0d06-22e3-11e8-8969-59db751ea45d.jpg",
                "https://user-images.githubusercontent.com/33101796/37178246-408409ee-2322-11e8-838a-64ead5cab4f7.gif"));

        women.add(new Woman(context, R.array.TurkanS,
                "https://user-images.githubusercontent.com/33101796/37163455-1c559706-22f8-11e8-89b6-25442b0a76ee.jpg",
                "https://user-images.githubusercontent.com/33101796/37155579-e9d49c50-22e3-11e8-8b70-4301d2e5ec17.jpg",
                "https://user-images.githubusercontent.com/33101796/37167141-58fbfa5c-2301-11e8-8aea-25ee9bb4045f.gif"));

        women.add(new Woman(context, R.array.ValentinaT,
               "https://user-images.githubusercontent.com/33101796/37155580-ea4b5f5c-22e3-11e8-9e29-dd773f8a3b56.jpg",
                "https://user-images.githubusercontent.com/33101796/37155581-ea809a46-22e3-11e8-91ec-c713343df3a2.jpg",
                "https://user-images.githubusercontent.com/33101796/37167140-58d6ee4c-2301-11e8-9113-55199a8bef63.gif"));

        women.add(new Woman(context, R.array.WandaR,
                "https://user-images.githubusercontent.com/33101796/37155582-eab0efa2-22e3-11e8-9481-799d5d2a47a1.jpg",
                "https://user-images.githubusercontent.com/33101796/37155583-eadf4d70-22e3-11e8-984e-e3de4a87af4a.jpg",
               "https://user-images.githubusercontent.com/33101796/37166043-4f47c19c-22fe-11e8-8803-d5c140cd754e.gif"));

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


