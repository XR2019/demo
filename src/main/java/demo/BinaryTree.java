package demo;


import java.util.Stack;

/**
 * 实现要求：
 * 1、根据已有的代码片段，创建二叉搜索树；
 * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
 * 3、使用递归、非递归二种方式实现遍历；
 * 4、注意编写代码注释。
 */
public class BinaryTree {

    public static void main(String[] args) {

        final int[] values = { 1, 3, 4, 5, 2, 8, 6, 7, 9, 0 };
        Node node = createBinaryTree(values);
        //对node节点进行中序遍历
        inOrderTransvalWithRecursive(node);

//        System.out.println("使用栈的方式实现二叉树的中序遍历：--->");
//        inOrderTransvalWithIterate(node);

    }

   public static Node root;

    //构建二叉树
    public static Node createBinaryTree(int[] values) {
        for (int i =0;i< values.length;i++) {
            root = insert(root,values[i]);
        }
        return root;
    }

    //插入方法
    public static Node insert(Node node,int data) {
        //如果当前节点为空则插入第一个节点
        if (node == null) {
            return new Node(data); //将数组中第一个节点作为root
        }
        //插入左边
       if (data < node.data) {
           node.leftChild = insert(node.leftChild,data);
       }
       //插入右边
       else if (data > node.data) {
           node.rightChild = insert(node.rightChild,data);
       }
       else {
           node.data = data; //进行覆盖
       }
       return node;
    }

    // 递归实现 (中序遍历!!)
    public static void inOrderTransvalWithRecursive(Node node) {
        //中序遍历的特点：左 --> 根节点 --> 右
        if (node == null) {
            return;
        } else {
            //递归实现
            inOrderTransvalWithRecursive(node.leftChild);
            System.out.println(node.data); //输出根节点数据
            inOrderTransvalWithRecursive(node.rightChild);
        }
    }

    //非递归方式(栈)实现二叉树的中序遍历
    public static void inOrderTransvalWithIterate(Node treeNode) {


        Stack<Node> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //左子树进栈完毕
            if (!stack.empty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data + " ");
                treeNode = treeNode.rightChild;
            }
        }
    }
}
