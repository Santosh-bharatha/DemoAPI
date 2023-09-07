package com.streams.demo;

public class StreamsThreadsDemo {

public static void main(String[] args) {
		
		Runnable runnable  = new Runnable() {

			@Override
			public void run() {
				for(int i=0; i <1000; i++) {
					System.out.println("First Thread"+Thread.currentThread().getId()+":"+i);
				}
				
			}
			
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
		
		Runnable runnable2 =  () ->{
			for(int i=0; i <1000; i++) {
				System.out.println("Second Thread"+Thread.currentThread().getId()+":"+i);
			}
		};

		Thread thread1 = new Thread(runnable2);
		thread1.start();
	}

}
