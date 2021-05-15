package list;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        /*
        * [Sally,小白，大师兄，King]
        * []
        * */
        list.add("sally");
        list.add("小白");
        list.add("大师兄");
        list.add("King");

         // System.out.println(list.toString());
//        System.out.println("size():"+list.size());
//        System.out.println("get(2):"+list.get(2));
//        System.out.println("get(0):"+list.get(0));
//        System.out.println("get(4):"+list.get(4));
//        System.out.println("remove(0)"+list.remove(0));

        list.add(2,"花花");
        System.out.println(list);

    }
}
