package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");

        //增强for循环   快捷键:iter
        for (String listCom : list) {
            System.out.println(listCom);
        }

        //jdk1.8
        List<String> list2 = Stream.of("1", "b", "d").collect(Collectors.toList());

        //1.8
        list.stream().forEach(e-> System.out.println(e));

        int i=5;
        Integer integer = new Integer(5);
        int i1 = integer.intValue();

        print("1","c","c");
        print("1");
        print("1","c");

    }


    //可变参数
    public static void print(String...tmp){
        byte[] bytes = new byte[4];
        System.out.println(bytes.length);

        System.out.println("长度是:"+tmp.length);
        for (String s : tmp) {
            System.out.println("结果是:"+s);
        }
    }

}
