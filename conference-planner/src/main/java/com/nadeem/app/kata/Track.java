package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Track {

	private String name;
	private Date date;
	private List<Session> sessions;

	public Track(String name, Date date) {
		this.name = name;
		this.date = date;
		this.sessions = new ArrayList<Session>();
	}

	public void addSession(Session session) {
		this.sessions.add(session);
	}

	public String getName() {
		return this.name;
	}

	public Date getDate() {
		return this.date;
	}

	public void forEachSession(Action<Session> action) {
		for (Iterator<Session> iterator = sessions.iterator(); iterator.hasNext();) {
			action.call(iterator.next());			
		}
	}
}
