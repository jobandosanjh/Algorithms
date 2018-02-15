package com.adobe;

import java.util.Arrays;

public class Test {

	public static void main(final String[] args) {
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).stream().limit(5).peek(System.out::print).filter(x -> x % 2 == 1)
				.forEach(System.out::print);
	}
}
