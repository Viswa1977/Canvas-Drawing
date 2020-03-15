package com.cs.drawing.factory;

import java.util.Arrays;

import com.cs.drawing.command.CanvasFillCommand;
import com.cs.drawing.command.Command;
import com.cs.drawing.command.CreateCommand;
import com.cs.drawing.command.DrawLineCommand;
import com.cs.drawing.command.DrawRectangleCommand;
import com.cs.drawing.command.QuitCommand;
import com.cs.drawing.exception.InvalidCommandException;
import com.cs.drawing.exception.InvalidCommandParamsException;
import static com.cs.drawing.commons.Constants.*;

public class CommandFactory {
	public Command getCommand(String commandLine) throws InvalidCommandException, InvalidCommandParamsException {
		commandLine = commandLine.trim().replaceAll(" {2}", " ");
		String[] split = commandLine.split(" ");
		String mainCommand = split[0].toUpperCase();
		String[] params = Arrays.copyOfRange(split, 1, split.length);
		switch (mainCommand) {
			case QUIT:
				return new QuitCommand();
			case CREATE:
				return new CreateCommand(params);
			case LINE:
				return new DrawLineCommand(params);
			case RECTANGLE:
				return new DrawRectangleCommand(params);
			case BUCKET_FILL:
				return new CanvasFillCommand(params);
			default:
				throw new InvalidCommandException();
			}
		}

}
