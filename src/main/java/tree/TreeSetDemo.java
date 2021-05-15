package tree;

import java.util.TreeSet;

/**
 * 演示红黑树的特点
 * 注：
 * TreeSet去调TreeMap（红黑树）对象的方法来添加数据，删除数据，修改数据。
 * TreeMap是一颗红黑树
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(88);
        treeSet.add(66);
        treeSet.add(33);
        treeSet.add(20);
        treeSet.add(8);
        treeSet.add(2);


    }
}
