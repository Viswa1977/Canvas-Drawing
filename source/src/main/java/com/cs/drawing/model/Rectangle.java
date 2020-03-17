package com.cs.drawing.model;

import com.cs.drawing.commons.Utils;
import com.cs.drawing.exception.InvalidCommandException;

public class Rectangle implements CanvasAction {
	Point point1;
	Point point2;

	public Rectangle(int _x1, int _y1, int _x2, int _y2) {
		Utils.validateCoordinates(_x1, _y1, _x2, _y2);
		if ((_x1 == _x2) || (_y1 == _y2) || (_y1 > _y2) || (_x1 > _x2)) {
			throw new InvalidCommandException();
		} else {
			this.point1 = new Point(_x1, _y1);
			this.point2 = new Point(_x2, _y2);
		}
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Rectangle rectangle = (Rectangle) o;

		if (this.point1.getX() != rectangle.getPoint1().getX())
			return false;
		if (this.point1.getY() != rectangle.getPoint1().getY())
			return false;
		if (this.point2.getX() != rectangle.getPoint2().getX())
			return false;
		return this.point2.getY() == rectangle.getPoint2().getY();
	}

	@Override
	public int hashCode() {
		int result = this.point1.getX();
		result = 31 * result + this.point1.getY();
		result = 31 * result + this.point2.getX();
		result = 31 * result + this.point2.getY();
		return result;
	}

	@Override
	public void execute(Canvas canvas) {
		canvas.addAction(this);
	}

}
