package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Demo3 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);

        //元素总个数
        long count = list.stream().count();
        System.out.println(count);

        //统计其中偶数的个数
        long count1 = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println("偶数有:"+count1);

        //生成一个列表
        List<String> collect = Stream.of("a", "c", "d", "t").collect(Collectors.toList());
        System.out.println(collect);

        //Map方法,对每个元素进行操作...
        List<String> collect1 = Stream.of("a", "b", "c").map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect1);

        //Filter过滤,第一个字符是数字的..
        List<String> fa = Stream.of("1", "3d", "fa", "6").filter(x -> Character.isDigit(x.charAt(0))).collect(Collectors.toList());
        System.out.println(fa);

        //flatMap
        List<Integer> collect2 = Stream.of(Arrays.asList(1, 3), Arrays.asList(4, 6)).flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(collect2);


        //获取长度最小值,或者最大的,max,min
        String s = Stream.of("a", "ds", "sas", "dsa").max(Comparator.comparing(x -> x.length())).get();
        System.out.println(s);


        Integer reduce = Stream.of(1, 4, 6, 8).reduce(0, (acc, element) -> acc + element);
        System.out.println(reduce);





    }


}
