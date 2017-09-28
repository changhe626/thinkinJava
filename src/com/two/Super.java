package com.two;

public class Super {
    public int field=0;
    public int getField(){
        return  field;
    }

    public  static  void main(String[] args){
        Super s=new Sub();
        System.out.println(s.field+""+s.getField());
    }


}


class Sub extends  Super{
    public int field=5;

    public int getField() {
        return field;
    }

    public int getSuperField(){
        return  super.getField();
    }
}
