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

        L.iterativeSize();
        L.size();

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

}


