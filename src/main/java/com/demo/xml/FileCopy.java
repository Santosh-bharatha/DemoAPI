/*package com.demo.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCopy {

	private static String xmlFilePath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xsd/CPCTemplate.xml";
	private static String xmlOutputPath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xsd/testfile.xml";
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream instream = null;
		FileOutputStream outputstream = null;
		
		File infile = new File(xmlFilePath);
		File outfile = new File(xmlOutputPath);
		
		instream = new FileInputStream(infile);
	    outstream = new FileOutputStream(outfile);

	    byte[] buffer = new byte[1024];

	    int length;
	    copying the contents from input stream to
	     * output stream using read and write methods
	     
	    while ((length = instream.read(buffer)) > 0){
	    	outstream.write(buffer, 0, length);
	    }

	    //Closing the input/output file streams
	    instream.close();
	    outstream.close();
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFilePath), "UTF-8"));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlOutputPath), "UTF-8"));

         String line = null;

         while ((line = reader.readLine()) != null)
         {
             writer.write(line);
         }

         reader.close();
         writer.close();
         
         System.out.println("File copied successfully!!");
     }
		
		 

}
*/