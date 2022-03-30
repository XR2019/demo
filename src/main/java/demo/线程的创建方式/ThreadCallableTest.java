package demo.线程的创建方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        //计算1到10000之间的累加和并打印返回
        int sum = 0;
        for (int i=1;i<=10000;i++) {
            sum+=i;
        }
        System.out.println("计算的累加和为：" + sum);
        return sum;
    }

    public static void main(String[] args) {
        ThreadCallableTest callableTest = new ThreadCallableTest();
        FutureTask futureTask = new FutureTask(callableTest);
        //启动线程
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Integer o = (Integer) futureTask.get();
            System.out.println("线程处理方法的返回值为："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
