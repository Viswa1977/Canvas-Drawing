package com.cs.drawing.model;

import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.commons.Utils;
import com.cs.drawing.service.Canvas;

public class Line implements CanvasAction {
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
			this.point1 = new Point(_x1, _y1);
			this.point2 = new Point(_x2, _y2);
		}
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
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Line line = (Line) o;

		if (this.point1.getX() != line.getPoint1().getX())
			return false;
		if (this.getPoint1().getY() != line.getPoint1().getY())
			return false;
		if (this.getPoint2().getX() != line.getPoint2().getX())
			return false;
		return this.getPoint2().getY() == line.getPoint2().getY();
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
