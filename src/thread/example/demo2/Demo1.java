package thread.example.demo2;

public class Demo1 {

    public static void main(String[] args) {

        Thread runable = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this thread  is running");
            }
        });
        runable.start();
    }

}
