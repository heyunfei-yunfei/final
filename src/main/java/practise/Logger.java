package practise;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
    private static BlockingQueue<String> bq ;
    private static PrintWriter pw ;
    public void open () throws FileNotFoundException {
        bq = new LinkedBlockingQueue<>(1000);
        pw = new PrintWriter("花和尚鲁智深.text");
            Thread t = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println("消费者线程开始从阻塞队列获取数据。。。。");
                            String info = bq.take();
                            pw.println(info);
                            System.out.println("日志：" + info + "已经写到了文件中");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.setDaemon(true);
            t.start();
    }
    public void log(String info) throws InterruptedException {
        System.out.println("生产者线程开始向阻塞队列添加数据");
        bq.put(info);
        System.out.println("添加的数据为："+info);
    }
    public void close(){
        if (pw!=null){
            pw.close();
        }
    }
}
