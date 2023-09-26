package com.design.patterns.memento;

public class Client {

	public static void main(String[] args) {
		
		Originator originator = new Originator("Initial state");
		
		CareTaker caretaker = new CareTaker();
		
		caretaker.saveState(originator.createMemento());
		System.out.println("Current state is :"+ originator.state);
		
		originator.state = "State 1";
		caretaker.saveState(originator.createMemento());
		System.out.println("Current state is :"+ originator.state);
		
		originator.state = "state 2";
		caretaker.saveState(originator.createMemento());
		System.out.println(" ## Current state is :"+ originator.state);
		
		System.out.println("\n --------------------------------"); 
		
		originator.restoreMemento(caretaker.restoreState(1));
		System.out.println("Current State is :"+originator.state);
	
		originator.restoreMemento(caretaker.restoreState(0));
		System.out.println("#### Current State is :"+originator.state);
		
		originator.restoreMemento(caretaker.restoreState(2));
		System.out.println("#### Current State is :"+originator.state);

	}

}
