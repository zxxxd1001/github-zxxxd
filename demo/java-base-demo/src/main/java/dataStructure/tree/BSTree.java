package datastructure.tree;

/**
 * 定义二叉查找树 基础数据结构【链表结构】
 */
public class BSTree {

    private Node parent;

    /**
     * 获取最小节点
     *
     * @return
     */
    public Node getMin() {
        if (parent == null) {
            return null;
        }
        Node p = parent;
        while (p.left != null){
            p = p.left;
        }
        return p;
//        return recursion(p);
    }

    private Node recursion(Node n) {
        if (n.left != null) {
            return recursion(n.left);
        }
        return n;
    }

    /**
     * 获取最大节点
     *
     * @return
     */
    public Node getMax() {
        if (parent == null) {
            return null;
        }
        Node p = parent;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }


    /**
     * 1：要删除的节点是叶子节点即没有子节点，我们只需将父节点中指向该节点的指针置为null即可，这是最简单的一种形式。比如删除图中的节点10
     * <p>
     * 2：要删除的节点只有一个子节点(只有左子节点或者只有右子节点)，我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。比如删除图中的节点38
     * <p>
     * 3：要删除的节点有两个子节点，这是最复杂的一种情况，我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了）
     *
     * @param value
     */
    public void delete(int value) {
        // 记录要删除的结点
        Node p = parent;
        // 记录要删除的结点的父节点
        Node p_parent = null;
        //  先找到要删除的元素及其父元素
        while (p != null) {
            if (p.value > value) {
                p_parent = p;
                p = p.left;
            } else if (p.value < value) {
                p_parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return;
        }
        // 要删除的结点有两个子节点
        if (p.left != null && p.right != null) {
            Node rTree = p.right;
            Node rTree_p = p;   // rTree 父节点
            while (rTree.left != null) {
                rTree_p = rTree;
                rTree = rTree.left;
            }
            //  用右子树中的最小结点替换要删除的结点位置
            p.value = rTree.value;

            p = rTree;
            p_parent = rTree_p;
        }

        //  当我们要删除的结点时叶子结点或者只有一个叶子节点的结点

        Node child = null;

        if (p.right != null) {
            child = p.right;
        } else if (p.left != null) {
            child = p.left;
        } else {
            child = null;
        }
        // 执行删除操作

        if (p_parent == null) {
            parent = child;
        } else if (p_parent.left == p) {
            p_parent.left = child;
        } else {
            p_parent.right = child;
        }
    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public Node find(int value) {

        while (parent != null) {
            if (parent.value > value) {
                parent = parent.left;
            } else if (parent.value < value) {
                parent = parent.right;
            } else {
                return parent;
            }
        }
        return parent;
    }

    /**
     * 向二叉查找树中插入
     */
    public boolean put(int value) {
        //  如果要插入的二叉查找树是一颗空树
        if (parent == null) {
            parent = createNode(value);
            return true;
        }
        Node pt = parent;
        while (pt != null) {
            //  当前我们要插入的数据 应该存储在左子树
            if (pt.value > value) {
                if (pt.left == null) {
                    pt.left = createNode(value);
                    return true;
                }
                pt = pt.left;
                //  当前我们要插入的数据应该存储在 右子树
            } else if (value > pt.value) {
                if (pt.right == null) {
                    pt.right = createNode(value);
                    return true;
                }
                pt = pt.right;

            }
        }
        return false;
    }


    /**
     * 构造一个没有左右子树树节点
     *
     * @param value
     * @return
     */
    private Node createNode(int value) {
        return new Node(null, null, value);
    }

    /**
     * 构造有左右子树的结点
     *
     * @param left
     * @param value
     * @param right
     * @return
     */
    private Node createNode(Node left, Node right, int value) {
        return new Node(left, right, value);
    }

    @Override
    public String toString() {
        return "BSTree{" +
                "parent=" + parent +
                '}';
    }

    /**
     * 构建节点
     */
    public static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }
}
