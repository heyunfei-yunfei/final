package queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 演示阻塞队列的基本用法
 *      在java.util.concurrent包下面，提供了一个接口（BlockingQueue）,
 *      该接口主要定义了两个阻塞方法(take,put)，分别用于向阻塞队列中添加数据和获取数据。
 *      该接口有两个主要的实现类，分别是LinkedBlockingQueue（底层的实现是一个链表）
 *      和ArrayBlockingQueue(底层的实现是一个数组)
 */
public class LinkedBlockingQueueDemo {
    private static BlockingDeque<String> bq = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        // 创建消费者线程
        Thread t = new Thread() {
            @Override
            public void run() {
                try {

                        System.out.println("消费者线程准备从阻塞队列中获取数据....");
                        String data=bq.take();
                        System.out.println("消费者线程获取到的数据是"+data);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //启动消费者线程
        t.start();
        try {


                Thread.sleep(8000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //main线程充当生产者
        try {

                bq.put("babababababa");
                System.out.println("生产者队列向阻塞对列中添加了一些数据");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}