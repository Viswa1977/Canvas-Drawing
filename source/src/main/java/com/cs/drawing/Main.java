package com.cs.drawing;

import java.util.Scanner;

import com.cs.drawing.command.Command;
import com.cs.drawing.command.CreateCommand;
import com.cs.drawing.command.QuitCommand;
import com.cs.drawing.commons.Constants;
import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.exception.InvalidCommandException;
import com.cs.drawing.exception.InvalidCommandParamsException;
import com.cs.drawing.exception.InvalidEntityException;
import com.cs.drawing.factory.ActionFactory;
import com.cs.drawing.factory.CommandFactory;
import com.cs.drawing.model.Canvas;
import com.cs.drawing.model.CanvasAction;
import com.cs.drawing.model.CanvasImpl;

public class Main {
	private static Canvas canvas;
	private static Scanner scanner;
	private static CommandFactory commandFactory;
	private static ActionFactory entityFactory;

	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		scanner = new Scanner(System.in);
		commandFactory = new CommandFactory();
		entityFactory = new ActionFactory();
		System.out.println(Constants.INPUT_COMMAND);
		while (true) {
			process(scanner.nextLine());
			System.out.println(Constants.INPUT_COMMAND);
		}
	}

	private static void process(String commandLine) {
		Command command = null;
		try {
			command = commandFactory.getCommand(commandLine);
			if (command instanceof QuitCommand) {
				quit(command);
			}
			if (command instanceof CreateCommand) {
				createNewCanvas((CreateCommand) command);
				return;
			}
			draw(command);
		} catch (InvalidCommandException e) {
			System.out.println(ErrorMessages.INVALID_COMMAND);
		} catch (InvalidCommandParamsException invalidCommandParams) {
			System.out.println(ErrorMessages.INVALID_SYNTAX + invalidCommandParams.getMessage());
			System.out.println(ErrorMessages.VALID_SYNTAX + invalidCommandParams.getHelpMessage());
		}
	}

	private static void draw(Command command) {
		if (canvas == null) {
			System.out.println(ErrorMessages.CANVAS_FIRST_ERROR);
			return;
		}
		try {
			CanvasAction canvasAction = entityFactory.getEntity(command);
			canvasAction.execute(canvas);
			System.out.println(canvas.render());
		} catch (InvalidEntityException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createNewCanvas(CreateCommand command) {
		canvas = new CanvasImpl(command.getWidth(), command.getHeight());
		System.out.println(canvas.render());
	}

	private static void quit(Command command) {
		CanvasAction canvasAction = entityFactory.getEntity(command);
		canvasAction.execute(canvas);
		scanner.close();
		System.out.println(Constants.EXITING);
		System.exit(0);
	}

}
