package hash;

import java.util.HashMap;

/**
 * 演示散列表的工作原理
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(65);
        map.put("Sally",1);
        map.put("King",2);
        map.put("李白",3);
        map.put("大师兄",4);
        map.put("孙二娘",5);
        map.put("张飞",6);
        map.put("关羽",7);
        map.put("刘备",8);
        map.put("曹操",9);
        map.put("孙策",10);
        map.put("孙权",11);
        map.put("程昱",12);
        map.put("贾诩",13);
        map.put("荀彧",14);
    }
}
