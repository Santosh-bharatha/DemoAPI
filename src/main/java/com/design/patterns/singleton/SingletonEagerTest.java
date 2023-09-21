package com.design.patterns.singleton;

public class SingletonEagerTest {

	public static void main(String[] args) {
		
		SingletonEager eagerInstance1 = SingletonEager.getEagerInstance();
		SingletonEager eagerInstance2 = SingletonEager.getEagerInstance();
		
		System.out.println(eagerInstance1);
		System.out.println(eagerInstance2);
		
		SingletonStaticBlock staticBlock1 = SingletonStaticBlock.getInstance();
		SingletonStaticBlock staticBlock2 = SingletonStaticBlock.getInstance();
		
		System.out.println(staticBlock1);
		System.out.println(staticBlock2);
		
		

	}

}
