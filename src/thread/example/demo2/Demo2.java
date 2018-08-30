package thread.example.demo2;

public class Demo2 extends  Thread {

    private int i=5;

    public Demo2(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while (i>0){
            i--;
            System.out.println("from "+Thread.currentThread().getName()+",count--"+i);
        }
    }


    public static void main(String[] args) {
        Demo2 a = new Demo2("A");
        Demo2 b = new Demo2("B");
        Demo2 c = new Demo2("C");
        a.start();
        b.start();
        c.start();


    }


}
