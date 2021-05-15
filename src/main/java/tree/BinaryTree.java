package tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * 查找二叉树（排序二叉树）类
 * @param <E> 要添加的元素，E extends Comparable（java泛型规定不用implements）,表示
 *           添加到二叉树中的这个元素必须要实现过Comparable接口
 *           （因为查找二叉树中的节点必须能够比较大小）
 */
public class BinaryTree<E extends Comparable<E>> {
    //root用于保存根节点的引用
    private Node root;

    /**
     * Node类用于描述二叉树中的某个节点，
     * 其中，data用于存放数据（即元素），
     * left和right用于存放其左右子树的引用
     */

    class Node{
        E data;
        Node left;
        Node right;

        public Node(E e) {
            data = e;
        }

        /**
         * 将某个元素添加到当前节点下面
         * @param e  要添加的元素
         * @return   添加成功，返回true 否则返回false
         */
        public boolean append(E e){
            //如果要添加的元素和当前节点存放的元素相等，则添加失败，因为二叉树中不允许重复元素。
            if(data.compareTo(e)==0){
                return false;
            }
            //如果要添加的元素比当前节点的元素要小，则需要将该元素添加到当前节点的左边
            if (data.compareTo(e)>0){
                //如果当前节点的左子树为空，则新节点称为其左子树
                if (left==null){
                    left = new Node(e);
                    return true;
                }
                //如果当前节点的左子树不为空，则将该元素添加到其左子树下面
                return left.append(e);
            }else {
                //如果当前节点的右子树为空，则新节点称为其右子树
                if (right==null){
                    right = new Node(e);
                    return true;
                }
                //如果当前节点的右子树不为空，则将该元素添加到其右子树下面
                return right.append(e);
            }

        }

        /**
         * 对当前节点进行中序遍历的方法
         * @param sb
         */
        public void inOrder(StringBuilder sb) {
            //如果当前节点的左子树不为空，则对其左子树进行中序遍历
            if (left!=null){
                left.inOrder(sb);
            }
            //访问当前节点
            sb.append(data+",");
            //如果当前节点的右子树不为空，则对其右子树进行中序遍历。
            if (right!=null){
                right.inOrder(sb);
            }
        }
    }

    /**
     * 将元素添加到二叉树上面
     * @param e 被添加的元素
     * @return  添加成功返回 true 否则返回false
     */
    public boolean add(E e){
        //如果二叉树为空，则新节点为根节点
        if (root==null){
            root = new Node(e);
        }
        //如果二叉树不为空 则将该元素添加到根节点下面
        return root.append(e);
    }

    @Override
    public String toString() {
        if (root==null){
            return "[]";
        }
        /*
        在中序遍历过程中，将访问到的各个节点中的数据
        添加到sb对象里面
        * */
        StringBuilder sb = new StringBuilder("[");
        //调用根节点的中序遍历方法（递归方法）
        root.inOrder(sb);
        //"[33,66,80,88,100]"
        //将末尾的","删除掉
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.append("]").toString();

    }
}
