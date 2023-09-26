package com.design.patterns.stragegy;

public class LowerCaseStrategy implements PrintStrategy{

	@Override
	public String formatString(String input) {
		return input.toLowerCase();
	}

}
