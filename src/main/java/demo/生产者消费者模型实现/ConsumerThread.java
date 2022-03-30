package demo.生产者消费者模型实现;

public class ConsumerThread extends Thread{

    private StoreHourse storeHourse;
    public ConsumerThread(StoreHourse storeHourse) {
        this.storeHourse = storeHourse;
    }
    @Override
    public void run() {
        while (true) {
            storeHourse.consumerProduct();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
