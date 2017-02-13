package com.msrm.ocp8.chapter01.reviewquest;

public class Question09 {

	private int x = 5;

	public int getX() {
		String s = "x is ";
		
		class LocalInner {
			private int x = Question09.this.x;
			private void printX() {
				System.out.println(s + x);
			}
		}
		
		LocalInner in = new LocalInner();
		in.printX();
		
		return x;
	}

	public static void main(String[] args) {
		new Question09().getX();
	}

}
