package com.nadeem.app.kata;

public interface ResposiveAction<T> extends Action<T> {
	void onException(Exception exception);
}
