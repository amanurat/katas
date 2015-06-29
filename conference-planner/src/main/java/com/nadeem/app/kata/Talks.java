package com.nadeem.app.kata;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Talks {

	private static final int DEFAULT_TASKS_COUNT = 50;
	private PriorityQueue<Talk> talks;

	private Talks() {
		this.talks = new PriorityQueue<Talk>(DEFAULT_TASKS_COUNT, maxHeap());
	}

	public static AddAndBuildStep builder() {
		return new Steps();
	}

	private Comparator<Talk> maxHeap() {
		return new Comparator<Talk>() {

			public int compare(Talk o1, Talk o2) {
				return o2.getDuration() - o1.getDuration();
			}			
		};
	}

	private void addTalk(String name, int duration) {
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

	public void assign(ResposiveAction<Talk> action) {
		for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext();) {
			Talk talk = iterator.next();
			try {
				action.call(talk);
				iterator.remove();
			} catch (Exception e) {
				action.onException(e);
			}
		}
	}

	public boolean enoughTasks() {
		return !this.talks.isEmpty();
	}

	public static interface AddAndBuildStep {
		AddAndBuildStep add(String name, int duration);
		Talks addAndBuild(String name, int duration);
	}

	private static class Steps implements  AddAndBuildStep {

		private Talks talks;

		public Steps() {
			this.talks = new Talks();
		}

		public AddAndBuildStep add(String name, int duration) {
			this.talks.addTalk(name, duration);
			return this;
		}

		public Talks addAndBuild(String name, int duration) {
			this.talks.addTalk(name, duration);
			return this.talks;
		}
	}
}
