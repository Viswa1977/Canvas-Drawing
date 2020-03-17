package com.cs.drawing.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cs.drawing.commons.ErrorMessages;
import com.cs.drawing.exception.InvalidEntityException;

public class CanvasImpl implements Canvas {

	private static final char HORIZONTAL_EDGE_CHAR = '-';
	private static final char VERTICAL_EDGE_CHAR = '|';
	private static final char LINE_CHAR = 'x';
	public static final char EMPTY_CHAR = ' ';

	private final char[][] canvasArray;
	private final int width;
	private final int height;
	private final String horizontalEdge;

	public CanvasImpl(int w, int h) {
		width = w;
		height = h;

		canvasArray = new char[this.height][this.width];
		Arrays.stream(canvasArray).forEach(chars -> Arrays.fill(chars, EMPTY_CHAR));

		horizontalEdge = Stream.generate(() -> String.valueOf(HORIZONTAL_EDGE_CHAR)).limit(width + 2)
				.collect(Collectors.joining());
	}

	@Override
	public void addAction(CanvasAction canvasAction) throws InvalidEntityException {
		if (canvasAction instanceof Line) {
			addLine((Line) canvasAction);
		} else if (canvasAction instanceof Rectangle) {
			addRectangle((Rectangle) canvasAction);
		} else if (canvasAction instanceof ColorFill) {
			addColor((ColorFill) canvasAction);
		} else if (canvasAction instanceof Quit) {
			quit();
		}
	}

	@Override
	public String render() {
		StringBuilder builder = new StringBuilder();
		builder.append(horizontalEdge).append("\n");
		for (int i = 0; i < this.height; i++) {
			builder.append(VERTICAL_EDGE_CHAR);
			for (int j = 0; j < this.width; j++) {
				builder.append(canvasArray[i][j]);
			}
			builder.append(VERTICAL_EDGE_CHAR);
			builder.append("\n");
		}
		builder.append(horizontalEdge);
		return builder.toString();
	}

	private void addColor(ColorFill canvasFill) {
		if (isOutside(canvasFill.getX(), canvasFill.getY())) {
			throw new InvalidEntityException(ErrorMessages.CANVAS_FILL_POINT_OUTSIDE);
		}

		fillColor(canvasFill.getX() - 1, canvasFill.getY() - 1, canvasFill.getColor());
	}

	private void addRectangle(Rectangle rec) {
		if (isOutside(rec.getPoint1().getX(), rec.getPoint1().getY())) {
			throw new InvalidEntityException(ErrorMessages.RECT_FILL_POINT_OUTSIDE);
		}
		drawRectangle(rec.getPoint1().getX(), rec.getPoint1().getY(), rec.getPoint2().getX(), rec.getPoint2().getY());
	}

	private void addLine(Line line) {
		if (isOutside(line.getPoint1().getX(), line.getPoint1().getY())) {
			throw new InvalidEntityException(ErrorMessages.LINE_FILL_POINT_OUTSIDE);
		}

		// trim the part the is outside
		if (line.getPoint2().getX() >= width) {
			line.getPoint2().setX(width);
		}
		if (line.getPoint2().getY() >= height) {
			line.getPoint2().setY(height);
		}
		drawLine(line.getPoint1().getX(), line.getPoint1().getY(), line.getPoint2().getX(), line.getPoint2().getY());
	}

	private void drawLine(int x1, int y1, int x2, int y2) {
		// row by row
		for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
			// col by col
			for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
				canvasArray[row][col] = CanvasImpl.LINE_CHAR;
			}
		}
	}

	private void fillColor(int x, int y, char color) {
		if (x < 0 || x > this.width - 1 || y < 0 || y > this.height - 1 || this.canvasArray[y][x] != EMPTY_CHAR) {
			return;
		}
		if ((int) this.canvasArray[y][x] == EMPTY_CHAR) {
			this.canvasArray[y][x] = color;
			fillColor(x + 1, y, color);
			fillColor(x - 1, y, color);
			fillColor(x, y - 1, color);
			fillColor(x, y + 1, color);
		}
	}

	private void drawRectangle(int x1, int y1, int x2, int y2) {
		// top edge
		drawLine(x1, y1, x2, y1);
		// right edge
		drawLine(x1, y1, x1, y2);
		// bottom edge
		drawLine(x2, y1, x2, y2);
		// right edge
		drawLine(x1, y2, x2, y2);
	}

	private boolean isOutside(int x, int y) {
		return x < 0 || x >= width || y < 0 || y >= height;
	}

	private void quit() {
		Arrays.stream(canvasArray).forEach(chars -> Arrays.fill(chars, EMPTY_CHAR));
	}

}
