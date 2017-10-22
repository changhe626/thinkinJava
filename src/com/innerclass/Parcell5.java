package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 */
public class Parcell5 {

    public Destination destination(String s){

        /**
         * 方法内部进行内部类的实现，作为返回，封装更加好
         */
        class PDestination implements  Destination{
            private String s;

            public PDestination(String s) {
                this.s = s;
            }

            @Override
            public String readLabel() {
                return s;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcell5 parcell5 = new Parcell5();
        Destination sasa = parcell5.destination("sasa");
        System.err.println(sasa.readLabel());
    }


}
