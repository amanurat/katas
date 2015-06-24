package com.nadeem.app.kata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		List<Location> positions = locations();
		RenderingStrategy rg = new MatrixRenderingStrategy(3, 3);
		Game game = new Game(positions, rg);
		game.flag(postion(0,0));
		game.open(postion(0,1));
		game.open(postion(0,2));
		game.flag(postion(1,0));		
		game.open(postion(2,2));
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
			return String.format("(%s, %s)", x, y);
		}
	}

}
