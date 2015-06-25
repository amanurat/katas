package com.nadeem.app.kata;

import java.util.Iterator;
import java.util.List;

public class MatrixRenderingStrategy implements RenderingStrategy {
	
	private int rowCount;
	private int columnCount;
	
	public MatrixRenderingStrategy(int rows, int columns) {
		this.rowCount = rows;
		this.columnCount = columns;
	}

	public void render(List<Location> locations) {
		System.out.println();
		Iterator<Location> itr = locations.iterator();
		for (int rows = 0; rows < rowCount; rows++) {
			for (int columns = 0; columns < columnCount; columns++) {
				if (itr.hasNext()) {
					System.out.print(data(itr.next()));
				}
			}
			System.out.println();
		}
	}

	private String data(Location location) {
		return location.statusCode();
	}

	public void render(String string) {
		System.out.print(string);		
	}
}
