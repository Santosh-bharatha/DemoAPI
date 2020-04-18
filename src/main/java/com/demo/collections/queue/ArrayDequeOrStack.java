package com.demo.collections.queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ArrayDequeOrStack {

	public static void main(String[] args) {
		
		long t2 = System.currentTimeMillis();
		//push 10 elements into Stack
		for(int i=0; i< 1000000 ; i++) {
			Stack<Integer> stack = new Stack<>();
			for(int v = 0 ; v < 1000 ; v ++) {
				stack.push(v);
			}
		}

		long t1 = System.currentTimeMillis();
		//push 10 elements to arrayDeque
		for(int i=0; i< 1000000 ; i++) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for(int v=0; v < 1000 ; v++) {
				deque.push(v);
			}
		}
		
		long t3 = System.currentTimeMillis();
		System.out.println(t1 - t2);
		System.out.println(t3 - t1);
		
	}

}
