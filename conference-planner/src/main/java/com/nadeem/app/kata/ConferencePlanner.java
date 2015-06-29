package com.nadeem.app.kata;

import java.util.Date;

public class ConferencePlanner {

	private static final int DURATION_FOUR_HOURS = 240;
	private static final int DURATION_THREE_HOURS = 180;
	private static final int DURATION_ONE_HOUR = 60;

	private Conference conference;

	private ConferencePlanner(String name) {
		this.conference =  new Conference(name);
	}

	public static ConferencePlanner conference(String name) {
		return new ConferencePlanner(name);
	}

	public Conference build(Date start, int numberOfTracksPerDay, Talks talks) {

		Date confDate = (Date) start.clone();

		while (talks.enoughTasks()) {
			for (int i = 0; i < numberOfTracksPerDay; i++) {
				Date trackDate =  atNineAM(confDate);
				Track track = new Track("Track " + i, trackDate);

				buildMorningSession(talks, trackDate, track);
				buildLunchSession(trackDate, track);
				Session afterNoonSession = buildAfterNoonSession(talks, trackDate, track);
				Date eveningSessionDate = eveningSessionDate(trackDate, afterNoonSession);
				buildEveningSession(track, eveningSessionDate);

				this.conference.addTrack(track);
			}
			confDate = DateTimeUtil.getNextDay(confDate);
		}		

		return this.conference;
	}

	private void buildMorningSession(Talks talks, Date trackDate, Track track) {
		Session session = new Session("Morning Session", atNineAM(trackDate), DURATION_THREE_HOURS);
		addTalks(talks, session);
		track.addSession(session);
	}

	private void buildLunchSession(Date trackDate, Track track) {
		Session session = new Session("Lunch Session", atAfterNoon(trackDate), DURATION_ONE_HOUR);
		session.add("Lunch", 60);
		track.addSession(session);
	}

	private Session buildAfterNoonSession(Talks talks, Date trackDate, Track track) {
		Session session = new Session("Afternoon Session", atOnePM(trackDate), DURATION_FOUR_HOURS);
		addTalks(talks, session);
		track.addSession(session);
		return session;
	}

	private void buildEveningSession(Track track, Date eveningSessionDate) {
		Session session = new Session("Evening Session", eveningSessionDate, DURATION_ONE_HOUR);
		session.add("Networking Event", 60);
		track.addSession(session);
	}

	private void addTalks(Talks talks, final Session session) {

		talks.assign(new ResposiveAction<Talk>() {

			public void call(Talk talk) {
				session.add(talk.getName(), talk.getDuration());				
			}

			public void onException(Exception exception) {
				if (!shouldIgnore(exception)) {
					throw new RuntimeException(exception);
				}				
			}

			private boolean shouldIgnore(Exception exception) {
				return exception instanceof IllegalArgumentException;
			}
		});		
	}

	private Date eveningSessionDate(Date trackDate, Session afterNoonSession) {
		Date eveningSessionDate = fourPM(trackDate);
		Date endDate = afterNoonSession.getEndTime();
		if (endDate.after(fourPM(trackDate))) {
			eveningSessionDate = fivePM(trackDate);
		}
		return eveningSessionDate;
	}

	private Date atNineAM(Date confDate) {
		return DateTimeUtil.with(confDate, 9, 0);
	}

	private Date atOnePM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 13, 0);
	}

	private Date fivePM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 17, 0);
	}

	private Date fourPM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 16, 0);
	}

	private Date atAfterNoon(Date trackDate) {
		return DateTimeUtil.with(trackDate, 12, 0);
	}
}
