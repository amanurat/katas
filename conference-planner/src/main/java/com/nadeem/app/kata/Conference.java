package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.List;

public class Conference {

	private String name;
	private List<Track> tracks;

	public Conference(String name) {
		this.name = name;
		this.tracks = new ArrayList<Track>();
	}

	public void addTrack(Track track) {
		this.tracks.add(track);
	}

	public String getName() {
		return this.name;
	}
	
	public List<Track> getTracks() {
		return this.tracks;
	}
}
