package com.example.loop;

import java.util.Arrays;
import java.util.Map;

public class LambdaLooper {
	public static void loop(Map<String, String[]> properties) {
		properties.forEach((property, values) -> {
			System.out.println(property + ":" + Arrays.toString(values));
		});
	}
}
