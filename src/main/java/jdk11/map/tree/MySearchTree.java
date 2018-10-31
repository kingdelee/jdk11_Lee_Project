package jdk11.map.tree;

import org.junit.jupiter.api.Test;

// 二叉树
public class MySearchTree<AnyType extends Comparable<? super AnyType>> {

    Node<AnyType> root;

    public MySearchTree(AnyType value) {
        this.root = new Node<>(value);
    }

    public void insert(AnyType value, Node<AnyType> node) {
        if (node.value.compareTo(value) < 0) {

            if (node.left != null) {
                insert(value, node.left);
            } else {
                node.left = new Node<>(value);
            }


        } else if (node.value.compareTo(value) > 0) {

            if (node.right != null) {
                insert(value, node.right);
            } else {
                node.right = new Node<>(value);
            }

        } else {
            new UpsupportedException();
        }
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
            System.out.println(node.value);
            inOrder(node.right);
        }

    }

    public void prevOrder(Node<AnyType> node) {
        if (node != null) {
            System.out.println(node.value);
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    public void postOrder(Node<AnyType> node) {
        if (node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.value);
        }
    }

    public void insert(AnyType value) {
        insert(value, root);
    }

    //

    private class Node<AnyType> {
        Node<AnyType> left;
        Node<AnyType> right;

        AnyType value;


        public Node(AnyType value) {
            this.value = value;
        }
    }


}

class MySearchTreeTest {

    MySearchTree mySearchTree = new MySearchTree(50);

    @Test
    public void t1() {
        mySearchTree.insert(60);
        mySearchTree.insert(20);
        mySearchTree.insert(100);
        mySearchTree.insert(30);
        mySearchTree.insert(40);

        mySearchTree.inOrder();
        System.out.println("--------");
        mySearchTree.prevOrder();
        System.out.println("--------");
        mySearchTree.postOrder();
    }
}

class UpsupportedException extends RuntimeException {
    public UpsupportedException() {
        System.err.println("unsupport insert same node");

    }
}

