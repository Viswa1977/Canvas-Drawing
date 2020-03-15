package com.cs.drawing.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.drawing.exception.InvalidEntityException;

public class CanvasTest {

	private Canvas canvas;

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		canvas = new CanvasImpl(20, 4);
	}
	
	// empty canvas
	@Test
	public void create() throws Exception {
		Assert.assertEquals(canvas.render(),
				"----------------------\n" + 
				"|                     |\n" + 
				"|                     |\n" + 
				"|                     |\n" + 
				"|                     |\n" + 
				"----------------------");
	}

	// add vertical line
	@Test
	public void addEntity() throws Exception {
		Line line = new Line(1, 2, 1, 3);
		canvas.addAction(line);
		Assert.assertEquals(canvas.render(),
				"----------------------\n"  + 
				"|  				    |\n" + 
				"|x  				    |\n" + 
				"|x  				    |\n" + 
				"|  				    |\n" + 
				"----------------------");
	}

	// add vertical line that is trimmed
	@Test
	public void addEntity2() throws Exception {
		Line line = new Line(1, 2, 1, 22);
		canvas.addAction(line);

		Assert.assertEquals(canvas.render(),
				"----------------------\n" + 
				"|  				  |\n" + 
				"|x  				  |\n" + 
				"|x  				  |\n" + 
				"|x  				  |\n" + 
				"----------------------");
	}

	// add horizontal line
	@Test
	public void addEntity3() throws Exception {
		Line line = new Line(2, 2, 4, 2);
		canvas.addAction(line);

		Assert.assertEquals(canvas.render(),
				"----------------------\n" + "|  |\n" + "| xxx  |\n" + "|  |\n" + "|  |\n" + "----------------------");
	}

	// add horizontal line that is trimmed
	@Test
	public void addEntity4() throws Exception {
		Line line = new Line(1, 2, 30, 2);
		canvas.addAction(line);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "|  |\n" + "|xxxxxxxxxxxxxxxxxxxx|\n"
				+ "|  |\n" + "|  |\n" + "----------------------");
	}

	// line outside of canvas
	@Test()
	public void addEntity6() throws Exception {
		Line line1 = new Line(100, 20, 100, 22);
		expectedException.expect(InvalidEntityException.class);
		canvas.addAction(line1);
	}

	// add rectangle
	@Test()
	public void addEntity7() throws Exception {
		Rectangle rectangle = new Rectangle(100, 20, 200, 22);
		expectedException.expect(InvalidEntityException.class);
		canvas.addAction(rectangle);
	}

	// add rectangle
	@Test()
	public void addEntity8() throws Exception {
		Rectangle rectangle = new Rectangle(14, 1, 18, 3);
		canvas.addAction(rectangle);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxx |\n" + "| x  x |\n" + "| xxxxx |\n"
				+ "|  |\n" + "----------------------");
	}

	// add rectangle that exceed the canvas height
	@Test()
	public void addEntity9() throws Exception {
		Rectangle rectangle = new Rectangle(2, 1, 4, 30);
		canvas.addAction(rectangle);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxx  |\n" + "| x x  |\n" + "| x x  |\n"
				+ "| x x  |\n" + "----------------------");
	}

	// add rectangle that exceed the canvas width
	@Test()
	public void addEntity10() throws Exception {
		Rectangle rectangle = new Rectangle(2, 1, 40, 3);
		canvas.addAction(rectangle);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxxxxxxxxxxxxxxxx|\n" + "| x |\n"
				+ "| xxxxxxxxxxxxxxxxxxx|\n" + "|  |\n" + "----------------------");
	}

	// add rectangle that exceed both the canvas width and height
	@Test()
	public void addEntity11() throws Exception {
		Rectangle rectangle = new Rectangle(2, 1, 40, 30);
		canvas.addAction(rectangle);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxxxxxxxxxxxxxxxx|\n" + "| x |\n"
				+ "| x |\n" + "| x |\n" + "----------------------");
	}

	// add rectangle that is outside
	@Test()
	public void addEntity111() throws Exception {
		Rectangle rectangle = new Rectangle(20, 100, 40, 102);
		expectedException.expect(InvalidEntityException.class);
		canvas.addAction(rectangle);
	}

	// canvas fill
	@Test()
	public void addEntity12() throws Exception {
		ColorFill rectangle = new ColorFill(2, 1, 'o');
		canvas.addAction(rectangle);

		Assert.assertEquals(canvas.render(),
				"----------------------\n" + "|oooooooooooooooooooo|\n" + "|oooooooooooooooooooo|\n"
						+ "|oooooooooooooooooooo|\n" + "|oooooooooooooooooooo|\n" + "----------------------");
	}

	// fill a vertical line
	@Test
	public void addEntity13() throws Exception {
		Line line = new Line(1, 2, 1, 3);
		canvas.addAction(line);
		ColorFill canvasFill = new ColorFill(1, 2, 'o');
		canvas.addAction(canvasFill);

		Assert.assertEquals(canvas.render(),
				"----------------------\n" + "|  |\n" + "|x  |\n" + "|x  |\n" + "|  |\n" + "----------------------");

	}

	// fill a rectangle edge
	@Test
	public void addEntity14() throws Exception {
		Rectangle rectangle = new Rectangle(14, 1, 18, 3);
		canvas.addAction(rectangle);
		ColorFill canvasFill = new ColorFill(14, 1, 'o');
		canvas.addAction(canvasFill);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxx |\n" + "| x  x |\n" + "| xxxxx |\n"
				+ "|  |\n" + "----------------------");

	}

	// fill a rectangle content
	@Test
	public void addEntity15() throws Exception {
		Rectangle rectangle = new Rectangle(14, 1, 18, 4);
		canvas.addAction(rectangle);
		ColorFill canvasFill = new ColorFill(15, 2, 'o');
		canvas.addAction(canvasFill);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxx |\n" + "| xooox |\n" + "| xooox |\n"
				+ "| xxxxx |\n" + "----------------------");

	}

	// fill blank space
	@Test
	public void addEntity16() throws Exception {
		Rectangle rectangle = new Rectangle(14, 1, 18, 4);
		canvas.addAction(rectangle);
		ColorFill canvasFill = new ColorFill(10, 1, 'o');
		canvas.addAction(canvasFill);

		Assert.assertEquals(canvas.render(),
				"----------------------\n" + "|oooooooooooooxxxxx |\n" + "|ooooooooooooox  x |\n"
						+ "|ooooooooooooox  x |\n" + "|oooooooooooooxxxxx |\n" + "----------------------");
	}

	// Add multiple model to canvas
	@Test
	public void addEntity5() throws Exception {
		Line line1 = new Line(1, 2, 6, 2);
		canvas.addAction(line1);

		Line line2 = new Line(6, 3, 6, 4);
		canvas.addAction(line2);

		Assert.assertEquals(canvas.render(), "----------------------\n" + "|  |\n" + "|xxxxxx |\n" + "| x |\n"
				+ "| x |\n" + "----------------------");

		canvas.addAction(new Rectangle(14, 1, 18, 3));
		Assert.assertEquals(canvas.render(), "----------------------\n" + "| xxxxx |\n" + "|xxxxxx  x  x |\n"
				+ "| x  xxxxx |\n" + "| x |\n" + "----------------------");

		canvas.addAction(new ColorFill(10, 3, 'o'));
		Assert.assertEquals(canvas.render(),
				"----------------------\n" + "|oooooooooooooxxxxxoo|\n" + "|xxxxxxooooooox  xoo|\n"
						+ "| xoooooooxxxxxoo|\n" + "| xoooooooooooooo|\n" + "----------------------");
	}

}
