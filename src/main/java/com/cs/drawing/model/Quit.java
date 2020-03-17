package com.cs.drawing.model;

import com.cs.drawing.service.Canvas;

public class Quit implements CanvasAction{
	
	public void execute(Canvas canvas){
		if(canvas != null){
			canvas.addAction(this);
		}
	}
	
}
