package com.msrm.ocp8.chapter03.collection;

import java.util.HashMap;
import java.util.Map;

public class Java8Map {

	public static void main(String[] args) {
		Map<String, String> myMap = new HashMap<>();
		myMap.put(null, "nodata");
		myMap.put("test", null);
		print(myMap);

	}

	public static void doTest() {
		Map<String, String> favs = new HashMap<>();
		favs.put("Sam", null);
		favs.put("Tom", "Bus tour");
		favs.put("John", "Bike");

		print(favs);

		// Adds record in Map
		// Note: Mapper function didn't execute
		favs.merge("Jenny", "Rider", (v1, v2) -> {
			System.out.println("v1=" + v1 + "; v2=" + v2);
			return v2;
		});
		print(favs);

		// Updates exiting record in Map
		favs.merge("Jenny", "Paragliding", (v1, v2) -> {
			System.out.println("v1=" + v1 + "; v2=" + v2);
			return v2;
		});
		print(favs);

		// Removes Jenny from map
		favs.merge("Jenny", "Skyrider", (v1, v2) -> {
			return null;
		});
		print(favs);

		favs.put("Jenny", "Skyrider");
		// Performs operation on existing record
		favs.computeIfPresent("Jenny", (k, v) -> k.toUpperCase() + " " + v.toUpperCase());
		print(favs);

		// Performs operation on non-existing record
		favs.computeIfPresent("Leiws", (k, v) -> {
			System.out.println("Mapper for Jhony");
			return "Cycling";
		});
		print(favs);

		// Performs operation on existing record
		favs.computeIfAbsent("Jenny", (k) -> {
			System.out.println("K: " + k);
			return "Newkey";
		});
		print(favs);

		// Performs operation on existing record
		favs.computeIfAbsent("Leiws", (k) -> {
			System.out.println("K: " + k);
			return "Newway";
		});
		print(favs);
	}

	private static void print(Map<String, String> favs) {
		System.out.println();
		System.out.println(favs);
	}

}
