package practise;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger2 {
   private BlockingQueue<String> bq;
   private PrintWriter pw;
   public void open() throws FileNotFoundException {
       bq = new LinkedBlockingQueue<>(1000);
       pw = new PrintWriter("古诗词.txt");
       Thread t = new Thread(){
           @Override
           public void run() {
               try {
                   System.out.println("日志线程开始从阻塞队列中获取数据。。。");
                   String info = bq.take();
                   pw.println(info);
                   System.out.println("日志文件"+info+"已经写入到文件中");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };
       //设置为守护线程
       t.setDaemon(true);
       t.start();
   }
   public void log(String info) throws InterruptedException {
       bq.put(info);
       System.out.println("生产线程开始向阻塞队列中添加数据");
   }
   public void close(){
       if (pw!=null){
           pw.close();
       }
   }
}
