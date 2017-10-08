package com.annotation;

/**
 * Created by zk on 2017/10/8.
 * 作用: com.annotation.
 */
public class PasswordUtils {

    @UseCase(id=4,description = "one")
    public boolean test1(String password){
        return false;
    }


    @UseCase(id=2)
    public void test2(){

    }

    @UseCase(id=3,description = "the third")
    public void test3(){

    }

}
