package com.demo.multithreading;

public class MultiThreadAppDemo {

	public static void main(String[] args) {

		//Runner runner = new Runner();
		//runner.start();
		
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		
		//t1.start();
		//t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println( "Hello " +i);
					
					try {
						Thread.sleep(1000);
						System.out.println("Thread sleeps :");
					}catch(InterruptedException e) {
						System.out.println("InterruptedException");
					}
				}
			}
		});
		
		t3.start();
	}

}

/*class Runner extends Thread{
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println( "Hello " +i);
			
			try {
				Thread.sleep(1000);
				System.out.println("Thread sleeps :");
			}catch(InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
	}
}*/

class Runner implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println( "Hello " +i);
			
			try {
				Thread.sleep(1000);
				System.out.println("Thread sleeps :");
			}catch(InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}		
	}
	
}