package com.design.patterns.decorator;

public class EnhancedCoffeeMachine implements CoffeeMachine{
	
	private NormalCoffeeMachine machine;
	
	public EnhancedCoffeeMachine(NormalCoffeeMachine machine) {
		this.machine = machine;
	}
	
	
// overriddern behaviour
	@Override
	public void makeSmallCoffee() {
		System.out.println("Enhanced coffee machine: Making coffee");
	}

	
	//un-alterned behaviour
	@Override
	public void makeLargeCoffee() {
		machine.makeLargeCoffee();
	}
	
	
	//Extended behaviour
	public void makeMilkCoffee() {
		System.out.println("Enhanced coffee machine : make milk coffee");
		machine.makeLargeCoffee();
		System.out.println("Enhanced coffee machine : Adding Milk");
	}
	

}
