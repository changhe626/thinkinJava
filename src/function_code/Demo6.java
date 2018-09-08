package function_code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
    /**
     * 并行求和
     */
    public  static int add(List<Integer> list){
        int sum = list.parallelStream().mapToInt(x -> x).sum();
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 4, 6, 8, 5).collect(Collectors.toList());
        System.out.println(add(collect));
    }




}
