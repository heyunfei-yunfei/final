package list;
/**
 * 双向循环链表类
 * */
public class LinkedList<E> {

    //head用于存放头节点的引用
    private Node head;
    //存放链表的长度
    private int size=0;
    /*
    Node 类用于描述链表中的某个节点
    其中，data用于存放数据（即元素），
    next和prev用于存放其后继结点和
    前驱结点的引用
    * */
    class Node{
     E data;
     Node next;
     Node prev;

        public Node(E e) {
            data = e;
        }
    }

    /**
     * 将元素添加到链表的末尾
     * @param e 要添加的元素
     * @return 添加成功，返回true
     */
    public boolean add(E e){
        //将元素封装成节点
        Node node = new Node(e);
        //如果链表为空，则新节点成为头结点
        if (head==null){
            head=node;
            head.next=head;
            head.prev=head;
            size++;
            return true;
        }

        //找到尾结点
        Node last = head.prev;
        last.next=node;
        node.next=head;
        head.prev=node;
        node.prev=last;
        size++;
        return true;
    }

    @Override
    public String toString() {
        if(head==null){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        builder.append(head.data);
        Node node = head.next;
        while(node!=head){
            builder.append(","+node.data);
            node= node.next;
        }
        return builder.append("]").toString();
    }
    /*返回链表的长度*/
    public int size(){
        return size;
    }

    /**
     * 返回指定位置（下标）处的元素
     * @param index  下标
     * @return    该位置对应的节点里面存放的数据（即元素）
     */
    public E get(int index){
        if (index<0 || index>= size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node node = getNode(index);
        //返回该节点存放的数据
        return node.data;
    }
    /*
    * 依据下标找到某个节点
    * （了解）：这是一个帮助器（helper方法），即只在当前类中使用，
    * 并且为其它方法服务的方法。*/
    private Node getNode(int index) {
        //从头节点开始找指定位置节点
        Node node = head;
        //为了提高执行速度，这可以通过比较index与链表长度的一半来决定
        //是顺时针（查找后继结点）还是逆时针（查找前驱结点）查找
        if (index<size>>1){
            for (int i=0;i<index;i++){
                node=node.next;
            }
        }else {
            for (int i=size;i>index;i--){
                node=node.prev;
            }
        }
        return node;
    }

    /**
     *
     * @param index  删除指定位置的元素
     * @return
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        //如果链表中只有一个节点，则需要将head设置为null。
        if (size==1){
            E data=head.data;
            head=null;
            size--;
            return data;
        }
        //找到要删除的节点
        Node node = getNode(index);

        //找到该节点的上一个节点(前驱)，和下一个节点（后继）
        Node prev = node.prev;
        Node next = node.next;
        //在prev和next之间建立引用关系
        prev.next=next;
        next.prev=prev;
        //如果要删除的是头节点
        if (index==0){
            head=next;
        }
        //链表长度减1
        size--;
        //返回被删除的元素
        return node.data;
    }

    /**
     * 将元素插入到指定的位置
     */
   public void add(int index,E e){
       if (index<0||index>size){
           throw new IndexOutOfBoundsException("下标越界");
       }
       //如果下标等于链表的长度，则调用追加的方法（将节点追加到链表的末尾）
       if (index==size){
           add(e);
           return;
       }
       //封装成节点
        Node node = new Node(e);
        //找到下标等于index的节点，该节点会成为新节点的下一个节点
       Node next = getNode(index);
       //找到该节点的上一个节点，该节点会成为新节点的上一个节点
       Node prev = next.prev;
       //将新节点插进来（实际上就是改变节点的引用关系）
       next.prev=node;
       node.prev=prev;
       prev.next=node;
       node.next=next;
       //如果下标等于0，则新节点等于头节点
       if (index==0){
           head=node;
       }
       size++;

   }
}

