package thread.book2.char0_3;

public class 重排序对多线程的影响 {

    int a=0;
    boolean flag=false;

    public void writer(){
        a=1;
        flag=true;
    }

    public void read(){
        if(flag){
            int i=a*a;
        }
    }


}
