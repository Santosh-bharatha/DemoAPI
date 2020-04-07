package com.demo.filesystems;

import java.io.File;

public class FindFile {

	public static void main(String[] args) {
		//String directoryPath = "C:/PROJECT/WORK/input_dir";
		File[] filesInDirectory = new File("C:/PROJECT/WORK/input_dir").listFiles();
		for(File f : filesInDirectory){
		    String filePath = f.getAbsolutePath();
		    String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
		    if("csv".equals(fileExtenstion)){
		        System.out.println("CSV file found -> " + filePath);
		    }
		}       

	}

}
