package com.nadeem.app.kata;

import java.util.Date;

public class ConferencePlanner {

	private static final int DURATION_FOUR_HOURS = 240;
	private static final int DURATION_THREE_HOURS = 180;
	private static final int DURATION_ONE_HOUR = 60;

	private ConferencePlanner() {

	}

	public static NameStep planner() {
		return new Steps();
	}

	public static interface NameStep {
		StartDateStep name(String confrenceName);
	}

	public static interface StartDateStep {
		TrackStep startDate(Date date);
	}
	public static interface TrackStep {
		TalksStep trackCountPerDay(int trackCountPerDay);
	}
	public static interface TalksStep {
		BuildStep talks(Talks talks);
	}
	public static interface BuildStep {
		Conference build();
	}

	private static class Steps implements NameStep, StartDateStep, TrackStep, TalksStep, BuildStep {

		private String name;
		private int trackCountPerDay;
		private Date startDate;
		private Talks talks;

		public BuildStep talks(Talks talks) {
			this.talks = talks;
			return this;
		}

		public TalksStep trackCountPerDay(int trackCountPerDay) {
			this.trackCountPerDay = trackCountPerDay;
			return this;
		}

		public TrackStep startDate(Date date) {
			this.startDate = date;
			return this;
		}

		public StartDateStep name(String confrenceName) {
			this.name = confrenceName;
			return this;
		}

		public Conference build() {
			Date confDate = startDate;
			Conference conference = new Conference(this.name);
			while (talks.enoughAvailable()) {
				for (int i = 0; i < trackCountPerDay; i++) {
					Date trackDate =  atNineAM(confDate);
					Track track = new Track("Track " + i, trackDate);

					addMorningSession(track, talks, trackDate);
					addLunchSession(track, trackDate);
					Session afterNoonSession = addAfterNoonSession(track, talks, trackDate);
					Date eveningSessionDate = eveningSessionDate(trackDate, afterNoonSession);
					addEveningSession(track, eveningSessionDate);

					conference.addTrack(track);
				}
				confDate = DateTimeUtil.getNextDay(confDate);
			}		

			return conference;
		}
		
		private Session addMorningSession(Track track, Talks talks, Date trackDate) {
			Session session = new Session("Morning Session", atNineAM(trackDate), DURATION_THREE_HOURS);
			addTalks(talks, session);
			track.addSession(session);
			return session;
		}

		private Session addLunchSession(Track track, Date trackDate) {
			Session session = new Session("Lunch Session", atAfterNoon(trackDate), DURATION_ONE_HOUR);
			session.add("Lunch", 60);
			track.addSession(session);
			return session;
		}

		private Session addAfterNoonSession(Track track, Talks talks, Date trackDate) {
			Session session = new Session("Afternoon Session", atOnePM(trackDate), DURATION_FOUR_HOURS);
			addTalks(talks, session);
			track.addSession(session);
			return session;
		}

		private Session addEveningSession(Track track, Date eveningSessionDate) {
			Session session = new Session("Evening Session", eveningSessionDate, DURATION_ONE_HOUR);
			session.add("Networking Event", 60);
			track.addSession(session);
			return session;
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
}
