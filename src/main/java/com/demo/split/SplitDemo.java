package com.demo.split;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

public class SplitDemo {
	private static final Pattern VALID_PATTERN = Pattern.compile("[0-9]+|[A-Z]+");

	public static void main(String[] args) {

		String str = "H04N19/087";
		List<String> phrase = splitPhrase(str);
		
		String section = null;
		String cpcclass = null;
		String subclass = null;
		String mainGroup = null;
		String subgroup = null;
		
		
			section= phrase.get(0);
			cpcclass= phrase.get(1);
			subclass= phrase.get(2);
			subgroup= phrase.get(3);
			mainGroup= phrase.get(4);
		
		System.out.println("section="+section);
		System.out.println("cpcclass="+cpcclass);
		System.out.println("subclass="+subclass);
		System.out.println("subgroup="+subgroup);
		System.out.println("mainGroup="+mainGroup);
		
		
		
	}

	private static List<String> splitPhrase(String toParse) {
		List<String> phrase = new LinkedList<String>();
		Matcher matcher = VALID_PATTERN.matcher(toParse);
		while (matcher.find()) {
			phrase.add(matcher.group());
		}
		return phrase;
	}

	

}
