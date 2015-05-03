package com.nadeem.kata;


import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals			= new ArrayList<Rental>();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return name;
	}
	
	public double totalCharge() {
		double totalCharge	= 0.0;
		for(Rental rental:rentals){
			totalCharge+=rental.chargeAmount();
		}
		return totalCharge;
	}

	public int earnedFrequentRenterPoints() {
		int earnedFrequentRenterPoints = 0;
		for(Rental rental:rentals){
			earnedFrequentRenterPoints	+= rental.earnedFrequentRenterPoints();
		}
		return earnedFrequentRenterPoints;
	}

	public String statement () {
		StringBuffer statement	= new StringBuffer(statementHeader());
		
		for(Rental rental:rentals) {
			statement.append(statementLineItem(rental));
				
		}
		
		statement.append(statementFooter());
		
		return statement.toString();
	}

	private String statementFooter() {
		return "You owed " + String.valueOf (totalCharge()) 
							  + "\n" + "You earned " 
							  + String.valueOf (earnedFrequentRenterPoints()) 
							  + " frequent renter points\n";
	}

	private String statementLineItem(Rental rental) {
		return "\t" + rental.getMovie ().getTitle () + "\t"
							+ String.valueOf (rental.chargeAmount()) + "\n";
	}

	private String statementHeader() {
		return "Rental Record for " + getName () + "\n";
	}
	
}