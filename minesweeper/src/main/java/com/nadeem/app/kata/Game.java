package com.nadeem.app.kata;

import java.util.List;

public class Game {

	private List<Location> locations;
	private RenderingStrategy renderingStrategy;

	public Game(List<Location> positions, RenderingStrategy rs) {
		this.locations = positions;
		this.renderingStrategy = rs;
		this.renderingStrategy.render("Game Initilized");
		this.renderingStrategy.render(locations);
	}

	public void open(Position position) {
		Location location = get(position);

		if (location != null) {
			doOpenValidPosition(position, location);			
		} else {
			this.renderingStrategy.render("Invalid " + position + "\n");
		}		
	}

	private void doOpenValidPosition(Position position, Location location) {
		if (location.explosive()) {
			location.markExploded();
			this.renderingStrategy.render("Game Over!!! You have blown explosive!!");
			throw new IllegalStateException("Game Over!!! You have blown explosive!!");
		}
		location.markOpened();
		this.renderingStrategy.render("Opening " + position);
		this.renderingStrategy.render(this.locations);
	}

	public void flag(Position position) {
		Location location = get(position);
		if (location != null) {
			doFlagValidPosition(position, location);	
		} else {
			this.renderingStrategy.render("Invalid " + position + "\n");
		}			
	}

	private void doFlagValidPosition(Position position, Location location) {
		if (location.safe()) {
			location.markInvlid();
			this.renderingStrategy.render("Game Over! You Flagged Invalid location!!");
			throw new IllegalStateException("Game Over! You Flagged Invalid location!!");
		}
		location.markFlagged();
		this.renderingStrategy.render("Flagging " + position);
		this.renderingStrategy.render(this.locations);
	}

	private Location get(Position position) {
		for (Location location : locations) {
			if (location.isIn(position)) {
				return location;
			}
		}
		return null;
	}

}
