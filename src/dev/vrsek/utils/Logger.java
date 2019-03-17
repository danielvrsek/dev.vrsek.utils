package dev.vrsek.utils;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	private static Logger current = new Logger();
	private List<String> messages = new ArrayList<>();

	public static void log(String message) {
		current.logMessage(message);
	}

	public static void logf(String message, String... args) {
		current.logMessage(String.format(message, args));
	}

	// Creates new instance for logger and gets the current one
	public static Logger refresh() {
		Logger old = current;
		current = new Logger();

		return old;
	}

	private void logMessage(String message) {
		messages.add(message);
		System.out.println(message);
	}

	public List<String> getMessages() {
		return messages;
	}
}
