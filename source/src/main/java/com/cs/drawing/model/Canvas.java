package com.cs.drawing.model;

import com.cs.drawing.exception.InvalidEntityException;

public interface Canvas {
	void addAction(CanvasAction canvasAction) throws InvalidEntityException;
	String render();

}
