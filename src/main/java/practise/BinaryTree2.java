package practise;

public class BinaryTree2 <E extends Comparable> {
    //root用于保存根节点的引用
    private Node root;

    class Node{
        E data;
        Node left;
        Node right;

        public Node(E e) {
            data = e;
        }

        public boolean append(E e) {
            if (data.compareTo(e)==0){
                return false;
            }
            //如果要添加的元素比当前节点的元素小
            if (data.compareTo(e)>0){
                if(left==null){
                    left = new Node(e);
                    return true;
                }
                return left.append(e);
            }else {
                if (right==null){
                    right = new Node(e);
                    return true;
                }
                return right.append(e);

            }
        }
        public void inOrder(StringBuilder builder){
            if (left!=null){

            }
        }

    }
    public boolean add(E e){
        if (root==null){
            root = new Node(e);
            return true;
        }
        return root.append(e);
    }
}
