package com.nadeem.kata.movie;


public interface Movie {

	int earnedFrequentRenterPoints(int daysRented);
	double chargeAmount(int daysRented);
	String getTitle();
}