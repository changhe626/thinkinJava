package com.javaweb;

/**
 * Created by zk on 2017/10/30.
 * 作用: com.javaweb.
 */
public class CompileDemo {

    public static void main(String[] args) {

        int compile = compile(new String[]{"1","2"});
        System.out.println(compile);
    }

    public static int compile(String[] args){
       // com.sun.tools.javac.main.Main compiler = new com.sun.tools.javac.main.Main("javac");
       // return compiler.compile(args).exitCode;
        return -1;
    }


}
