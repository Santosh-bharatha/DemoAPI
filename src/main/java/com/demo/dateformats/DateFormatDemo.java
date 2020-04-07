package com.demo.dateformats;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateFormatDemo {
	
	 private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public static void main(String[] args) {
		
     String pattern = "yyyy-MM-dd";
     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
     
     String date = simpleDateFormat.format(new Date());
     System.out.println(date);
     
     Date now = new Date();
     System.out.println(now);
     
     Calendar cal = Calendar.getInstance();
     System.out.println(sdf.format(cal.getTime()));
	}

}
