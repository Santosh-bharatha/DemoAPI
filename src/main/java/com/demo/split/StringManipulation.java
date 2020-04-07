package com.demo.split;

import java.util.ArrayList;
import java.util.List;

public class StringManipulation {

	public static void main(String[] args) {

		String symbolPosition = null;

		List<String> typeList = logicPositionValue("A");

		System.out.println("::symbolPosition : " + typeList.get(0));
		System.out.println("::classificationValue : " + typeList.get(1));
	}

	public static List<String> logicPositionValue(String type) {
		List<String> typeList = new ArrayList<String>(5);
		String symbolPosition = null;
		String classificationValue = null;
		if (type != null) {
			if (type == "F") {
				typeList.add(symbolPosition = "F");
				typeList.add(classificationValue = "I");

			} else if (type == "I") {
				typeList.add(symbolPosition = "I");
				typeList.add(classificationValue = "L");
			} else if (type == "A") {
				typeList.add(symbolPosition = "L");
				typeList.add(classificationValue = "A");
			}
		}
		return typeList;
	}

}
