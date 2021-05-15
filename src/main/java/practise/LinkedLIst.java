package practise;

public class LinkedLIst <E>{
    private Node head;
    private int size=0;
    class Node{
        Node next;
        Node prev;
        E data;

        public Node(E e) {
            data = e;
        }
    }
    public boolean add(E e){
        Node node = new Node(e);
        if (head==null){
            head=node;
            head.next=head;
            head.prev=head;
            size++;
            return true;
        }
        Node last = head.prev;
        last.next=node;
        node.next=head;
        head.prev=node;
        node.prev=last;
        size++;
        return true;
    }
    public E get(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node node = getNode(index);
        return node.data;
    }

    private Node getNode(int index) {
        Node node = head;
        if (index<size>>1){
            for (int i=0;i<index;i++){
                node = node.next;
            }
        }else{
            for (int i =size; i >index ; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public E remove(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        if (size==1){
            E data = head.data;
            head=null;
            size--;
            return data;
        }
        Node node = getNode(index);
        Node pre = node.prev;
        Node next = node.next;
        pre.next=next;
        next.prev=pre;
        if (index==0){
            head=next;
        }
        return node.data;
    }
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        if (index==size) {
            add(e);
            size++;
        }
        Node node = new Node(e);
        Node next = getNode(index);
        
    }

    public int size(){
        return size;
    }
}
