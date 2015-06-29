package com.nadeem.app.kata;

public class ConsolePrinter implements ConferencePrinter {

	public void print(Conference conference) {
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
