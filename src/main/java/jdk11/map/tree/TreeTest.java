package jdk11.map.tree;

import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void t1() {
        TreeNode treeNode = new TreeNode(50);
        treeNode.addNode(30);
        treeNode.addNode(80);
        treeNode.addNode(20);
        treeNode.addNode(25);
        treeNode.addNode(70);
    }

}

class TreeNode {
    TreeNode treeNode;
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode treeNode, TreeNode left, TreeNode right, int val) {
        this.treeNode = treeNode;
        this.left = left;
        this.right = right;
        this.val = val;
    }


    public void addNode(int val) {
        TreeNode lastNode = findLastNode(val, this);
        if(lastNode.val > val){
            lastNode.left =  new TreeNode(val);
        }else{
            lastNode.right =  new TreeNode(val);
        }
    }

    public void addNode2(int val) {
        addNode2a(val, this);
    }

    public TreeNode addNode2a(int val, TreeNode treeNode) {
        if( treeNode == null ) {
            return new TreeNode(val);
        }

        if (treeNode.val > val) {
            if(treeNode.left != null){
                treeNode.left =  addNode2a(val, treeNode.left);
            }
            // left==null
        }else{
            if(treeNode.right != null){
                treeNode.right =  addNode2a(val, treeNode.right);
            }
        }
        return treeNode;

    }

    private TreeNode findLastNode(int val, TreeNode treeNode) {
        if (treeNode.val > val) {
            if(treeNode.left != null){
                treeNode =  findLastNode(val, treeNode.left);
            }
            // left==null
        }else{
            if(treeNode.right != null){
                treeNode =  findLastNode(val, treeNode.right);
            }
        }
        return treeNode;
    }



    private void findAddNode(int val, TreeNode treeNode) {
//        if(){
//
//        }else if(val < this.val){
//            treeNode = findLeftNode(treeNode);
//        }else{
//            treeNode = findRightNode(treeNode);
//        }
    }

    private TreeNode findNode(int val, TreeNode node) {
//        if(this.val > val){
//            findNode(val, node.left);
//        }else if(this.val < val){
//            findNode(val, node.right);
//
//        }else if(this.val == val){
//            return this;
//        }else {
//            return null;
//        }
        return null;
    }

    private void findLeftNode() {
        if (this.left == null) {

        }
    }

}