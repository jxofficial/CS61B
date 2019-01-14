package com.example.JXKENG;


/*
Invariants:
1. Number of items in the list is always size
2. Max number of items in the list is always array.length - 1;
*/


public class AList2<T> {

    private static final int RESIZE_FACTOR = 2;
    private static final double USAGE_RATIO = 0.25;
    private int size;
    private T[] array;
    private int nextFirst;
    private int nextLast;
    public int frontPointer;
    public int backPointer;

    /** Creates an empty list. */
    public AList2() {
        array = (T[]) new Object[7];
        size = 0;
        nextFirst = array.length / 2;
        nextLast = (array.length / 2) + 1;
    }


    private void resizeArray(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int i = frontPointer;
        int counter = 0;
        int j = capacity / 4;
        frontPointer = j;
        backPointer = j + array.length - 1;
        nextFirst = frontPointer - 1;
        nextLast = backPointer + 1;


        for ( ; i < array.length && array[i] != null; i++) {
            a[j] = array[i];
            j++;
            counter++;
        }

        i = 0;
        for ( ; counter <= size; i++) {
            a[j] = array[i];
            j++;
            counter++;
        }

        array = a;

    }


    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void maintainArrayBounds() {
        if (nextFirst < 0) {
            nextFirst = array.length - 1;
        } else if (nextFirst > array.length - 1) {
            nextFirst = 0;
        } else if (nextLast > array.length - 1) {
            nextLast = 0;
        } else if (nextLast < 0) {
            nextLast = array.length - 1;
        } else if (frontPointer < 0) {
            frontPointer = array.length - 1;
        } else if (frontPointer > array.length - 1) {
            frontPointer = 0;
        } else if (backPointer < 0) {
            backPointer = array.length - 1;
        } else if (backPointer > array.length - 1) {
            backPointer = 0;
        } else {
            return;
        }

    }

    /** Inserts X into the front of the list. */
    public void addFirst(T x) {
        if (isFull()) {
            resizeArray(array.length * RESIZE_FACTOR);
        }

        array[nextFirst] = x;
        frontPointer = nextFirst;
        nextFirst--;
        maintainArrayBounds();
        size++;

        if (size == 1) {
            backPointer = frontPointer;
        }
    }


    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (isFull()) {
            resizeArray(array.length * RESIZE_FACTOR);
        }

        array[nextLast] = x;
        backPointer = nextLast;
        nextLast++;
        maintainArrayBounds();
        size++;

        if (size == 1) {
            frontPointer = backPointer;
        }
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return array[backPointer];

    }

    /** Returns the item from the back of the list. */
    public T getFirst() {
        return array[frontPointer];

    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        int actualIndex = i + frontPointer;
        if (actualIndex > array.length - 1) {
            actualIndex -= (array.length - 1);
        }
        return array[actualIndex];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }


    /** Deletes item from front of the list and
     * returns deleted item. */
    public T removeFirst() {
        if (size / array.length < USAGE_RATIO) {
            resizeArray(array.length / 2);
        }

        T deletedItem = getFirst();
        array[frontPointer] = null;
        nextFirst = frontPointer;
        frontPointer++;
        maintainArrayBounds();
        size--;

        return deletedItem;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T deletedItem = getLast();
        array[backPointer] = null;
        nextLast = backPointer;
        backPointer--;
        maintainArrayBounds();
        size--;

        return deletedItem;
    }

    /** Prints the list starting from the front pointer */
    public void printDeque() {

        int i = frontPointer;
        int counter = 0;
        while (i < array.length && array[i] != null ) {
            System.out.print(array[i] + " ");
            i++;
            counter++;
        }

        i = 0;
        while (array[i] != null && counter <= size) {
            System.out.println(array[i] + " ");
            i++;
            counter++;
        }

    }

}