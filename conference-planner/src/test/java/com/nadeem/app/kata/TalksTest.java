package com.nadeem.app.kata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.app.kata.Talks.AddAndBuildStep;

public class TalksTest {
	
	private Talks talks;

	@Before
	public void doBeforeEachTestCase() {
		
		AddAndBuildStep addTalk = Talks.builder();

		addTalk.add("Two", 2);
		addTalk.add("Four", 4);
		addTalk.add("One", 1);		
		this.talks = addTalk.addAndBuild("Six", 6);
	}

	@Test
	public void elementShouldBeSix() {
		assertThat(talks.getMax().getDuration(), is(6));
	}

	@Test
	public void elementShouldBeTwo() {
		talks.getMax();
		talks.getMax();
		assertThat(talks.getMax().getDuration(), is(2));
	}

	@Test
	public void elementShouldBeNull() {
		talks.getMax();
		talks.getMax();
		talks.getMax();
		talks.getMax();
		talks.getMax();
		talks.getMax();
		assertNull(talks.getMax());
	}

}
