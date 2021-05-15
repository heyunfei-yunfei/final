package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 演示如何使用java反射机制将一个类例化，并且
 * 调用其方法。
 */
public class ReflectDemo {
    public static void main(String[] args)
            throws Exception {
        //通过控制台读取类名
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println("className:"  + className);
        //加载类
        Class clazz = Class.forName(className);
        System.out.println("clazz:" + clazz);
        //实例化
        Object obj = clazz.newInstance();
        /*
            获得该类的所有方法。
            Method对象可以用来获得对应方法的所有信息，包含方法名、
            参数类型、返回类型、相关的注解等等。
         */
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("methods:" + methods.length);
        //遍历所有方法
        for(Method mh : methods){
            mh.getName();
            /*
                目标方法：利用反射机制要去调用的方法。
                目标对象：该方法所对应的那个java对象。
                rv:是目标方法的返回值　
             */
            Object rv = null;
            //先获得目标方法的参数类型信息
            // String.class,int.class
            Class[] types = mh.getParameterTypes();
            if(types.length == 0){
                //目标方法不带参
                rv = mh.invoke(obj);
            }else{
                //目标方法带参,params是一个数组，用来存放实际参数值
                Object[] params = new Object[types.length];
                //依据目标方法的参数类型进行相应的赋值
                for(int i = 0; i < types.length; i ++){
                    if(types[i] == String.class){
                        params[i] = "你好";
                    }
                    if(types[i] == int.class){
                        params[i] = 100;
                    }
                }
                rv = mh.invoke(obj,params);
            }
            System.out.println("rv:" + rv);
        }

    }
}
