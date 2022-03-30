package demo.线程的创建方式;

import javax.swing.plaf.TableHeaderUI;

public class ThreadCommunicateTest implements Runnable{

    private int cnt = 1;
    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                //在线程2进来同步代码块后需要唤醒线程一
                notify();
                if (cnt <= 100) {
                    System.out.println("线程："+Thread.currentThread().getName()+"中：cnt的值："+cnt);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    //当前线程打印完毕一个整数之后，为了防止继续打印下一个数据，则需要调用wait方法
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadCommunicateTest communicateTest = new ThreadCommunicateTest();
        Thread thread = new Thread(communicateTest);
        thread.start();

//        ThreadCommunicateTest communicateTest1 = new ThreadCommunicateTest();
        Thread thread1 = new Thread(communicateTest);
        thread1.start();
    }
}
