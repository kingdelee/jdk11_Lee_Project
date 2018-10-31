package jdk11.map.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


public class MyAVLTree<AnyType extends Comparable<? super AnyType>> {

    private static final Logger logger = LogManager.getLogger(MyAVLTree.class);

    Node<AnyType> root;

    // 平衡因子，打破则失衡
    private static final int ALLOWED_IMBALANCE = 1;

    public MyAVLTree(AnyType value) {
        this.root = new Node<>(value);
    }

    public void insert(AnyType value) {
        Node<AnyType> tmp = insert(value, root);
        if(tmp != root){
            root = tmp;
        }
    }

    public Node<AnyType> insert(AnyType value, Node<AnyType> node) {
        // 1.插入
        // 2.检查平衡
        // 2.1 平衡结束
        // 2.2 不平衡旋转


        if (node.value.compareTo(value) > 0) {

            if (node.left != null) {
                // 递归从下往上返回，用父亲左指向返回的儿子，即重新连接了，如果没有发生转换，这种改变是多余的
                node.left = insert(value, node.left);
            } else {
                node.left = new Node<>(value);
            }

        } else if (node.value.compareTo(value) < 0) {

            if (node.right != null) {
                node.right = insert(value, node.right);
            } else {
                node.right = new Node<>(value);
            }

        } else {
            new UpsupportedException();
        }

        return checkBalance(node);


    }

    private Node<AnyType> checkBalance(Node<AnyType> node) {
        // 1.更新深度：每次新增节点都要更新父节点的height

        // 左失衡：节点的左子树深度 - 右子树深度 > 1
        if (node.getLeftInHeight() - node.getRightInHeight() > ALLOWED_IMBALANCE) {

            // 如果儿子左失衡，则为LL，右旋
            if (node.left.getLeftInHeight() > node.left.getRightInHeight()) {
                node = rotateRight(node);
            }else{
                // LR，左-右
                rotateLeftThenRight(node);
            }

            // 右失衡：节点的右子树深度 - 左子树深度 > 1
        }else if(node.getLeftInHeight() - node.getRightInHeight() > ALLOWED_IMBALANCE){

            // 如果儿子右失衡，则为RR，左旋
            if (node.left.getLeftInHeight() > node.left.getRightInHeight()) {
                node = rotateLeft(node);
            }else{
                // RL，右-左
                rotateRightThenLeft(node);
            }
        }else{

            // 未旋转的情况下更新
            updateHeight(node);
        }

        return node ;


    }

    // 左旋
    private Node<AnyType> rotateLeft(Node<AnyType> node) {
        Node<AnyType> right = node.right;
        node.right = right.left;
        right.left = node;

        // 已经变成老爸
        right.height = Math.max(node.getLeftInHeight(), getHeight(node.right)) + 1;
        // 已经变成儿子
        node.height = Math.max(node.getLeftInHeight(), node.getRightInHeight()) + 1;

        return right;

    }

    private Node<AnyType> rotateLeftThenRight(Node<AnyType> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node<AnyType> rotateRightThenLeft(Node<AnyType> node) {
        node.right = rotateLeft(node.right);
        return rotateRight(node);
    }

    // 右旋，左儿子变成左老爸，右老爸变成右儿子
    // 返回原本指向node的左子树，即儿子
    private Node<AnyType> rotateRight(Node<AnyType> node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;

        // 已经变成儿子，右边可能为null所以可能为-1
        node.height = Math.max(node.getLeftInHeight(), getHeight(node.right)) + 1;
        // 已经变成老爸
        left.height = Math.max(node.getLeftInHeight(), node.getRightInHeight()) + 1;

        return left;
    }

    private void updateHeight(Node<AnyType> node) {
//        int lh = node.left == null ? -1 : node.height;
//        int rh = node.right == null ? -1 : node.height;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int getHeight(Node<AnyType> node) {
        return node == null ? -1 : node.height;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void prevOrder() {
        prevOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    //
    public void inOrder(Node<AnyType> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.toString());
            inOrder(node.right);
        }

    }

    public void prevOrder(Node<AnyType> node) {
        if (node != null) {
            System.out.println(node.toString());
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    public void postOrder(Node<AnyType> node) {
        if (node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.toString());
        }
    }

    private class Node<AnyType extends Comparable<? super AnyType>> {
        Node<AnyType> left;
        Node<AnyType> right;
        AnyType value;

        // 深度
        int height;

        public Node(AnyType value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "node:" + value + ", height:" + height + ", lh:" + getHeight(left) + ", rh:" + getHeight(right);
        }

        // 不知道节点是否存在
        private int getHeight(Node<AnyType> node) {
            return node == null ? -1 : node.height;
        }

        // 不知道节点存在
        private int getLeftInHeight() {
            return this.left == null ? -1 : this.left.height;
        }

        // 不知道节点存在
        private int getRightInHeight() {
            return this.right == null ? -1 : this.right.height;
        }

    }


}

class MyAVLTreeTest {

    private static final Logger logger = LogManager.getLogger(MyAVLTree.class);


    MyAVLTree myAVLTree = new MyAVLTree(3);

    @Test
    public void t1() {

        int arr[]= {2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

//        for (int i = 0, len = arr.length; i < len; i++) {
//            logger.info(arr[i]);
//            myAVLTree.insert(arr[i]);
//        }

        myAVLTree.insert(60);
        myAVLTree.insert(40);
        myAVLTree.insert(30);
//        myAVLTree.insert(20);
//        myAVLTree.insert(10);
//        myAVLTree.insert(70);
//        myAVLTree.insert(80);


        myAVLTree.inOrder();
    }

    @Test
    public void t2(){
    }

}

