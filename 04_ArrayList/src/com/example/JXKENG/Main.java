package com.example.JXKENG;

public class Main {

    public static void main(String[] args) {
        AList2<String> list = new AList2<String>();

        list.addLast("item 1");
        list.addLast("item 2");
        list.addLast("item 3");
        list.addFirst("item 0");
        list.addLast("item 4");
        list.addLast("item 5");
        list.addLast("item 6");


        list.addLast("item 7");
        list.addLast("item 100");

        System.out.println(list.frontPointer);
        System.out.println(list.backPointer);

        list.printDeque();

    }
}
