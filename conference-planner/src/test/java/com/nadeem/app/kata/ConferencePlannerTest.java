package com.nadeem.app.kata;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.kata.Talks.AddAndBuildStep;

public class ConferencePlannerTest {

	private Talks talks;

	@Before
	public void doBeforeEachTestCase() {
		AddAndBuildStep tasksBuilder = Talks.builder();
		tasksBuilder.add("Task one", 30);
		tasksBuilder.add("Task two", 60);
		tasksBuilder.add("Task three", 30);
		tasksBuilder.add("Task four", 60);
		tasksBuilder.add("Task five", 60);
		tasksBuilder.add("Task six", 180);
		tasksBuilder.add("Task seven", 120);
		this.talks = tasksBuilder.addAndBuild("eight", 120);
	}

	@Test
	public void printTest() {	

		Conference conference = ConferencePlanner.planner()
												.name("test")
												.startDate(new Date())
												.trackCountPerDay(2)
												.talks(talks)
												.build();

		System.out.println("Confrence : " + conference.getName());
		System.out.println("************");
		conference.forEachTrack(newTrackAction());		
	}

	private Action<Track> newTrackAction() {
		return new Action<Track>() {
			public void call(Track track) {
				System.out.println(track.getName() + " on " + DateTimeUtil.getDayString(track.getDate()));
				System.out.println("=============");
				track.forEachSession(newSessionAction());
				System.out.println("=============\n");
			}
		};
	}

	private Action<Session> newSessionAction() {
		return new Action<Session>() {
			public void call(Session session) {
				System.out.println(session.getName() + " : " + DateTimeUtil.getDayString(session.getStart()));
				session.forEachTalk(newTalkAction());						
			}
		};
	}

	private Action<Talk> newTalkAction() {
		return new Action<Talk>() {
			public void call(Talk talk) {
				System.out.println(talk);								
			}
		};
	}
}
