package com.nadeem.app.kata;

public class Location {

	private Position position;
	private State state;
	private Characteristic characteristic; 

	private Location() {

	}

	public static Location explosiveLocation(Position position) {
		Location location  = new Location();
		location.position = position;
		location.characteristic = Characteristic.EXPLOSIVE;
		location.state = State.CLOSED;
		return location;
		 
	}

	public static Location safeLocation(Position position) {
		Location location  = new Location();
		location.position = position;
		location.characteristic = Characteristic.SAFE;
		location.state = State.CLOSED;
		return location;
	}

	public void markOpened() {
		this.state =  State.OPENED;
	}

	public boolean explosive() {
		return Characteristic.EXPLOSIVE == this.characteristic;
	}

	public boolean safe() {
		return !explosive();
	}

	private enum State {
		CLOSED, OPENED;
	}
	
	private enum Characteristic {
		SAFE, EXPLOSIVE;
	}

	public boolean isOpened() {
		return State.OPENED == this.state;
	}

	public boolean isIn(Position position2) {
		return this.position.equals(position2);
	}

}
