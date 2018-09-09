package java8.function_code;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo5 {
    public static void main(String[] args) {

        //方法引用
        IntConsumer aNew = String[]::new;
        System.out.println(aNew);

        Runnable runnable = "a"::toUpperCase;
        //什么都没有打印出啊...
        new Thread(runnable).start();


        TreeSet<String> collect = Stream.of("a", "b", "d", "a").collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);

        HashMap<String, String> map = new HashMap<>();
        map.put("1","4");
        map.put("2","3");

        //map的遍历
        map.forEach((key,value)->{
            System.out.println(key+"~~"+value);
        });
    }
}
