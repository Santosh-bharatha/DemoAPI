package com.demo.readcsv;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchDir {

	public static String folderPath = "H:/DOCS/Full_Class/InputFiles";
	public static void main(String[] args) throws IOException {

		File folder = new File(folderPath);
		 
		 if(folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();
			if(listOfFiles.length < 1) {
				System.out.println("Empty Folder");
			}else {
				for(File file : listOfFiles) {
					if(!file.isDirectory())System.out.println(
				               file.getCanonicalPath().toString());
				}
					
			}
		 }else {
			 System.out.println("There is no Folder @ given path :");
		 }
	}

}
