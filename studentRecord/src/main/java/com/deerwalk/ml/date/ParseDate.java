package com.deerwalk.ml.date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseDate {

	private SimpleDateFormat formatDate = new SimpleDateFormat();
	private Date parsedDate;
	private Date currentDate;
	
	public Date parseString(String date){
		
		try {
			parsedDate = formatDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return parsedDate;
	}
	
	public String currentDate(){
		
		currentDate = new Date();
		return currentDate.toString();
	}
	
	public String parseToString(Date date){
		
		return formatDate.format(date);
	}
}
