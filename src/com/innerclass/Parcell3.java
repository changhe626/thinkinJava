package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 * 内部类是依存外部类的实例而存在的，使用new 的时候要加上外部类的实例
 */
public class Parcell3 {
    class Contents{
        private int i=11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private  String label;
        public String getLabel(){
            return label;
        }
        public Destination(String label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        Parcell3 p = new Parcell3();
        Contents contents = p.new Contents();
        Destination destination = p.new Destination("ss");

    }
}
