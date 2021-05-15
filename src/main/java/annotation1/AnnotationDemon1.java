package annotation1;

import java.lang.reflect.Method;
import java.util.Scanner;

public class AnnotationDemon1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        //加载类
        Class clazz = Class.forName(className);
        //实例化
        Object obj = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method mth:methods){

        }
    }
}
