package com.demo.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=5; i++)
			queue.add(i);
		
		System.out.println("Elements of queue : "+ queue);
		
		int removeDel = queue.remove();
		System.out.println(" removed element : "+ removeDel);
		
		System.out.println(queue);
		
		
		
		int size = queue.size();
		System.out.println("Size of queue : "+ size);
		int head = queue.peek();
		System.out.println("Head of queue : " + head);
	}

}
