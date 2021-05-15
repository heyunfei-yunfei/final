package queue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 日志工具类
 */
public class Logger {
    //阻塞队列
    private BlockingQueue<String> bq;
    //文件输出流
    private PrintWriter out;

    /**
     * 为记日志做准备工作，主要包含三件事：
     * 1.创建一个指向日志文件的输出流。
     * 2.创建一个阻塞队列（用于存放日志信息）。
     * 3.启动记日志线程
     */
    public void open() throws FileNotFoundException {
        //1.创建一个指向日志文件的输出流
        out = new PrintWriter("log.txt");
        //2.创建一个阻塞队（用于存放日志信息）
        bq = new LinkedBlockingDeque<>(1000);//1000个字符串
        //t是用于记日志的线程
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        //从阻塞队列中取日志信息
                        String info = bq.take();
                        //将日志信息写入日志信息
                        out.print(info);
                        System.out.println("日志信息："+info+"已经写日志文件");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //将t线程设置成守护线程（发现只有守护线程在启动的时候就关闭）
        t.setDaemon(true);
        //启动记日志的线程；
        t.start();
    }

    /**
     * 记日志的方法
     * @param info  日志信息
     *              将日志信息写到队列中
     */
    public void log(String info) throws InterruptedException {
        bq.put(info);
        System.out.println("日志信息："+info+"添加到了阻塞队列");
    }
    //关闭资源的方法
    public void close(){
        if (out!=null){
            out.close();
        }
    }
}
