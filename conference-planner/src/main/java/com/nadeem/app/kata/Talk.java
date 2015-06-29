package com.nadeem.app.kata;

import java.util.Date;

public class Talk {

	private Date start;
	private final String name;
	private final int duration;

	public Talk(String newName, int newDuration) {
		this.name = newName;
		this.duration = newDuration;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}
	

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", DateTimeUtil.getHourMinuteString(this.start), name, duration);
	}
}
