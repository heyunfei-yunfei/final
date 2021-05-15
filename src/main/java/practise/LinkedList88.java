package practise;

public class LinkedList88<E> {
    private Node head;
    private int size=0;
    class Node{
        E data;
        Node next;
        Node prev;

        public Node(E e) {
            data = e;
        }
    }
    public boolean add(E e){
        Node node = new Node(e);
        if (head==null){
            head=node;
            head.next = head;
            head.prev=head;
            size++;
            return true;
        }
        Node last = head.prev;
        last.next = node;
        node.next = head;
        head.prev = node;
        node.prev = last;
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
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }else{
            for (int i=size;i>index;i--){
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
        Node next = node.next;
        Node pre = node.prev;
        next.prev=pre;
        pre.next = next;
        if (index==0){
            head = next;
        }
        size--;
        return node.data;
    }
    public void add(int index,E e){
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node node = new Node(e);
        if (index==size){
            add(e);
            size++;
        }
        Node next = getNode(index);
        Node pre = next.prev;
        next.prev=node;
        node.prev=pre;
        pre.next=node;
        node.next=next;
        if (index==0){
            head=node;
        }
        size++;
    }

    public int size(){
        return size;
    }
}
