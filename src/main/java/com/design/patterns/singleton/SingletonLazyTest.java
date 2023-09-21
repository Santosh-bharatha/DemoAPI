package com.design.patterns.singleton;

public class SingletonLazyTest {

	public static void main(String[] args) {
		
		SingletonLazy singletonLazy  = new SingletonLazy().getInstance();
		SingletonLazy singletonLazy2  = new SingletonLazy().getInstance();
		
		System.out.println(singletonLazy);
		System.out.println(singletonLazy2);
		

	}

}
