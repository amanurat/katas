package com.nadeem.app.kata;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TalksTest {
	
	private Talks talks;

	@Before
	public void doBeforeEachTestCase() {
		talks = new Talks();
		talks.addTalk("Two", 2);
		talks.addTalk("Four", 4);
		talks.addTalk("One", 1);		
		talks.addTalk("Six", 6);
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
