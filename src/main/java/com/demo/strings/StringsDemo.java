package com.demo.strings;

public class StringsDemo {

	public static void main(String[] args) {

		String s = "abcd";
		String s2 = s;
		
		s = s.concat("ef");
		System.out.println(s);
		System.out.println(s2);
		
		StringBuffer sbuff = new StringBuffer("abcd");
		StringBuffer sbuff2 = sbuff;
		StringBuffer sbuff3 =new StringBuffer("GeeksforGeeks");
		
		sbuff = sbuff.append(sbuff3);
		System.out.println(sbuff);
		System.out.println(sbuff2);
		
		StringBuilder sb = new StringBuilder("abcd");
		StringBuilder sb2 = sb;
		StringBuilder sb3 = new StringBuilder("efg");
		
		sb = sb.append(sb3);
		System.out.println(sb);
		System.out.println(sb2);
		
		String str = "abcd";
		String result = str.toUpperCase();
		System.out.println(result);
		
		System.out.println("======================================");
		
		String s1 = "Geeks";
		concat1(s1);
		System.out.println(s1);
		StringBuilder sbuild = new StringBuilder("Geeks");
		concat2(sbuild);
		System.out.println( sbuild);
		StringBuffer sbuffer = new StringBuffer("Buffer");
		concat3(sbuffer);
		System.out.println(sbuffer);
	}

	
	public static void concat1(String s1) {
		s1 = s1 + "Hello";
	}
	public static void concat2(StringBuilder s2) {
		s2.append("forgeeks");
		
	}
	public static void concat3(StringBuffer s3) {
		s3.append("forgeeks");
	}
}
