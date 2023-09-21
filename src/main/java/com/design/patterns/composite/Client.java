package com.design.patterns.composite;

public class Client {

	public static void main(String[] args) {

		Composite computer = new Composite("PC");
		Equipment processor = new Equipment("Processor", 1000);
		Equipment hdd = new Equipment("Hard Drive", 250);
		Composite memory = new Composite("Memory");
		Equipment rom = new Equipment("Read only Memory", 75);
		Equipment ram = new Equipment("Random Access Memory", 100);
		
	
		memory.add(ram).add(rom);
		computer.add(processor).add(memory);
		
		System.out.println("PC Price :"+computer.getPrice());
	}

}
