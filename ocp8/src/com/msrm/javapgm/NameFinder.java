package com.msrm.javapgm;

/**
 * Find out a name based on the maximum occurrence of it. when number of
 * occurrence same for multiple names, sort name alphabetically and print first
 * name based on descending order
 * 
 * <pre>
 * Ex: 
 * INPUT:-
 * sriram, sriram, kasi, soma, selva, surya, praveen, surya, praveen, sriram
 * praveen, soma, soma, martin
 * 
 * 
 * Explanation:-
 * sriram - 3
 * kasi - 1
 * soma - 3
 * selva - 1
 * surya - 2
 * praveen - 3
 * martin - 1
 * 
 * OUTPUT:-
 * sriram
 * 
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class NameFinder {

	private class Names implements Comparable<Names> {
		private String name;
		private int occurrence;

		@Override
		public int compareTo(Names o) {
			if(name.equals(o.name)) {
				
			}
			return name.compareTo(o.name);
		}
	}

	public static void main(String[] args) {
		String[] names = { "sriram", "sriram", "kasi", "soma", "selva", "surya", "praveen", "surya", "praveen",
				"sriram", "praveen", "soma", "soma", "martin" };

	}

}
