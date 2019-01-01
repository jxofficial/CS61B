package com.example.JXKENG;

public class DLList<T> {

    private static class Node<T> {
        private T item;
        private Node next;
        private Node prev;

        private Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        private Node() {};
    }

    // first item, if it exists, is at sentinelFront.next
    // lastNode item, if it exists, is at sentinelBack.prev
    private Node<T> sentinelFront = new Node<>();
    private Node<T> sentinelBack = new Node<>();
    private int size;

    public DLList() {
        size = 0;

        sentinelFront.item = null;
        sentinelFront.next = sentinelBack;
        sentinelFront.prev = null;

        sentinelBack.item = null;
        sentinelBack.next = null;
        sentinelBack.prev = sentinelFront;

    }

    public DLList(T item) {
        size = 1;
        sentinelFront.item = null;
        sentinelFront.next = new Node<>(item, null, sentinelFront);
        sentinelFront.prev = null;

        sentinelBack.item = null;
        sentinelBack.next = null;
        sentinelBack.prev = sentinelFront.next;


    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }


    public void addLast(T item) {
        Node input = new Node<>(item, sentinelBack, sentinelBack.prev);
        sentinelBack.prev.next = input;
        sentinelBack.prev = input;

        size++;
    }

    public void addFirst(T item) {
        Node originalFirst = sentinelFront.next;
        Node input = new Node<>(item, originalFirst, sentinelFront);
        sentinelFront.next = input;
        originalFirst.prev = input;
        size++;
    }

    public T removeLast() {
            sentinelBack.prev.prev.next = sentinelBack;
            sentinelBack.prev = sentinelBack.prev.prev;
            size--;
        return (T) sentinelBack.prev.item;
    }

    public T removeFirst() {
        sentinelFront.next.next.prev = sentinelFront.next;
        sentinelFront.next = sentinelFront.next.next;
        size--;

        return (T) sentinelFront.next.item;
    }


    public void printDeque() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        Node pointer = sentinelFront.next;
        while ( !pointer.equals(sentinelBack) ) {
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public T get(int index) {
        int i = 0;
        Node pointer = sentinelFront.next;
        while (i != index) {
            i++;
            pointer = pointer.next;
        }
        return (T) pointer.item;
    }


    public T getRecursive(int index) {
        return (T) getRecursiveNode(index).item;
    }

    private Node getRecursiveNode(int index) {
        if (index == 0) {
            return sentinelFront.next;
        }

        return getRecursiveNode(index - 1).next;
    }










}
