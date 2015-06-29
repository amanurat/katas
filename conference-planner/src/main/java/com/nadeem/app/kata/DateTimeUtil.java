package com.nadeem.app.kata;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	private DateTimeUtil() {

	}

	public static Date with(Date dateTime, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date addDay(Date dateTime, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	public static Date getNextDay(Date dateTime) {
		return addDay(dateTime, 1);
	}
	public static Date getPreviousDay(Date dateTime) {
		return addDay(dateTime, -1);
	}

	public static Date addMinutes(Date dateTime, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static String getHourMinuteString(Date dateTime) {
		return new SimpleDateFormat("H:mm").format(dateTime);
	}

	public static String getDayString(Date dateTime) {
		return new SimpleDateFormat("yyyy-MM-dd").format(dateTime);
	}
}
