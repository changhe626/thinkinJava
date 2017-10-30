package com.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zk on 2017/10/25.
 * 作用: com.datastruct.
 */
public class Game {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapC = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapD = new HashMap<Integer, Integer>();
        //首先计算A的
        for (int i = 0; i < arr.length; i++) {
            int tmp=10-arr[i];
            if(tmp>5){
                mapA.put(arr[i],tmp);
            }
            //计算C/D
            for (int j = 0; j < arr.length; j++) {
                //C
                if(i<=5){
                    if(arr[i]*arr[j]==24){
                        mapC.put(arr[i],arr[j]);
                    }
                }
                //D
                if(arr[i]/arr[j]==3){
                    mapD.put(arr[i],arr[j]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i];
            if(mapA.containsKey(temp)){
                if((!mapB.containsKey(temp)) && (!mapB.containsValue(mapB.get(temp)))){

                }
            }



        }






    }




}
