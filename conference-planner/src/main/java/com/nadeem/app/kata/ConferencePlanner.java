package com.nadeem.app.kata;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	public Conference build(Date start, int numberOfTracksPerDay, List<Talk> talks) {

		Date confDate = (Date) start.clone();

		while (!talks.isEmpty()) {
			for (int i = 0; i < numberOfTracksPerDay; i++) {
				Date trackDate =  nineAM(confDate);
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

	private void buildMorningSession(List<Talk> talks, Date trackDate, Track track) {
		Session morningSession = new Session("Morning Session", nineAM(trackDate), DURATION_THREE_HOURS);
		addTalks(talks, morningSession);
		track.addSession(morningSession);
	}

	private void buildLunchSession(Date trackDate, Track track) {
		Session lunchSession = new Session("Lunch Session", afterNoon(trackDate), DURATION_ONE_HOUR);
		lunchSession.add("Lunch", 60);
		track.addSession(lunchSession);
	}

	private Session buildAfterNoonSession(List<Talk> talks, Date trackDate, Track track) {
		Session afterNoonSession = new Session("Afternoon Session", onePM(trackDate), DURATION_FOUR_HOURS);
		addTalks(talks, afterNoonSession);
		track.addSession(afterNoonSession);
		return afterNoonSession;
	}

	private void buildEveningSession(Track track, Date eveningSessionDate) {
		Session eveningSession = new Session("Evening Session", eveningSessionDate, DURATION_ONE_HOUR);
		eveningSession.add("Networking Event", 60);
		track.addSession(eveningSession);
	}

	private void addTalks(List<Talk> talks, Session morningSession) {
		for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext();) {
			Talk talk = iterator.next();
			try {
				morningSession.add(talk.getName(), talk.getDuration());
				iterator.remove();

			} catch (IllegalArgumentException e) {
				// Just Ignore
			}
		}
	}

	private Date eveningSessionDate(Date trackDate, Session afterNoonSession) {
		Date eveningSessionDate = fourPM(trackDate);
		Date endDate = afterNoonSession.getEndTime();
		if (endDate.after(fourPM(trackDate))) {
			eveningSessionDate = fivePM(trackDate);
		}
		return eveningSessionDate;
	}

	private Date nineAM(Date confDate) {
		return DateTimeUtil.with(confDate, 9, 0);
	}

	private Date onePM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 13, 0);
	}

	private Date fivePM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 17, 0);
	}

	private Date fourPM(Date trackDate) {
		return DateTimeUtil.with(trackDate, 16, 0);
	}

	private Date afterNoon(Date trackDate) {
		return DateTimeUtil.with(trackDate, 12, 0);
	}
}
