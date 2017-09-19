package com.datastruct.findsort;

public class SortDemo {

    public static void selectionSort(int[] data){
        int min;
        for (int i = 0; i < data.length-1; i++) {
            min=data[i];
            for (int j = 1; j <data.length; j++) {
                if(data[j]<data[min]){
                    min=j;
                }
            }

            //swap values
            int temp=data[min];
            data[min]=data[i];
            data[i]=temp;
        }
    }
}
