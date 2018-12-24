package com.example.JXKENG;

public class DLList<T> {

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    private Node sentinelFront;
    private Node sentinelBack;
    private Node lastNode;
    private int size;


    public DLList() {
        this.sentinelFront = null;
        this.sentinelBack = this.sentinelFront;
        this.lastNode = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return (size == 0);
    }

    public void addToBack1(T item) {
        if ( isEmpty() ) {
            this.sentinelFront = new Node(item, null, null);
        } else {
            lastNode.next = new Node(item, null, lastNode);
            lastNode = lastNode.next;
        }
        size++;
    }


    public void addToBack2(T item) {
        this.sentinelBack.next = new Node(item, null, sentinelBack);
        sentinelBack = sentinelBack.next;
        size++;
        }
    }


    public void addToBack3(T item) {
        if (sentinelFront == null) {
            sentinelFront = new Node(item, null, null);
        } else {
            sentinelFront.next = new Node(item, null, sentinelFront);
            sentinelFront = sentinelFront.next;
            lastNode = sentinelFront;
        }
        
        size++;
    }
}
