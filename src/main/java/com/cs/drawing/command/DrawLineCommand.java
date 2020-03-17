package com.cs.drawing.command;

import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;
import com.cs.drawing.exception.InvalidCommandParamsException;

public class DrawLineCommand implements Command {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public DrawLineCommand(String... params) {
		if (params.length != 4)
			throw new InvalidCommandParamsException(ErrorMessages.LINE_PARAM_VALIDATION,
					ErrorMessages.DRAW_LINE_VALIDATION);
		try {
			x1 = Utils.parseInt(params[0]);
			y1 = Utils.parseInt(params[1]);
			x2 = Utils.parseInt(params[2]);
			y2 = Utils.parseInt(params[3]);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandParamsException(ErrorMessages.COORDINATES_VALIDATION,
					ErrorMessages.DRAW_LINE_VALIDATION);
		}
		if (x1 != x2 && y1 != y2) {
			throw new InvalidCommandParamsException(ErrorMessages.LINE_INVALID_PARAM,
					ErrorMessages.DRAW_LINE_VALIDATION);
		}
	}

	public int getX1() {
		return x1;
	}

	public DrawLineCommand setX1(int x1) {
		this.x1 = x1;
		return this;
	}

	public int getY1() {
		return y1;
	}

	public DrawLineCommand setY1(int y1) {
		this.y1 = y1;
		return this;
	}

	public int getX2() {
		return x2;
	}

	public DrawLineCommand setX2(int x2) {
		this.x2 = x2;
		return this;
	}

	public int getY2() {
		return y2;
	}

	public DrawLineCommand setY2(int y2) {
		this.y2 = y2;
		return this;
	}
}