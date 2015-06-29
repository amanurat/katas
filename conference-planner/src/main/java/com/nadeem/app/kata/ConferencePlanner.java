package com.nadeem.app.kata;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ConferencePlanner {

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
				Date trackDate =  DateTimeUtil.with(confDate, 9, 0);
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

	private void buildEveningSession(Track track, Date eveningSessionDate) {
		Session eveningSession = new Session("Evening Session", eveningSessionDate, 60);
		eveningSession.add("Networking Event", 60);
		track.addSession(eveningSession);
	}

	private Session buildAfterNoonSession(List<Talk> talks, Date trackDate, Track track) {
		Session afterNoonSession = new Session("Afternoon Session", DateTimeUtil.with(trackDate, 13, 0), 240);
		addTalks(talks, afterNoonSession);
		track.addSession(afterNoonSession);
		return afterNoonSession;
	}

	private void buildLunchSession(Date trackDate, Track track) {
		Session lunchSession = new Session("Lunch Session", DateTimeUtil.with(trackDate, 12, 0), 60);
		lunchSession.add("Lunch", 60);
		track.addSession(lunchSession);
	}

	private void buildMorningSession(List<Talk> talks, Date trackDate,
			Track track) {
		Session morningSession = new Session("Morning Session", DateTimeUtil.with(trackDate, 9, 0), 180);
		addTalks(talks, morningSession);
		track.addSession(morningSession);
	}

	private Date eveningSessionDate(Date trackDate, Session afterNoonSession) {
		Date eveningSessionDate = DateTimeUtil.with(trackDate, 16, 0);
		Date endDate = afterNoonSession.getEndTime();
		if (endDate.after(DateTimeUtil.with(trackDate, 16, 0))) {
			eveningSessionDate = DateTimeUtil.with(trackDate, 17, 0);
		}
		return eveningSessionDate;
	}

	private void addTalks(List<Talk> talks, Session morningSession) {
		for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext();) {
			Talk talk = iterator.next();
			try {
				morningSession.add(talk.getName(), talk.getDuration());
				iterator.remove();

			} catch (IllegalArgumentException e) {
				// TODO: handle exception
			}
		}
	}
}
