package thread.example.demo2;

public class Demo3 {

    public static void main(String[] args) {
        Demo3Task task = new Demo3Task();
        Thread thread = new Thread(task,"A");
        Thread thread2 = new Thread(task,"B");
        thread.start();
        thread2.start();

    }

}


class  Demo3Task  implements Runnable{

    private int count=7;

    @Override
    public synchronized  void run() {
        while (count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }

    }
}