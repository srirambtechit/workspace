package com.msrm.ocp8.chapter01.reviewquest;

public class Question12 {

	static class Browser {
		public void go() {
			System.out.println("Inside browser");
		}
	}

	static class Firefox extends Browser {
		public void go() {
			System.out.println("Firefox browser");
		}
	}

	static class IE extends Browser {
		@Override
		public void go() {
			System.out.println("IE browser");
		}
	}

	public static void main(String[] args) {
		Browser b = new Firefox();
		b.go();

		IE e = (IE) b;
		e.go();
	}

}
