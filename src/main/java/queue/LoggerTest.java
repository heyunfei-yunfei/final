package queue;

import java.io.FileNotFoundException;

public class LoggerTest {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Logger logger = new Logger();
        logger.open();
        logger.log("Hello");
        logger.log("您好");
        logger.log("嗯哼");
        logger.log("拜拜");
        Thread.sleep(5000);
        logger.close();
    }
}
