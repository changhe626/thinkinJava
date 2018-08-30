package thread.example.demo2;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Demo7Task task = new Demo7Task();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}


class  Demo7Task  implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("i="+i);
        }
    }
}
