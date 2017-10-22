package com.innerclass;

import jdk.jshell.DeclarationSnippet;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 * 内部类的示例
 */
public class Parcell {
    class Contents{
        private int i=10;
        public int value(){
            return i;
        }
    }


    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }
        String readLabel(){
            return label;
        }
    }

    public Contents contents(){
        return new Contents();
    }

    public Destination to(String s){
        return  new Destination(s);
    }


    public void ship(String dest){
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.err.println(destination.readLabel());
    }

    public static void main(String[] args) {
       Parcell parcell = new Parcell();
        parcell.ship("hahah");

        Parcell p2=new Parcell();
        Contents contents = p2.contents();
        Destination destination = p2.to("zhaojun");
        String s = destination.readLabel();
        System.err.println(s);


    }


}
