package com.nadeem.kata.movie;

public class NewReleaseMovie implements Movie {
	private String title; 

	public NewReleaseMovie(String title) {
		this.title 		= title;
	}
	
	public String getTitle () {
		return title;
	}

	public int earnedFrequentRenterPoints(int daysRented) {
		if (daysRented > 1){
			return 2;
		}
		return 1;
	}

	public double chargeAmount(int daysRented) {
		return daysRented * 3;
	}
	
}
