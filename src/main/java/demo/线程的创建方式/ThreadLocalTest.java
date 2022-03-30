package demo.线程的创建方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //向线程池中布置任务
        threadPool.submit(new ThreadCallableTest());
        //关闭线程池
        threadPool.shutdown();
    }
}
