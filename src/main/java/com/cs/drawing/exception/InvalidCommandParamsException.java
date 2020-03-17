package com.cs.drawing.exception;

public class InvalidCommandParamsException extends RuntimeException {

	private final String help;

	public InvalidCommandParamsException(String message, String _help) {
		super(message);
		help = _help;
	}

	public String getHelpMessage() {
		return help;
	}
}
