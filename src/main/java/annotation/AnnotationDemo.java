package annotation;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 演示如何获得java注解，并且进行相应的处理
 * 就是使用反射机制
 */
public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method mh:methods){
            //获得加载方法前的某个注解（比如，获得@Test注解）
            Test test = mh.getAnnotation(Test.class);
            System.out.println("test:"+test);
            //只执行带有@Test注解的方法
            if (test!=null){
                mh.invoke(obj);
                //获得注解的属性值
                String v1 = test.value();
                System.out.println("v1:"+v1);
                int v2  = test.version();
                System.out.println("v2:"+v2);
            }
        }
    }
}
