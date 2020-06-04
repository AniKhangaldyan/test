package com.epam.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss") ;
	static Date sbjDate;
	 
	public static String generateSubject(){
		sbjDate = new Date();		
		return dateFormat.format(sbjDate);
	}
	
	public static String generateBody(){
		return "Some text";
	}
	
	  
}
