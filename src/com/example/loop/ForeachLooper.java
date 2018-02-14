package com.example.loop;

import java.util.Arrays;
import java.util.Map;

public class ForeachLooper {
	public static void loop(Map<String, String[]> properties) {
		for (Map.Entry<String, String[]> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
		};
	}
}
