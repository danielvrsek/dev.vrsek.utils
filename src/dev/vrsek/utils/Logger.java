package dev.vrsek.utils;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	private static Logger current = new Logger();
	private List<String> messages = new ArrayList<>();

	public static void log(String message) {
		current.logMessage(message);
	}

	// Creates new instance for logger and gets the current one
	public static Logger refresh() {
		Logger old = current;
		current = new Logger();

		return old;
	}

	private void logMessage(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}
}
