package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解默认情况下，只会保留到字节码文件里面，也就是说，在运行期间会被抹掉。可以使用@Retention元注解来指定
 * 注解的生存时间。
 * RetentionPolicy.RUNTIME:将注解保留到运行时，也就是说，在运行期间仍然可用。
 * RetentionPolicy.CLASS:是缺省值，将注解保留到字节码文件里面。
 * RetentionPolicy.SOURCE：将注解只保留到源代码里面，编译之后，会被抹掉，也就是
 * 说，在字节码文件里面就已经没有该注解了。
 *
 * 元注解：指的是由系统提供，并且用来解释其他注解的注解。
 *
 * @Target 元注解用来指定注解的适用范围。
 * ElementType.METHOD表示该注解只能用在方法前。
 */
@Retention(RetentionPolicy.RUNTIME)//保留到运行期间（枚举类型）
@Target({ElementType.METHOD})//范围(放在方法前面可用)
public @interface Test {

   /*
   value是一个属性，类型是String。
   (了解)
   注解的属性类型可以是String，基本类型，枚举类型，class，
   以及由这些类型构成的数组

   如果注解的属性名为value，并且满足如下两个条件之一，就可以在使用该注解时，不用指定属性名。
   条件1：该注解只有value这一个属性。
   条件2：该注解还有其它属性，但是，其它属性在使用时，使用其缺省值（默认值）。
    */
    public String value ();
    public int version()default 100;

}
