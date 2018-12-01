package com.example.JXKENG;

public class Main {

    public static void main(String[] args) {
	    SLList L = new SLList(15);
	    L.addToFront(10);
	    L.addToFront(5);

	    System.out.println(L.getFirstNode());
	    L.addLast(20);
		System.out.println(L.size());

	}
}
