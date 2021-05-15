package tree;

/**
 * 演示递归的使用
 */
public class RecursionDemo {
    //计算一个数的阶乘

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }


    public static void main(String[] args) {
        RecursionDemo recursionDemo = new RecursionDemo();
        int h=recursionDemo.f(10);
        System.out.println(h);
    }
}