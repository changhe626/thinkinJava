package com.datastruct.findsort;

/**
 *
 */
public class FindDemo {


    public static  boolean binarySearch(int[] data,int min,int max,int target){
        boolean found=false;
        int mindpoint=(min+max)/2;

        if(data[mindpoint]==target){
            found=true;
        }else if(data[mindpoint]>target){
            if(min<=mindpoint-1){
                found=binarySearch(data,min,mindpoint-1,target);
            }else if(mindpoint+1<=max){
                found=binarySearch(data,mindpoint+1,max,target);
            }
        }
        return found;
    }
}
