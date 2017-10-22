package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 * 使用了private和protected来进行内部类的封装，避免外部的访问
 */
public class Parcell4 {

    private class PContents implements Contents{

        private int i=11;
        @Override
        public int value() {
            return i;
        }
    }


    protected class PDestination implements Destination{
        private String label;
        public PDestination(String label) {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }

    public static void main(String[] args) {
        Parcell4 p = new Parcell4();
        Contents contents = p.contents();
        Destination destination = p.destination("sasa");


    }
}
