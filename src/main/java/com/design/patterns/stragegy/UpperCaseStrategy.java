package com.design.patterns.stragegy;

public class UpperCaseStrategy implements PrintStrategy{

	@Override
	public String formatString(String input) {
		return input.toUpperCase();
	}

}
