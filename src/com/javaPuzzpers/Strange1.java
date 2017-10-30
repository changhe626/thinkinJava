package com.javaPuzzpers;

/**
 * Created by zk on 2017/10/30.
 * 作用: com.javaPuzzpers.
 */
public class Strange1 {
    public static void main(String[] args) {
        //在missing类丢失之后,抛出未被捕获的NoClassDefFoundError
        try{
            Missing missing = new Missing();
        }catch (NoClassDefFoundError e){
            System.out.println("发生了异常了");
        }
    }
}


class Strange2{
    public static void main(String[] args) {
        Missing missing;
        try{
            missing = new Missing();
        }catch (NoClassDefFoundError ex){
            //这里捕获异常,NoClassDefFoundError 这个异常能够捕获到!!!
            System.out.println("你好,这是第二个类的异常,已经发洪水能了");
        }

    }

}



class Missing{

}
