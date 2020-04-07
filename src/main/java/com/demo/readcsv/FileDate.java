package com.demo.readcsv;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;

public class FileDate {

	public static void main(String[] args) {
		
		Calendar cal =  Calendar.getInstance();
		cal.setTime(Date.from(Instant.now()));
		
		String result = String.format(
                "%1$tY%1$tm%1$td.xml", cal);
		
		System.out.println("FileName: "+result);

	}

}
