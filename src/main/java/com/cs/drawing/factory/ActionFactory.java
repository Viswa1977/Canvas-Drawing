package com.cs.drawing.factory;

import com.cs.drawing.command.CanvasFillCommand;
import com.cs.drawing.command.Command;
import com.cs.drawing.command.DrawLineCommand;
import com.cs.drawing.command.DrawRectangleCommand;
import com.cs.drawing.command.QuitCommand;
import com.cs.drawing.model.CanvasAction;
import com.cs.drawing.model.ColorFill;
import com.cs.drawing.model.Line;
import com.cs.drawing.model.Quit;
import com.cs.drawing.model.Rectangle;

public class ActionFactory {
	public CanvasAction getEntity(Command command) {
		if (command instanceof DrawLineCommand) {
			DrawLineCommand cmd = (DrawLineCommand) command;
			return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof DrawRectangleCommand) {
			DrawRectangleCommand cmd = (DrawRectangleCommand) command;
			return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof CanvasFillCommand) {
			CanvasFillCommand cmd = (CanvasFillCommand) command;
			return new ColorFill(cmd.getX(), cmd.getY(), cmd.getCharacter());
		} else if (command instanceof QuitCommand) {
			return new Quit();
		}
		return null;
	}

}
