package com.nadeem.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nadeem.kata.movie.ChildrensMovie;
import com.nadeem.kata.movie.Movie;
import com.nadeem.kata.movie.NewReleaseMovie;
import com.nadeem.kata.movie.RegularMovie;



public class VideoStoreTest {

	private static final Movie REGULAR_MOVIE_1		= new RegularMovie("REGULAR_MOVIE_1");
	private static final Movie REGULAR_MOVIE_2 		= new RegularMovie("REGULAR_MOVIE_2");
	private static final Movie REGULAR_MOVIE_3		= new RegularMovie("REGULAR_MOVIE_3");
	private static final Movie CHILDRENS_MOVIE		= new ChildrensMovie("CHILDRENS_MOVIE");
	private static final Movie NEW_RELEASE_MOVIE_1	= new NewReleaseMovie("NEW_RELEASE_MOVIE_1");
	private static final Movie NEW_RELEASE_MOVIE_2	= new NewReleaseMovie("NEW_RELEASE_MOVIE_2");

	private Customer customer;

	@Before
	public void setUp ()  {
		customer = new Customer ("CUSTOMER");
	}

	@Test
	public void testSingleNewReleaseSummary () {
		customer.addRental(new Rental (NEW_RELEASE_MOVIE_1, 3));		
		assertSummary(9.0, 2);
	}

	@Test
	public void testDualNewReleaseSummary () {
		customer.addRental(new Rental (NEW_RELEASE_MOVIE_1, 3));
		customer.addRental(new Rental (NEW_RELEASE_MOVIE_2, 3));		
		assertSummary(18.0, 4);
	}

	@Test
	public void testSingleChildrensSummary () {
		customer.addRental(new Rental (CHILDRENS_MOVIE, 3));
		assertSummary(1.5, 1);
	}
	
	@Test
	public void testMultipleRegularSummary () {
		customer.addRental (new Rental (REGULAR_MOVIE_1, 1));
		customer.addRental (new Rental (REGULAR_MOVIE_2, 2));
		customer.addRental (new Rental (REGULAR_MOVIE_3, 3));
		assertSummary(7.5, 3);
	}

	@Test
	public void testMultipleRegularStatement () {
		customer.addRental (new Rental (REGULAR_MOVIE_1, 1));
		customer.addRental (new Rental (REGULAR_MOVIE_2, 2));
		customer.addRental (new Rental (REGULAR_MOVIE_3, 3));
		
		assertEquals ("Rental Record for CUSTOMER\n" +
						"\tREGULAR_MOVIE_1\t2.0\n" +
						"\tREGULAR_MOVIE_2\t2.0\n" +
						"\tREGULAR_MOVIE_3\t3.5\n" +
						"You owed 7.5\n" +
						"You earned 3 frequent renter points\n", customer.statement ());
	}

	private void assertSummary(double expectedTotalCharge, int expectedFrequentRenterPoints) {
		assertEquals(expectedTotalCharge, customer.totalCharge(), 0);
		assertEquals(expectedFrequentRenterPoints, customer.earnedFrequentRenterPoints());
	}

}