package com.demo.collections.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeDemo {

	public static void main(String[] args) {
		
		Deque<String> deque = new LinkedList<>();
		deque.add("Element 1 (Tail)"); //add to tail 
		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)"); // add to tail
		deque.push("Element 4 (Head)"); // Add to head
		deque.offer("Element 5 (tail)");
		deque.offerFirst("Element 6 (Head)");
		deque.offerLast("Element 7 (Tail)");
		
		System.out.println(deque.size());
		System.out.println(deque + " \n ");
		System.out.println(" Standard Iterator ");
		
		Iterator<String> itr = deque.iterator();
		while(itr.hasNext()) {
			System.out.println(" loop :"+itr.next());
		}
		
		Iterator<String> itr2 = deque.descendingIterator();
		while(itr2.hasNext()) {
			System.out.println("Decending order :"+ itr2.next());
		}

		System.out.println("Peek :"+deque.peek());
		System.out.println("After Peek :"+ deque);
		
		System.out.println("Pop :"+deque.pop());
		System.out.println("After pop :"+ deque);
		
		deque.removeFirst();
		deque.removeLast();
		System.out.println(deque);
	}

}
