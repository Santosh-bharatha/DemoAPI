package com.design.patterns.stragegy;

import java.util.Random;

public class RandomCaseStrategy implements PrintStrategy {

	@Override
	public String formatString(String input) {
		String output = "";
		Random rand = new Random();
		for (Character ch : input.toCharArray()) {
			if (rand.nextBoolean()) {
				output += ch.toString().toLowerCase();
			} else {
				output += ch.toString().toUpperCase();
			}
		}
		return output;
	}

}
