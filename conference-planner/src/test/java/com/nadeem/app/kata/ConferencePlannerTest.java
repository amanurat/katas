package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ConferencePlannerTest {

	@Test
	public void test() {
		List<Talk> talks = new ArrayList<Talk>();
		Talk one = new Talk("one", 30);
		Talk two = new Talk("two", 60);
		Talk three = new Talk("three", 30);
		Talk four = new Talk("four", 60);
		Talk five = new Talk("five", 60);
		Talk six = new Talk("six", 180);
		Talk seven = new Talk("seven", 120);
		Talk eight = new Talk("eight", 120);

		talks.add(one);
		talks.add(two);
		talks.add(three);
		talks.add(four);
		talks.add(five);
		talks.add(six);
		talks.add(seven);
		talks.add(eight);

		ConferencePlanner planner = ConferencePlanner.conference("Test");
		Conference conference = planner.build(new Date(), 1, talks);
		System.out.println("Confrence : " + conference.getName());
		for (Track track : conference.getTracks()) {
			System.out.println(track.getName() + " : " + DateTimeUtil.getDayString(track.getDate()));
			System.out.println("=============");
			for (Session session : track.getSessions()) {
				System.out.println(session.getName()+ " : " + session.getStart());
				for (Talk talk : session.getTalks()) {
					System.out.println(talk);
				}
			}
		}
	}

}
