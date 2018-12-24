package com.example.JXKENG;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L.addFirst(1);


        System.out.println( L.iterativeSize() );
        System.out.println( L.size() );

        System.out.println( L.get(0) );
        System.out.println( L.get(1) );
        System.out.println( L.get(2) );

        System.out.println( L.iterativeGet(0) );
        System.out.println( L.iterativeGet(1) );
        System.out.println( L.iterativeGet(2) );
    }


    public int size() {
        IntList L = this;

        if (L.rest == null) {
            return 1;
        }

        return 1 + L.rest.size();

    }


    public int iterativeSize() {
        IntList x = this;
        int count = 0;

        while (x != null) {
            count++;
            x = x.rest;
        }

        return count;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }

        return rest.get(i - 1);
    }

    public int iterativeGet(int i) {
        IntList x = this;

        while (i != 0) {
            x = x.rest;
            i--;
        }

        return x.first;
    }

    public void addFirst(int x) {
        IntList currentList = new IntList(first, rest);
        IntList updatedList = new IntList(x, currentList);
        this.first = x;
        this.rest = currentList;

    }


}


