package demo.线程的创建方式;

import demo.Node;

import static demo.BinaryTree.insert;

public class BinaryTree02 {
    /**
     * 实现要求：
     * 1、根据已有的代码片段，创建二叉搜索树；
     * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
     * 3、使用递归、非递归二种方式实现遍历；
     * 4、注意编写代码注释。
     */
    //手动创建二叉树，并通过递归实现中序遍历该二叉树
    public static void main(String[] args) {
       final int[] values = {0,1,2 ,3 ,4, 5, 6, 7, 8, 9};
        Node node = createBinaryTree(values);
        //对node节点进行中序遍历
        middle(node);
    }
    public static Node root;
    public static Node createBinaryTree(int[] values) {
        for (int i=0;i<values.length;i++) {
             root = insertNode(root,values[i]);
        }
        return root;
    }
    public static Node insertNode(Node node,int data) {
        //如果当前节点为空则插入第一个节点
        if (node == null) {
            return new Node(data); //将数组中第一个节点作为root
        }
        //插入左边
        if (data < node.data) {
            node.leftChild = insertNode(node.leftChild,data);
        }
        //插入右边
        else if (data > node.data) {
            node.rightChild = insertNode(node.rightChild,data);
        }
        else {
            node.data = data; //进行覆盖
        }
        return node;
    }

    public static void middle(Node node) {
        if (node == null) {
            return;
        } else {
            //先遍历左孩子 --》根节点--》右孩子
            middle(node.leftChild);
            System.out.println(node.data);
            middle(node.rightChild);
        }
    }

}
