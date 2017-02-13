package com.msrm.ocp8.chapter03.collection;

import java.util.Arrays;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		String[] array = { "gerbil", "mouse" };
		List<String> list = Arrays.asList(array);
		System.out.println(list);
		array[0] = "new";
		System.out.println(list);
	}

}
