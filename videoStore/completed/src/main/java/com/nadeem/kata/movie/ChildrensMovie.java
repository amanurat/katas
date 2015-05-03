package com.nadeem.kata.movie;

public class ChildrensMovie implements Movie {
	private String title; 

	public ChildrensMovie(String title) {
		this.title 		= title;
	}
	
	public String getTitle () {
		return title;
	}

	public int earnedFrequentRenterPoints(int daysRented) {
		return 1;
	}

	public double chargeAmount(int daysRented) {
		double thisAmount	= 1.5;

		if (daysRented > 3){
			thisAmount += (daysRented - 3) * 1.5;
		}

		return thisAmount;
	}
	
}
