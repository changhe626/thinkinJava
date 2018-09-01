package function;

import java.util.function.BinaryOperator;

public class Demo2 {

    public static void main(String[] args) {

        //第一种不带参数
        Runnable mulistatement = () -> {
            System.out.println("hello world");
        };

        new Thread(mulistatement).start();


        //带参数的,常见的形式是这样的
        BinaryOperator<Long> add=(x,y)->x+y;
        //也可以写成
        BinaryOperator<Long> add2=(Long x,Long y)->x+y;


        //调用上面的函数....
        Long apply = add.apply(3L, 4L);
        System.out.println(apply);

        Long apply2 = add2.apply(4L, 8L);
        System.out.println("apply2="+apply2);



    }
}

