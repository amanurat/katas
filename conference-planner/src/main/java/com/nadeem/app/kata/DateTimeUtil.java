package com.nadeem.app.kata;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	private DateTimeUtil() {

	}

	public static Date with(Date dateTime, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	public static Date addMinutes(Date dateTime, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}	
}
