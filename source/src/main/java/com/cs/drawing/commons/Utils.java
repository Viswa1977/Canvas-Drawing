package com.cs.drawing.commons;

public class Utils {
	public static int parseInt(String input) throws IllegalArgumentException {
		int i = Integer.parseInt(input);
		if (i <= 0)
			throw new IllegalArgumentException();
			return i;
		}

		public static void validateCoordinates(int... numbers) {
			for (int num : numbers) {
				if (num < 1) {
					throw new IllegalArgumentException(ErrorMessages.COORDINATES_VALIDATION);
				}
			}
		}

		public static void validatePosition(int... numbers) {
			for (int num : numbers) {
				if (num < 0) {
					throw new IllegalArgumentException(ErrorMessages.COORDINATES_VALIDATION);
				}
			}
		}
}
