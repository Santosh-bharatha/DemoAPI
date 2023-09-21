package com.design.patterns.abstractFactory;

public class ClientDemo {

	public static void main(String[] args) {
		
		Client client1 = new Client(new DatabaseFactory());
		client1.communicate();
		
		Client client2 = new Client(new NetworkFactory());
		client2.communicate();
		
		
		

	}

}
