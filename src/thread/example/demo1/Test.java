package thread.example.demo1;

public class Test {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());//  main
        System.out.println(Thread.currentThread().getId());  //1
        System.out.println(Thread.currentThread().getState());  //RUNNABLE
    }
}
