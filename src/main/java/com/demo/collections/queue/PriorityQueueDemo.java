package com.demo.collections.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		
		pQueue.add(new Integer(1));
		pQueue.add(new Integer(6));
		pQueue.add(new Integer(12));
		pQueue.add(new Integer(18));
		pQueue.add(new Integer(15));
		
        System.out.println("Size :"+pQueue.size());
        System.out.println("pQueue :" + pQueue);
        
        //poll will remove the 1st available element
       // pQueue.poll();
        
       // pQueue.remove(18);
        System.out.println(pQueue.contains(18));
        Iterator<Integer> itr = pQueue.iterator();
       try {
        while(itr.hasNext()) {
        	
        	System.out.println(itr.next());
        }
       }catch(ConcurrentModificationException ce) {
    	   System.out.println("Cannot Modify the elements");
       }
       
       Object[] arr = pQueue.toArray();
        for(Object it : arr) {
        	System.out.println("array objects :"+it.toString());
        }
       
        
	}

}
