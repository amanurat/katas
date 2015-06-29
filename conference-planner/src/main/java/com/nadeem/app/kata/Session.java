package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Session {

	private Date start;
	private int duration;
	private String name;
	private List<Talk> talks;
	private int durationSoFar = 0;

	public Session(String name, Date start, int duration) {
		this.name = name;
		this.start =  start;
		this.duration = duration;
		this.talks = new ArrayList<Talk>();
	}

	public void add(String name, int taskDuration) {
		if (durationSoFar + taskDuration > this.duration) {
			throw new IllegalArgumentException("Cant Add Task to this session");
		}
		Talk newTalk = newTalk(name, taskDuration, DateTimeUtil.addMinutes(this.start, this.durationSoFar));
		this.talks.add(newTalk);
		this.durationSoFar = this.durationSoFar + taskDuration;	
	}

	private Talk newTalk(String name, int taskDuration, Date start) {
		Talk talk = new Talk(name, taskDuration);
		talk.setStart(start);
		return talk;
	}

	public Date getEndTime() {		
		return DateTimeUtil.addMinutes(start, durationSoFar);
	}

	public String getName() {
		return this.name;
	}
	
	public Date getStart() {
		return this.start;
	}

	public void forEachTalk(Action<Talk> action) {
		for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext();) {
			action.call(iterator.next());			
		}
	}

}
