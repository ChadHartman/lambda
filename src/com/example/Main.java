package com.example;

import java.util.HashMap;
import java.util.Map;

import com.example.loop.ForeachLooper;
import com.example.loop.LambdaLooper;
import com.example.product.AnonStitcher;
import com.example.product.LambdaStitcher;

public class Main {

	public static final String KEY_ID = "ID";
	public static final String KEY_CATEGORY = "CATEGORY";
	public static final String KEY_QUANTITY = "QUANTITY";
	public static final String KEY_PRICE = "PRICE";

	public static void main(String[] args) {

		Map<String, String[]> properties = new HashMap<>();
		properties.put(KEY_ID, new String[] { "1", "2", "3", "4" });
		properties.put(KEY_CATEGORY, new String[] { "clothes", "accessories", "accessories", "clothes" });
		properties.put(KEY_QUANTITY, new String[] { "2", "1", "1", "4" });
		properties.put(KEY_PRICE, new String[] { "9.99", "49.99", "39.99", "19.99" });

		runLambdaVsFunction(properties);
		runLambdaVsAnon(properties);
	}

	private static void runLambdaVsFunction(Map<String, String[]> properties) {
		LambdaLooper.loop(properties);
		ForeachLooper.loop(properties);
	}

	private static void runLambdaVsAnon(Map<String, String[]> properties) {
		System.out.println("LAMBDA:");
		LambdaStitcher.stitch(properties).forEach(System.out::println);

		System.out.println("ANON:");
		AnonStitcher.stitch(properties).forEach(System.out::println);
	}

}
