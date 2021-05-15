package reflect1;
//演示如何使用java反射机制将一个类实例化，并且调用其方法

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //通过控制台读取类名
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println("className:"+className);
        //加载类
        Class clazz = Class.forName(className);
        System.out.println("clazz:"+clazz);
        //实例化
        Object obj = clazz.newInstance();
        /*获得该类的所有方法
        * Method对象可以用来获得对应方法的所有信息，包含方法名。
        * 参数类型，返回类型。相关的注解等等*/
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        //遍历所有方法
        for (Method mh:methods){
            //调用方法
            /*目标方法：(mh)利用反射机制要去调用的方法
            * 目标对象：(obj)该方法所对应的那个java对象。
            *rv：是目标方法的返回值
            *  */
            Object rv = null;
            //先获得目标方法的参数类型信息
            //String.class,int.class
            Class[] types = mh.getParameterTypes();
            if (types.length==0){
                //目标方法不带参
                rv = mh.invoke(obj);
                System.out.println("rv:"+rv);
            }else{
                //目标方法带参par
               // rv = mh.invoke()
            }


        }
    }

}
