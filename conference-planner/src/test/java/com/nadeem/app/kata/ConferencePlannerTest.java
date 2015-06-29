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

		ConferencePrinter printer = new ConsolePrinter();
		printer.print(conference);
	}

}
