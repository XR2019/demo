package demo.线程的创建方式;

public class ThreadNoName {

    public static void main(String[] args) {
        //1.使用继承加匿名内部类的方式创建线程
        Thread t1 = new Thread(){
            //重写run方法

            @Override
            public void run() {
                System.out.println("张三说在吗？");
            }
        };
        t1.start();
        System.out.println("=======================================");
        //2.使用实现接口的方式加匿名内部类的方式创建线程
        Runnable ra = new Runnable() {
            @Override
            public void run() {
                System.out.println("李四说不在！！");
            }
        };
        Thread thread = new Thread(ra);
        thread.start();
    }

}
