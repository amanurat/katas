package com.nadeem.app.kata;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Talks implements Iterable<Talk> {

	private static final int DEFAULT_TASKS_COUNT = 50;
	private PriorityQueue<Talk> talks;

	public Talks() {
		this.talks = new PriorityQueue<Talk>(DEFAULT_TASKS_COUNT, maxHeap());
	}

	private Comparator<Talk> maxHeap() {
		return new Comparator<Talk>() {

			public int compare(Talk o1, Talk o2) {
				return o2.getDuration() - o1.getDuration();
			}			
		};
	}

	
	public void addTalk(String name, int duration) {
		this.talks.add(new Talk(name, duration));
	}

	public Talk getMax() {
		return this.talks.poll();
	}
	public int totalDuration() {
		int totalDuration = 0;
		for (Talk talk : talks) {
			totalDuration = totalDuration + talk.getDuration(); 
		}
		return totalDuration;
	}

	public Iterator<Talk> iterator() {
		return this.talks.iterator();
	}
}
