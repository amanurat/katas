package com.nadeem.app.kata;

import java.util.Date;

import org.junit.Test;

import com.nadeem.app.kata.Talks.AddAndBuildStep;

public class ConferencePlannerTest {

	@Test
	public void printTest() {

		AddAndBuildStep tasksBuilder = Talks.builder();
		tasksBuilder.add("Task one", 30);
		tasksBuilder.add("Task two", 60);
		tasksBuilder.add("Task three", 30);
		tasksBuilder.add("Task four", 60);
		tasksBuilder.add("Task five", 60);
		tasksBuilder.add("Task six", 180);
		tasksBuilder.add("Task seven", 120);
		Talks talks = tasksBuilder.addAndBuild("eight", 120);

		ConferencePlanner planner = ConferencePlanner.conference("Test");
		Conference conference = planner.build(new Date(), 2, talks);
		System.out.println("Confrence : " + conference.getName());

		conference.forEachTrack(newTrackAction());		
	}

	private Action<Track> newTrackAction() {
		return new Action<Track>() {
			public void call(Track track) {
				System.out.println(track.getName() + " on " + DateTimeUtil.getDayString(track.getDate()));
				System.out.println("=============");
				track.forEachSession(newSessionAction());
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
