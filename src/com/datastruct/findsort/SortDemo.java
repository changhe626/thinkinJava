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


    public static void insetSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int datum = data[i];
            int position=i;
            while(position>0 && data[position-1]>datum){
                data[position]=data[position-1];
                position--;
            }
            data[position]=datum;
        }
    }


    public static void bubbleSort(int[] data){
        int position,scan;
        int temp;
        for (position = data.length-1; position >=0 ; position--) {
            for (scan = 0; scan <=position-1; scan++) {
                if(data[scan]>data[scan+1]){
                    //swap values
                    temp=data[scan];
                    data[scan]=data[scan+1];
                    data[scan+1]=temp;
                }
            }
        }
    }



}
