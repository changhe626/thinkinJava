package thread.book2.char0_3;

import java.util.concurrent.locks.ReentrantLock;

public class 锁内存予以的实现 {
    int a=0;
    ReentrantLock lock=new ReentrantLock();

    public void write(){
        lock.lock();
        try{
            a++;
        }finally {
            lock.unlock();
        }
    }


    public void read(){
        lock.lock();
        try{
            int i=a;
        }finally {
            lock.unlock();
        }
    }


}
