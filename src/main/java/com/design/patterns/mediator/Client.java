package com.design.patterns.mediator;

public class Client {

	public static void main(String[] args) {
		
		Mediator mediator = new Mediator();
		ChatUser alice = new ChatUser("Alice", mediator);
		ChatUser bob = new ChatUser("bob", mediator);
		ChatUser josh = new ChatUser("josh", mediator);
		ChatUser carol = new ChatUser("carol", mediator);
		
		mediator.addUser(alice).addUser(carol).addUser(josh).addUser(bob);
		
		carol.sendMessage("Hello Everyone !");
		

	}

}
