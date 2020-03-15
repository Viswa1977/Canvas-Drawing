package com.cs.drawing.model;

import org.junit.Test;

public class CanvasFillTest {
	@Test
	public void create() throws Exception {
		new ColorFill(1, 2, 'o');
	}

	@Test(expected = IllegalArgumentException.class)
	public void create3() throws Exception {
		new ColorFill(-1, 2, 'o');
	}

	@Test(expected = IllegalArgumentException.class)
	public void create4() throws Exception {
		new ColorFill(1, -2, 'o');
	}

}
