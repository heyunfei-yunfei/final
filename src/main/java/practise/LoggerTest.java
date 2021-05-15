package practise;

import java.io.FileNotFoundException;

public class LoggerTest {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Logger logger = new Logger();
        logger.open();
        logger.log("秋水共长天一色，落霞与孤鹜齐飞");
        logger.log("古道西风瘦马，小桥流水人家");
        logger.log("陪我你的心做纪念，风浪再大，我们的爱想青春纪念册");
        Thread.sleep(5000);
        System.out.println("写入数据完毕");
        logger.close();
    }

}
