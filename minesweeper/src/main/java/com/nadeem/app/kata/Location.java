package com.nadeem.app.kata;

public class Location {

	private Position position;
	private Status status;
	private Type type; 

	private Location() {

	}

	public static Location explosiveLocation(Position position) {
		Location location  = new Location();
		location.position = position;
		location.type = Type.EXPLOSIVE;
		location.status = Status.CLOSED;
		return location;		 
	}

	public static Location safeLocation(Position position) {
		Location location  = new Location();
		location.position = position;
		location.type = Type.SAFE;
		location.status = Status.CLOSED;
		return location;
	}

	public void markOpened() {
		this.status =  Status.OPENED;
	}
	
	public void markFlagged() {
		this.status =  Status.FLAGGED;
	}
	public void markExploded() {
		this.status =  Status.EXPLODED;
	}
	public void markInvlid() {
		this.status =  Status.INVALID;
	}

	public boolean explosive() {
		return Type.EXPLOSIVE == this.type;
	}

	public boolean safe() {
		return !explosive();
	}
	
	public String statusCode() {
		return this.status.getCode();
	}

	private enum Status {
		CLOSED("X"), OPENED("O"), FLAGGED("F"), EXPLODED("E"), INVALID("I");
		private String code;
		private Status(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

	private enum Type {
		SAFE, EXPLOSIVE;
	}

	public boolean isOpened() {
		return Status.OPENED == this.status;
	}

	public boolean isIn(Position position2) {
		return this.position.equals(position2);
	}

}
