package com.cs.drawing.model;

import com.cs.drawing.commons.Utils;

public class ColorFill implements CanvasAction{
	
	private int x;
	private int y;
	private char color;

	public ColorFill(int _x1, int _y1, char color) {
		Utils.validateCoordinates(_x1, _y1);
		this.x = _x1;
		this.y = _y1;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public ColorFill setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public ColorFill setY(int y) {
		this.y = y;
		return this;
	}

	public char getColor() {
		return color;
	}

	public ColorFill setColor(char color) {
		this.color = color;
		return this;
	}

	@Override
	public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;

	ColorFill that = (ColorFill) o;

	if (x != that.x) return false;
	if (y != that.y) return false;
	return color == that.color;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + (int) color;
		return result;
	}

	@Override
	public void execute(Canvas canvas) {
		canvas.addAction(this);
	}

}
