package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	public static Date convertToDateDB(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
}
