package jdk11.map.linklist;

import org.junit.jupiter.api.Test;

public class MyLink {

    @Test
    public void t1(){
        LinkNode linkNode = new LinkNode(1);

        linkNode.insertNext(1).insertNext(2).insertNext(3).insertNext(4);

//        linkNode.printNextAllNodes(linkNode);

        System.out.println(linkNode.getLastNode(linkNode).val);

//        System.out.println(fa(100));

    }




}

class LinkNode{

    int val;
    private LinkNode next;
    private LinkNode prev;

    public LinkNode(int val) {
        this.val = val;
    }

    public LinkNode insertNext(int val) {
        next = new LinkNode(val);
        return next;
    }

    public void insertPrev(int val) {
        prev = new LinkNode(val);
    }

    public LinkNode getLastNode(LinkNode current){
        if(current.next != null){
            current = getLastNode(current.next);
        }
        return current;
    }

    public void printNextAllNodes(LinkNode current){
        if(current.next != null){
            printNextAllNodes(current.next);
        }
        System.out.println(current.val);
    }



}
