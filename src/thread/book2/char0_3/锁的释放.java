package thread.book2.char0_3;

public class 锁的释放 {
    private    int a=0;

    public static void main(String[] args) {

        锁的释放 demo = new 锁的释放();
        demo.write();
        demo.read();


    }

    public synchronized void write(){
        a++;
    }

    public synchronized void read(){
        int i=a;
        System.out.println(i);

    }

}
