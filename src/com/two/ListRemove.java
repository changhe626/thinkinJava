package com.two;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListRemove {
    public static void main(String[] args) {

        List<String> list = Stream.of("2", "3").collect(Collectors.toList());
        /*for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if("2".equals(next)){
                iterator.remove();
            }
            if("3".equals(next)){
                System.out.println("ok, remove it");
            }
        }*/


        for (String s : list) {
            if("2".equals(s)){
                list.remove(s);
            }
            System.out.println("it it over");
            if("3".equals(s)){
                System.out.println("ok, remove it");
            }
        }










    }


}



