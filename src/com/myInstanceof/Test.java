package com.myInstanceof;

/**
 * Created by zk on 2017/10/17.
 * 作用: com.inof.
 */
public class Test {

    @org.junit.Test
    public void test1(){
        User user = new User();
       // System.out.println(user instanceof  User);
      //  System.out.println(new Integer(1) instanceof  Number);
       // System.out.println("".getClass()); //class java.lang.String
       // System.out.println("" instanceof  String);
       // System.out.println(new String("s") instanceof  String);


        UserA a = new UserA();
        //System.out.println(User.class.isInstance(a));
       // System.out.println(A.class.isInstance(a));


        //System.out.println(new int[4] instanceof Object);

        /**
         * 因为左边是null,所以直接返回false了
         */
        //System.out.println(null instanceof  Void);


        //AA BB CC DD
        Object o=new DD();
        System.out.println(o instanceof BB);

    }
}
