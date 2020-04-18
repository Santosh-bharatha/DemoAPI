package com.demo.collections.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {

	static void push_element(Stack<Integer> st, int a)
	{
		st.push(new Integer(a));
		System.out.println("push("+a+")");
		System.out.println("Stack : " + st);
	}
	
	static void pop_element(Stack<Integer> st) {
		System.out.println("pop ->");
		Integer a = st.pop();
		System.out.println(a);
		System.out.println("Stack : " +st);
	}
	public static void main(String[] args) {
      Stack<Integer> st  = new Stack<Integer>();
      System.out.println("Stack : " + st);
		
      push_element(st, 42);
      push_element(st, 44);
      push_element(st, 46);
      push_element(st, 48);
      push_element(st, 50);
      
      System.out.println("Top element is :"+ st.peek());
      
      pop_element(st);
      pop_element(st);
      pop_element(st);
      pop_element(st);
      
      
     
      try {
    	  pop_element(st);
      }catch(EmptyStackException e) {
    	 System.out.println("Empty Stack");
      }
      
	}

}
