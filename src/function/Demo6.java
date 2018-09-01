package function;

import java.util.List;

public class Demo6 {
    /**
     * 并行求和
     */
    public int add(List<Integer> list){
        int sum = list.parallelStream().mapToInt(x -> x).sum();
        return sum;
    }




}
