package com.example.JXKENG;

public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode firstNode;
    private IntNode lastNode;
    private int size;


    public SLList(int x) {
        this.firstNode = new IntNode(x, null);
        this.size = 1;
    }

    public SLList() {
        this.firstNode = null;
        this.size = 0;
    }

    public void addToFront(int x) {
        firstNode = new IntNode(x, firstNode);
        size++;
    }

    public int getFirstNode() {
        return firstNode.item;
    }

    public void addLast(int x) {
        if (this.size == 0) {
            this.firstNode = new IntNode(x, null);
            size++;
        } else {
            this.lastNode.next = new IntNode(x, null);
            this.lastNode = lastNode.next;
            size++;
        }
    }

    // returns the size of the list that starts at IntNode n
    private static int size(IntNode n) {
        if (n.next == null) {
            return 1;
        }

        return 1 + size(n.next);
    }

    public int size() {
        return size(firstNode);
    }

    public int instantSize() {
        return size;
    }



}
