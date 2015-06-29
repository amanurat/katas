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

		for (int i = 0; i < numberOfTracksPerDay; i++) {
			Date trackDate =  DateTimeUtil.with(start, 9, 0);
			Track track = new Track("Track " + i, trackDate);

			Session morningSession = new Session("Morning Session", DateTimeUtil.with(trackDate, 9, 0), 180);
			addTalks(talks, morningSession);
			track.addSession(morningSession);

			Session lunchSession = new Session("Lunch Session", DateTimeUtil.with(trackDate, 12, 0), 60);
			lunchSession.add("Lunch", 60);
			track.addSession(lunchSession);

			Session afterNoonSession = new Session("Afternoon Session", DateTimeUtil.with(trackDate, 13, 0), 240);
			addTalks(talks, afterNoonSession);
			track.addSession(afterNoonSession);

			Date eveningSessionDate = DateTimeUtil.with(trackDate, 16, 0);
			Date endDate = afterNoonSession.getEndTime();
			if (endDate.after(DateTimeUtil.with(trackDate, 16, 0))) {
				eveningSessionDate = DateTimeUtil.with(trackDate, 17, 0);
			}

			Session eveningSession = new Session("Evening Session", eveningSessionDate, 60);
			eveningSession.add("Networking Event", 60);
			track.addSession(eveningSession);

			this.conference.addTrack(track);
		}

		return this.conference;
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
