package demo.线程的创建方式;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        //打印1-20之间的所有整数
        for (int i=1;i<21;i++) {
            System.out.println("run方法执行了：" + i);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.start();
        for (int i =1;i<21;i++) {
            System.out.println(i);
        }
    }
}
