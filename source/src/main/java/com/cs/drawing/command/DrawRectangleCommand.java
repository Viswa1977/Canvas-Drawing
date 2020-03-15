package com.cs.drawing.command;import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;
import com.cs.drawing.exception.InvalidCommandParamsException;

public class DrawRectangleCommand implements Command {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public DrawRectangleCommand(String... params) { 
		if(params.length < 4) throw new InvalidCommandParamsException(ErrorMessages.RECT_INVALID_PARAM,ErrorMessages.RECTANGLE_VALIDATION); 
		try { 
			x1 = Utils.parseInt(params[0]);
			y1 = Utils.parseInt(params[1]);
			x2 = Utils.parseInt(params[2]);
			y2 = Utils.parseInt(params[3]);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandParamsException(ErrorMessages.RECT_NEGATIVE_PARAM,
					ErrorMessages.RECTANGLE_VALIDATION);
		}
	}

	public int getX1(){ return x1; }

	public DrawRectangleCommand setX1(int x1) { this.x1 = x1; return this; }

	public int getY1(){ return y1; }

	public DrawRectangleCommand setY1(int y1) { this.y1 = y1; return this; }

	public int getX2(){ return x2; }

	public DrawRectangleCommand setX2(int x2) { this.x2 = x2; return this; }

	public int getY2(){ return y2; }

	public DrawRectangleCommand setY2(int y2) { this.y2 = y2; return this; }
}