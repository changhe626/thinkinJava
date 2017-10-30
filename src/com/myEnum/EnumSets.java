package com.myEnum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class EnumSets {

    public static void main(String[] args) {
        EnumSet<Single> set=EnumSet.noneOf(Single.class);

       set.add(Single.GREEN);
       set.add(Single.RED);
        set.add(Single.YELLO);
        System.out.println(set);


        System.out.println("~~~~~~~~~~~~~~`");

        EnumMap<Single, String> map = new EnumMap<Single, String>(Single.class);
        map.put(Single.GREEN,"2");
        map.put(Single.RED,"1");
        map.put(Single.YELLO,"3");
        for (Map.Entry<Single, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }



    }
}
