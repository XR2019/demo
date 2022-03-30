package demo.线程的创建方式;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i =0;i<100;i++) {
            if (i % 2 ==0) {
                //打印偶数
                System.out.println("i = :"+i);
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
    }
}
