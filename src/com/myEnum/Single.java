package com.myEnum;

import org.junit.Test;

public enum Single {

    RED,GREEN,YELLO;
}

class TrafficLight{

    public static void main(String[] args) {
        for (Single single : Single.values()) {
            change(single);
        }
    }


    public  static void change(Single color){
        switch(color){
            case RED:
                System.out.println("red");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case YELLO:
                System.out.println("yello ");
                break;
             default:
                 break;
        }
    }



}
