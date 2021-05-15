package listpractise;

public class LinkedList1<E> {
   private Node head;
   private int size=0;
   class Node{
       E data;
       Node next;
       Node pre;

       public Node(E e) {
           data = e;
       }
   }
   public boolean add(E e){
      Node node = new Node(e);
      if (head==null){
          head=node;
          head.next=head;
          head.pre=head;
          size++;
          return true;
      }
      Node last = head.pre;
      last.next=node;
      node.next=head;
      head.pre=node;
      node.pre=last;
      size++;
      return true;
   }
   public E get(int index){
     if (index<0||index>size){
         throw new IndexOutOfBoundsException("下标越界");
     }
       Node node = getNode(index);
       return node.data;
   }

    private Node getNode(int index) {
        Node node = head;
        if (index<size>>1){
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
        }else {
            for (int i = size; i <index ; i--) {
                node=node.pre;
            }
        }
        return node;
    }
    public E remove(int index){
     if (index<0||index>=size){
                throw new IndexOutOfBoundsException("下标越界");
            }
     if (size==1){
         E data=head.data;
         head=null;
         size--;
         return data;
     }
    Node node=getNode(index);
     Node pre = node.pre;
     Node next = node.next;
     next.pre= pre;
     pre.next=next;

         return node.data;

   }

    public int size(){
    return size;
}
}