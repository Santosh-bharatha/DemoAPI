package com.demo.collections.TreeMap;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2);
	}

}
