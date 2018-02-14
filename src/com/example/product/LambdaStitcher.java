package com.example.product;

import java.util.List;
import java.util.Map;

import com.example.Main;
import com.example.Product;
import com.example.util.DataStitcher;

public class LambdaStitcher {
	public static List<Product> stitch(Map<String, String[]> properties) {
		return DataStitcher.stitch(properties, Product.class, (Product product, String property, String value) -> {
			switch (property) {
				case Main.KEY_ID:
					product.setId(value);
					break;
				case Main.KEY_CATEGORY:
					product.setCategory(value);
					break;
				case Main.KEY_QUANTITY:
					product.setQuantity(Integer.valueOf(value));
					break;
				case Main.KEY_PRICE:
					product.setPrice(Double.valueOf(value));
					break;
			}
		});
	}
}
