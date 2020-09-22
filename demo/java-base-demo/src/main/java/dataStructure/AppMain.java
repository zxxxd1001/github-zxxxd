package datastructure;

import datastructure.tree.*;

public class AppMain {
    public static void main(String[] args) {
//        testMap();
//        testTree();
//        testAvlTree();
//        testCompletelyTree();
//        testRedBlackTree();
//        testHeap();
        testBfAndRk();
    }

    private static void testTree() {
        BSTree bsTree = new BSTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(35);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(25);
        bsTree.put(40);
        bsTree.put(10);
        bsTree.put(20);
        bsTree.put(27);
        bsTree.put(38);
        bsTree.put(41);
        bsTree.put(26);
        bsTree.put(30);
        bsTree.put(39);

//        BSTree.Node node = bsTree.find(10);
//        System.out.println("值为10的结点信息："+node+"----"+node.getValue());

//        bsTree.delete(10);

//        System.out.println(bsTree);
        System.out.println("查询树--->最小数字和是：" + bsTree.getMin() + " ========= " + bsTree.getMax());
    }

    private static void testAvlTree() {
        AvlTree tree = new AvlTree();
        // 添加节点
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(1);
        tree.insert(11);
        tree.insert(17);
        // 打印结果
        System.out.println(tree);
    }

    private static void testMap() {
        MyMap m = new MyMap();
        int y = 0;
        for (int i = 0; i < 100; i++) {
            if (y > 8) {
                y = 0;
            }
            m.put(new P(i + "", y++), i);
        }
        m.remove(new P("8", 8));
        System.out.println(m.size());
        System.out.println(Integer.toHexString(m.hashCode()));
        System.out.println(m);
    }

    private static void testCompletelyTree() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //创建二叉树
        CompletelyTree bt = new CompletelyTree(array);
        bt.createBinTree();

        System.out.println("先序遍历");
        bt.preOrderTraverse(bt.getRoot());
        System.out.println();

        System.out.println("中序遍历");
        bt.inOrderTraverse(bt.getRoot());
        System.out.println();

        System.out.println("后序遍历");
        bt.postOrderTraverse(bt.getRoot());
        System.out.println();

        CompletelyTree bt1 = new CompletelyTree(array);
        bt1.preOrderTraverse(bt1.getRoot());

        //BFS
        System.out.println("BFS宽度优先遍历");
        bt.BFS(bt.getRoot());

        //DFS
        System.out.println("DFS深度优先遍历");
        bt.DFS(bt.getRoot());
    }

    /**
     * 红黑树有一个问题，最终的根节点的颜色是错误的
     */
    private static void testRedBlackTree() {
        System.out.println("傲慢与偏见");
        RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.add("1", 1);
        redBlackTree.add("2", 2);
        redBlackTree.add("3", 3);
        redBlackTree.add("4", 4);
        redBlackTree.add("0", 0);
        System.out.println("共有不同单词数：" + redBlackTree.getSize());
    }

    private static  void testHeap(){
        Heap h=new Heap(12);
        h.insert(3);
        h.insert(5);
        h.insert(2);
        h.insert(8);
        h.insert(1);
        h.insert(9);
        System.out.println(h);
    }
    private static void testBfAndRk(){
        String test="abcef";
        String  sub ="e";
        RK rk = new RK();
        int rk1 = rk.rk(test, sub);
        System.out.println(rk1);

        BF bf = new BF();
        int bf1 = bf.bf("abcd", "cd");
        System.out.println(bf1);
    }
}
