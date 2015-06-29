package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Date;
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
	
	public List<Session> getSessions() {
		return this.sessions;
	}
}
