package com.cs.drawing.command;

import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;
import com.cs.drawing.exception.InvalidCommandParamsException;

public class CanvasFillCommand implements Command {
	private int x;
	private int y;

	private char character;

	public CanvasFillCommand(String... params) {
		if (params.length != 3)
			throw new InvalidCommandParamsException(ErrorMessages.PARAMS_LENGTH_VALIDATION_FOR_3,
					ErrorMessages.CANVAS_FILL_VALIDATION);
		if (params[2].length() != 1)
			throw new InvalidCommandParamsException(ErrorMessages.COLOR_CHAR_VALIDATION,
					ErrorMessages.CANVAS_FILL_VALIDATION);
		try {
			x = Utils.parseInt(params[0]);
			y = Utils.parseInt(params[1]);
			character = params[2].charAt(0);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandParamsException(ErrorMessages.COORDINATES_XY_VALIDATION,
					ErrorMessages.CANVAS_FILL_VALIDATION);
		}
	}

	public int getX() {
		return x;
	}

	public CanvasFillCommand setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public CanvasFillCommand setY(int y) {
		this.y = y;
		return this;
	}

	public char getCharacter() {
		return character;
	}

	public CanvasFillCommand setCharacter(char character) {
		this.character = character;
		return this;
	}
}

