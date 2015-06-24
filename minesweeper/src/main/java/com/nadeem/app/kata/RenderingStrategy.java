package com.nadeem.app.kata;

import java.util.List;

public interface RenderingStrategy {
	void render(List<Location> locations);
	void render(String string);
}
