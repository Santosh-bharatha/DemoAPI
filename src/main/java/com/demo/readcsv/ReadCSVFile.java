package com.demo.readcsv;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class ReadCSVFile {

	public static String csvInput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/manifest_input.csv";
	public static void main(String[] args) {

		System.out.println("Reading the input CSV File");
		readDataLineByLine(csvInput);
	}

	public static void readDataLineByLine(String file) {
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			
			while((nextRecord = csvReader.readNext())!= null) {
				System.out.println(nextRecord[0]);
				//System.out.println(); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
