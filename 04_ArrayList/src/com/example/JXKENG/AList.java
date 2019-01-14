package com.example.JXKENG;


/*
nextFirst and nextLast are the sentinels.


Invariants:
1. Next last item to be added is always at array[size]
2. Number of items in the list is always size
3. Position of last item in the list is always at size - 1
4. PointerFront is always the index of the first item in the list.
6. PointerBack is always the index of the last item in the list.
7. Item to be added next is either at nextFirst or nextLast
8. There is no direction change EVER, nextLast will always be ++ and nextFirst will always be --


9. nextLast is ALWAYS one larger than pointerBack. When nextLast exceeds array.length - 1 or < 0, it will just
*/


public class AList<T> {

    private static final int RESIZE_FACTOR = 2;
    private static final double USAGE_RATIO = 0.25;
    private int size;
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int pointerFront;
    private int pointerBack;


    /** Creates an empty list. */
    public AList() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = array.length / 2;
        nextLast = (array.length / 2) + 1;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean frontPointerAtFront() {
        return pointerFront <= 0;
    }

    private boolean frontPointerAtBack() {
        return pointerFront >= array.length;
    }

    private boolean backPointerAtFront() {
        return pointerBack <= 0;
    }

    private boolean backPointerAtBack() {
        return pointerBack >= array.length;
    }


    private void moveSentinel() {
        if (frontPointerAtFront()) {
            nextFirst = array.length - 1;
        } else if (frontPointerAtBack()) {
            nextFirst = 0;
        } else if (backPointerAtBack()) {
            nextLast = 0;
        } else if (backPointerAtFront()) {
            nextLast = array.length - 1;
        }
    }

    private boolean needToMoveSentinel() {
        return ( frontPointerAtFront() || frontPointerAtBack() || backPointerAtFront() || backPointerAtBack() );
    }

    private void resizeArray(int capacity) {
        T[] a = (T[]) new Object[8];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    /** Inserts X into the front of the list. */
    public void addFirst(T x) {

        if (needToMoveSentinel()) {
            moveSentinel();
        }
        array[nextFirst] = x;
        pointerFront = nextFirst;
        nextFirst--;
        size++;
    }


    /** Inserts X into the back of the list. */
    public void addLast(T x) {



        if (needToMoveSentinel()) {
            moveSentinel();
        }

        array[nextLast] = x;
        pointerBack = nextLast;
        nextLast++;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return array[pointerBack];
    }

    /** Returns the item from the front of the list. */
    public T getFirst() {
        return array[pointerFront];
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return array[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from front of the list and
     * returns deleted item. */
    public T removeFirst() {
        T deletedItem = getFirst();
        array[pointerFront] = null;


        size--;
        return deletedItem;
    }


    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T deletedItem = getLast();
        array[pointerBack] = null;

        if (needToMoveSentinel()) {
            moveSentinel();
        }

        nextLast--;
        pointerBack--;
        size--;
        return deletedItem;
    }
}
