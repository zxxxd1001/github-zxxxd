package datastructure.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompletelyTree {

    //数组，用来初始化各个节点
    private int[] array;

    //存储所有节点的集合
    private List<TreeNode> listNode;

    //构造函数
    public CompletelyTree(int[] arr) {
        this.array = arr;
    }

    //内部类
    //由于二叉树是由节点构成，所有节点是其内部类
    class TreeNode {
        //左右节点和值
        TreeNode leftChild;
        TreeNode rightChild;
        int data;

        //构造函数
        TreeNode(int data) {
            this.data = data;

            leftChild = null;
            rightChild = null;
        }
    }

    //创建二叉树
    public void createBinTree() {
        //将数组中的值变成节点存到集合中
        listNode = new LinkedList<TreeNode>();

        for (int i = 0; i < array.length; i++) {
            listNode.add(new TreeNode(array[i]));
        }

        //构造父子之间的关系
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            listNode.get(parentIndex).leftChild = listNode.get(parentIndex * 2 + 1);//添加左儿子
            listNode.get(parentIndex).rightChild = listNode.get(parentIndex * 2 + 2);//添加右儿子
        }

        //对于最后一个节点，单独处理
        int lastIndex = array.length / 2 - 1;
        listNode.get(lastIndex).leftChild = listNode.get(lastIndex * 2 + 1);

        //如果数组个数为奇数，这时最后一个节点有右儿子
        if (array.length % 2 != 0) {
            listNode.get(lastIndex).rightChild = listNode.get(lastIndex * 2 + 2);
        }
    }

    //获取根节点
    public TreeNode getRoot() {
        //如果这个树有节点
        if (listNode != null) {
            return listNode.get(0);
        }

        System.out.println("请先创建二叉树");
        return null;
    }

    //先序遍历
    //根左右
    public void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    //中序遍历
    //左根右
    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraverse(root.rightChild);
    }

    //后序遍历
    //左右根
    public void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.print(root.data + " ");
    }

    //宽度优先遍历/广度优先遍历
    //创建一个队列，先把根节点存到队列中，然后当队列不是空的时候，将队列头删除并输出其值，如果其儿子节点存在，那么就将其儿子节点存到队列中，直到队列是空的
    public void BFS(TreeNode root) {
        if (root == null) {
            return;
        }

        //创建队列，存储节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        //把根节点存到队尾
        queue.offer(root);

        //当队列不是空的，删除队列头节点，将其儿子节点存到队列中
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            System.out.print(head.data + " ");

            if (head.leftChild != null) {
                queue.offer(head.leftChild);
            }
            if (head.rightChild != null) {
                queue.offer(head.rightChild);
            }
        }

        System.out.println();
    }

    //宽度优先遍历
    //创建一个栈，先把根节点存到栈中，当栈不是空的时候，将栈顶元素弹出，如果其儿子节点存在，就把其儿子节点存到栈中，直到栈是空的
    public void DFS(TreeNode root) {
        if (root == null) {
            return;
        }

        //创建栈，存储节点
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();

        //把根节点压到栈底
        stack.push(root);

        //当栈不是空的时候，弹出栈顶元素，并将其儿子节点压到栈中
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            System.out.print(head.data + " ");

            if (head.leftChild != null) {
                stack.push(head.leftChild);
            }
            if (head.rightChild != null) {
                stack.push(head.rightChild);
            }
        }

        System.out.println();
    }
}