package com.nadeem.kata;

import com.nadeem.kata.movie.Movie;


public class Rental {

	private Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented () {
		return daysRented;
	}
	
	public Movie getMovie () {
		return movie;
	}
	
	protected int earnedFrequentRenterPoints() {
		return movie.earnedFrequentRenterPoints(getDaysRented());
	}

	protected double chargeAmount() {
		return movie.chargeAmount(getDaysRented());
	}
}