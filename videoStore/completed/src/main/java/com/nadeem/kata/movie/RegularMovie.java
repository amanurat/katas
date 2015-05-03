package com.nadeem.kata.movie;

public class RegularMovie implements Movie {
	private String title;

	public RegularMovie(String title) {
		this.title 		= title;
	}
	
	public String getTitle () {
		return title;
	}

	public int earnedFrequentRenterPoints(int daysRented) {
		return 1;
	}

	public double chargeAmount(int daysRented) {
		double thisAmount	=  2;

		if (daysRented > 2){
			thisAmount += (daysRented - 2) * 1.5;
		}

		return thisAmount;
	}
	
}
