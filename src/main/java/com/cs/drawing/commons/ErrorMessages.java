package com.cs.drawing.commons;

public class ErrorMessages {
	public static String CREATE_CANVAS = "C w h   Should create a new canvas of width w and height h. w, h should be > 0";
	public static String COORDINATES_VALIDATION = "Coordinates should be > 0";
	public static final String RECTANGLE_VALIDATION = "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
			"    lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
			"    using the 'x' character.";
	public static final String CANVAS_FILL_VALIDATION = "B x y c Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
				"    behaviour of this is the same as that of the \"canvas fill\" tool in paint\n" +
				"    programs.";
	public static final String DRAW_LINE_VALIDATION = "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
				"    horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
				"    will be drawn using the 'x' character.";

	public static final String INVALID_COMMAND = "Invalid command found,Please enter a valid command.";
	public static final String CANVAS_FIRST_ERROR = "Please create a canvas first ";
	public static final String CANVAS_NOT_ABLE_TO_ADD = "Please create a canvas first AA ";

	//Canvas fill command
	public static final String PARAMS_LENGTH_VALIDATION_FOR_3 = "Canvas fill expects 3 params";
	public static final String COLOR_CHAR_VALIDATION = "Color character should only be 1 character";
	public static final String COORDINATES_XY_VALIDATION = "x or y should be > 0";
	public static final String INVALID_SYNTAX = "Command syntax is not correct : ";
	public static final String VALID_SYNTAX = "Refer to following correct syntax: \n";

	//Create Command
	public static final String CMD_VALIDATION_SYNTAX = "Create command expects 2 params";
	public static final String NUMBER_VALIDATION = "Number must be greater 0";

	//Draw line command
	public static final String LINE_PARAM_VALIDATION = "Draw line command expects 4 params";
	public static final String LINE_INVALID_PARAM = "Draw line does not support diagonal line at the moment";

	//Draw rectangle command
	public static final String RECT_INVALID_PARAM = "Draw Rectangle command expects 4 params";
	public static final String RECT_NEGATIVE_PARAM = "Number can not be negative";

	//Canvas IMPL
	public static final String CANVAS_FILL_POINT_OUTSIDE = "Canvas fill point is outside of canvas";
	public static final String RECT_FILL_POINT_OUTSIDE = "Rectangle is outside of canvas";
	public static final String LINE_FILL_POINT_OUTSIDE = "Line is outside of canvas";

	//Line constants
	public static final String DIAGONAL_LINE_FILL= "Draw line does not support diagonal line at the moment";
}
