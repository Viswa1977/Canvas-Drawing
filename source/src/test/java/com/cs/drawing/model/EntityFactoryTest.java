package com.cs.drawing.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cs.drawing.command.CanvasFillCommand;
import com.cs.drawing.command.DrawLineCommand;
import com.cs.drawing.command.DrawRectangleCommand;
import com.cs.drawing.factory.ActionFactory;

public class EntityFactoryTest {
	private ActionFactory entityFactory;

	@Before
	public void setUp() throws Exception {
		entityFactory = new ActionFactory();
	}

	@Test
	public void getEntity_DrawLineCommand() throws Exception {
		DrawLineCommand drawLineCommand = new DrawLineCommand("1", "2", "1", "4");
		assertEquals(entityFactory.getEntity(drawLineCommand), new Line(1, 2, 1, 4));
	}

	@Test
	public void getEntity_DrawRectangleCommand() throws Exception {
		DrawRectangleCommand drawLineCommand = new DrawRectangleCommand("1", "2", "3", "4");
		assertEquals(entityFactory.getEntity(drawLineCommand), new Rectangle(1, 2, 3, 4));
	}

	@Test
	public void getEntity_CanvasFillCommand() throws Exception {
		CanvasFillCommand drawLineCommand = new CanvasFillCommand("2", "3", "o");
		assertEquals(entityFactory.getEntity(drawLineCommand), new ColorFill(2, 3, 'o'));
	}

	@Test
	public void getEntity_null() throws Exception {
		assertEquals(entityFactory.getEntity(null), null);
	}

}
