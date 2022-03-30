package demo.生产者消费者模型实现;

/*
    编程实现生产者
 */
public class ProduceThread extends Thread{

    private StoreHourse storeHourse;  //声明一个仓库类型的引用作为成员变量，为了调用仓库类中的生产方法
    //为了确保两个线程公用一个仓库
    public ProduceThread(StoreHourse storeHourse) {
        this.storeHourse = storeHourse;
    }
    @Override
    public void run() {
        while (true) {
            storeHourse.produceProduct();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
