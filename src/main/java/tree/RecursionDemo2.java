package tree;

/**
 * 演示递归的使用
 */
public class RecursionDemo2 {
    public static int fb(int n){
        if (n==1||n==2){
            return 1;
        }
        return fb(n-1)+fb(n-2);
    }

    public static void main(String[] args) {
        int h = fb(5);
        System.out.println(h);
    }



}