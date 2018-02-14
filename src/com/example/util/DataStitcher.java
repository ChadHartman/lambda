package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStitcher {

	private static <T> List<T> nInstances(int size, Class<T> itemClass) {
		try {
			List<T> items = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				items.add(itemClass.newInstance());
			}
			return items;
		} catch (ReflectiveOperationException e) {
			throw new IllegalArgumentException(itemClass.getName() + " cannot be created");
		}
	}

	public static <T> List<T> stitch(Map<String, String[]> properties, Class<T> itemClass, Setter<T> setter) {

		List<T> itemList = null;

		for (Map.Entry<String, String[]> entry : properties.entrySet()) {

			// Initialize outgoing collection, and validate size
			if (itemList == null) {
				itemList = nInstances(entry.getValue().length, itemClass);
			} else if (itemList.size() != entry.getValue().length) {
				throw new IllegalArgumentException(
						"property " + entry.getKey() + " has length " + entry.getValue().length + " when " + itemList.size() + "was expected");
			}

			// Populate outgoing item properties
			for (int i = 0; i < itemList.size(); i++) {
				setter.set(itemList.get(i), entry.getKey(), entry.getValue()[i]);
			}
		}

		return itemList;
	}

	@FunctionalInterface
	public interface Setter<T> {
		void set(T item, String property, String value);
	}

}
