package com.cs.drawing.model;

public class Quit implements CanvasAction{
	
	public void execute(Canvas canvas){
		if(canvas != null){
			canvas.addAction(this);
		}
	}
	
}
