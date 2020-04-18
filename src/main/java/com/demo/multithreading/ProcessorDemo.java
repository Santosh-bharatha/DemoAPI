package com.demo.multithreading;

import java.util.Scanner;

class Processor extends Thread {

	private boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		System.out.println("Shutting it down..!!");
		running = false;
	}
}

public class ProcessorDemo {

	private int count = 0;
	
	public synchronized void increment() {
		count ++;
	}

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		//proc1.start();

		//System.out.println("Press return to stop");

		//Scanner scanner = new Scanner(System.in);
		//scanner.nextLine();
		//proc1.shutdown();

		ProcessorDemo procDemo = new ProcessorDemo();
		procDemo.doWork();
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println("count : "+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
