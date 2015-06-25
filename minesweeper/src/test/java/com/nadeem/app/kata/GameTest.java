package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void doBeforeEachTestCase() {
		System.out.println("\n\n");
		game = new Game(locations(), new MatrixRenderingStrategy(3, 3));
	}
	@Test(expected = IllegalStateException.class)
	public void testGameOver() {
		game.open(postion(2,0));
	}

	@Test
	public void testMoves() {
		game.open(postion(3,3));
		game.flag(postion(0,0));
		game.open(postion(0,1));
		game.open(postion(0,2));
		game.flag(postion(1,0));		
		game.open(postion(2,2));
		game.open(postion(2,1));
		game.flag(postion(2,0));
		game.open(postion(1,2));
		game.open(postion(1,1));
	}

	private List<Location> locations() {
		List<Location> locations = new ArrayList<Location>();
		locations.add(Location.explosiveLocation(postion(0, 0)));
		locations.add(Location.safeLocation(postion(0, 1)));
		locations.add(Location.safeLocation(postion(0, 2)));
		locations.add(Location.explosiveLocation(postion(1, 0)));
		locations.add(Location.safeLocation(postion(1, 1)));
		locations.add(Location.safeLocation(postion(1, 2)));
		locations.add(Location.explosiveLocation(postion(2, 0)));
		locations.add(Location.safeLocation(postion(2, 1)));
		locations.add(Location.safeLocation(postion(2, 2)));
		return locations;
	}

	private Position postion(int x, int y) {
		return new Point(x, y);
	}

	private class Point implements Position {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point other = (Point) obj;
				return this.x == other.x && this.y == other.y;
			}
			return false;
		}
		@Override
		public String toString() {
			return String.format("Position(%s, %s)", x, y);
		}
	}

}
