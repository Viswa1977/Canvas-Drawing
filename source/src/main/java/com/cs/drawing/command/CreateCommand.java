package com.cs.drawing.command;

import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;
import com.cs.drawing.exception.InvalidCommandParamsException;

public class CreateCommand implements Command {
	private int height;
	private int width;

	public CreateCommand(String... params) {
		if (params.length < 2)
			throw new InvalidCommandParamsException(ErrorMessages.CMD_VALIDATION_SYNTAX, ErrorMessages.CREATE_CANVAS);
		try {
			width = Utils.parseInt(params[0]);
			height = Utils.parseInt(params[1]);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandParamsException(ErrorMessages.NUMBER_VALIDATION, ErrorMessages.CREATE_CANVAS);
		}
	}

	public int getHeight() {
		return height;
	}

	public CreateCommand setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public CreateCommand setWidth(int width) {
		this.width = width;
		return this;
	}
}