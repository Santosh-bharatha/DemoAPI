package com.streams.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class StreamsFileDemo {

	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get("file.txt")).forEach(System.out::println);

	}

}
