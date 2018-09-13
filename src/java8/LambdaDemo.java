package java8;

/**
 * @author zk
 * @Description:
 * @date 2018-09-04 10:57
 */
public class LambdaDemo {

    public static void main(String[] args) {

        // 类型声明,后面接收的必须是个接口...,然后调用的还是接口中的方法
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation min=(a,b)->a-b;

        MathOperation mul=(a,b)->{
            //return 不能少
            return a*b;
        };

        Runnable task=()->{
            System.out.println("这是多线程的任务");
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是多线程的任务2");
            }
        };


        GreetingService greetingService=message -> {
            System.out.println("shi:"+message);
        };

        GreetingService greetingService2=message -> System.out.println("shi:"+message);


        System.out.println(addition.operation(1,5));
        System.out.println(min.operation(4,9));
        System.out.println(mul.operation(3,8));

        greetingService.sayMessage("zhaojun");

        greetingService2.sayMessage("zhaojun2");


        LambdaDemo demo = new LambdaDemo();




    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


}

