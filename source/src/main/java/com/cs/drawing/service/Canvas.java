package com.cs.drawing.service;

import com.cs.drawing.exception.InvalidEntityException;
import com.cs.drawing.model.CanvasAction;

public interface Canvas {
	void addAction(CanvasAction canvasAction) throws InvalidEntityException;
	String render();

}
