package thread.onyx.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo1  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < 3; i++) {
            MyTask myTask = new MyTask("任务" + i);
            Future submit = service.submit(myTask);
            futures.add(submit);
        }
        service.shutdown();
        for (Future future : futures) {
            System.out.println(future.get().toString());
        }

    }


}

class MyTask implements Callable{
    private String name;

    public MyTask(String name) {
        this.name = name;
    }


    public Object call() throws Exception {
        System.out.println("开始了任务"+name);

        Thread.sleep(1000);
        return name+"---这是返回值";
    }
}



