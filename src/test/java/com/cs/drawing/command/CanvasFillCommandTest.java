package com.cs.drawing.command;

import org.junit.Test;

import com.cs.drawing.exception.InvalidCommandParamsException;

public class CanvasFillCommandTest {

	@Test
	public void testCreate() throws Exception {
		new CanvasFillCommand("1", "1", "o");
	}

	@Test(expected = InvalidCommandParamsException.class)
	public void testCreate1() throws Exception {
		new CanvasFillCommand("-1", "1", "o");
	}

	@Test(expected = InvalidCommandParamsException.class)
	public void testCreate2() throws Exception {
		new CanvasFillCommand("1", "-1", "o");
	}

	@Test(expected = InvalidCommandParamsException.class)
	public void testCreate3() throws Exception {
		new CanvasFillCommand("1", "1");
	}

	@Test(expected = InvalidCommandParamsException.class)
	public void testCreate4() throws Exception {
		new CanvasFillCommand("1");
	}

	@Test(expected = InvalidCommandParamsException.class)
	public void testCreate6() throws Exception {
		new CanvasFillCommand();
	}

}
