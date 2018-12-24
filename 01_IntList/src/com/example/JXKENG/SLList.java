package com.example.JXKENG;

public class SLList {

    private static class IntNode {
        private int item;
        private IntNode next;

        private IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }


    // first item, if it exists, is at sentinel.next
    private IntNode sentinel;
    private int size;

    public SLList() {
        size = 0;
        sentinel = new IntNode(0, null);
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        this.size = 1;
    }

    public IntNode getSentinel() {
        return sentinel.next;
    }

    public void addToFront(int x) {
        sentinel.next = new IntNode(x, sentinel.next);

        size++;
    }

    public void addToBack(int x) {
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
        size++;
    }

    public IntNode recursiveAddToBack(int x, IntNode p) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
            return null;
        }

        return recursiveAddToBack(x, p.next);
    }

    private int recursiveSize(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + recursiveSize(p.next);
    }

    public int recursiveSize() {
        return recursiveSize(sentinel);
    }

    public int size() {
        return size;
    }



}
