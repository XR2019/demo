package demo.生产者消费者模型实现;

public class StoreHouseTest {

    public static void main(String[] args) {
        //创建仓库类对象
        StoreHourse storeHourse = new StoreHourse();
        //创建线程类对象并启动
        ProduceThread t1 = new ProduceThread(storeHourse);
        ConsumerThread t2 = new ConsumerThread(storeHourse);
        t1.start();
        t2.start();
    }
}
