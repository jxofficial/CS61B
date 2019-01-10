package com.example.JXKENG;


/*
Invariants:
1. Next last item to be added is always at array[size]
2. Number of items in the list is always size
3. Position of last item in the list is always at index size - 1

*/


public class AList<T> {

    private static final int RESIZE_FACTOR = 2;
    private static final double USAGE_RATIO = 0.25;
    private int size;
    private T[] array;

    /** Creates an empty list. */
    public AList() {
        array = (T[]) new Object[8];
        size = 0;
    }


    private void resizeArray(int capacity) {
        T[] a = (T[]) new Object[8];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == array.length) {
            resizeArray(size * RESIZE_FACTOR);
        }

        array[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return array[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return array[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T deletedItem = getLast();
        array[size - 1] = null;
        size--;
        return deletedItem;
    }
}
