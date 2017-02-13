package com.msrm.ocp8.chapter03.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class SortingMain {

	static class Rabbit implements Comparable<Rabbit> {
		public int compareTo(Rabbit r) {
			return 0;
		}
	}

	public static void main(String[] args) {
		// elb vpc ec2 cloudformation lambda elasticbeanstack
		List<Rabbit> list = new ArrayList<>();
		list.add(new Rabbit());

		Collections.sort(list);

		List<String> strings = Arrays.asList("Fluffy", "Hoppy");
		Comparator<String> c = Comparator.reverseOrder();
		int index = Collections.binarySearch(strings, "Hoppy", c);
		// System.out.println(index);

		List<Integer> ints = new ArrayList<>(); // Arrays.asList(2, 3, 6);
		ints.add(2);
		ints.add(3);
		ints.add(6);
		System.out.println(Collections.binarySearch(ints, 2));
		System.out.println(Collections.binarySearch(ints, 3));
		System.out.println(Collections.binarySearch(ints, 4, Comparator.reverseOrder()));
		System.out.println(Collections.binarySearch(ints, 5));
		System.out.println(ints);

		int i = Collections.binarySearch(ints, 4);
		System.out.println(i);
		ints.add(-i - 1, 4);
		System.out.println(ints);
		// System.out.println(Collections.binarySearch(ints, 5,
		// Comparator.reverseOrder()));

		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		Map<String, String> favourites = new HashMap<>();
		favourites.put("Sam", null);
		favourites.put("Tom", "Bus tour");

		favourites.merge("Sam", "Skyride", mapper);
		favourites.merge("Tom", "Skyride", mapper);
		System.out.println(favourites);
	}

}
