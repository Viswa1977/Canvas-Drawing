package com.cs.drawing.model;


import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;

public class Line implements CanvasAction{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Point point1;
	private Point point2;

	public Line(int _x1, int _y1, int _x2, int _y2) {
	if (_x1 != _x2 && _y1 != _y2) {
	throw new IllegalArgumentException(ErrorMessages.DIAGONAL_LINE_FILL);
	}
	Utils.validateCoordinates(_x1, _y1, _x2, _y2);

	if ((_x1 == _x2 && _y1 > _y2) || (_y1 == _y2 && _x1 > _x2)) {
	throw new IllegalArgumentException("Invalid coordinates passed");
	} else {
	this.x1 = _x1;
	this.y1 = _y1;
	this.x2 = _x2;
	this.y2 = _y2;
	this.point1 = new Point(_x1, _y1);
	this.point2 = new Point(_x2, _y2);
	}
	}

	public int getX1() {
	return x1;
	}

	public Line setX1(int x1) {
	this.x1 = x1;
	return this;
	}

	public int getY1() {
	return y1;
	}

	public Line setY1(int y1) {
	this.y1 = y1;
	return this;
	}

	public int getX2() {
	return x2;
	}

	public void setX2(int x2) {
	this.x2 = x2;
	}

	public int getY2() {
	return y2;
	}

	public void setY2(int y2) {
	this.y2 = y2;
	}

	public Point getPoint1() {
	return point1;
	}

	public void setPoint1(Point point1) {
	this.point1 = point1;
	}

	public Point getPoint2() {
	return point2;
	}

	public void setPoint2(Point point2) {
	this.point2 = point2;
	}

	@Override
	public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;

	Line line = (Line) o;

	if (x1 != line.x1) return false;
	if (y1 != line.y1) return false;
	if (x2 != line.x2) return false;
	return y2 == line.y2;
	}

	@Override
	public int hashCode() {
	int result = x1;
	result = 31 * result + y1;
	result = 31 * result + x2;
	result = 31 * result + y2;
	return result;
	}

	@Override
	public void execute(Canvas canvas) {
	canvas.addAction(this);
	}
	

}
