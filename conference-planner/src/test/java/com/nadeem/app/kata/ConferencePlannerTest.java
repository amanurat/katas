package com.nadeem.app.kata;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ConferencePlannerTest {

	private Talks talks;

	@Before
	public void doBeforeEachTestCase() {
		this.talks = Talks.builder()
				.add("Task one", 30)
				.add("Task two", 60)
				.add("Task three", 30)
				.add("Task four", 60)
				.add("Task five", 60)
				.add("Task six", 180)
				.add("Task seven", 120)
				.addAndBuild("eight", 120);
	}

	@Test
	public void printTest() {	

		Conference conference = ConferencePlanner.planner()
												.name("test")
												.startDate(new Date())
												.trackCountPerDay(2)
												.talks(talks)
												.build();

		ConferencePrinter printer = new ConsolePrinter();
		printer.print(conference);
	}

}
