package com.msrm.javapgm;

public class Base64 {

	private String charMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	public String encode(String s) {
		StringBuilder buf = new StringBuilder();

		// Base64 = ASCII -> radix-64 bit representation (binary to text
		// encoding)
		int len = s.length();

		for (int i = 0; i < len; i += 3) {

			int b0 = (s.charAt(i) & 0xFC) >> 2;
			buf.append(charMap.charAt(b0));

			if (i + 1 < len) {
				int b1 = ((s.charAt(i) & 0x03) << 4) | ((s.charAt(i + 1) & 0xF0) >> 4);
				buf.append(charMap.charAt(b1));
			}
			if (i + 2 < len) {
				int b2 = ((s.charAt(i + 1) & 0x0F) << 2) | ((s.charAt(i + 2) & 0xC0) >> 6);
				buf.append(charMap.charAt(b2));

				int b3 = s.charAt(i + 2) & 0x3F;
				buf.append(charMap.charAt(b3));
			}
		}

		// padding
		char lastChar = s.charAt(len - 1);
		int numberOfBits = len * 8;
		if (numberOfBits % 6 == 2) {
			buf.append(charMap.charAt((lastChar & 0x03) << 4));
		} else if (numberOfBits % 6 == 4) {
			buf.append(charMap.charAt((lastChar & 0x0F) << 2));
		}

		buf.append(len % 3 == 2 ? "=" : len % 3 == 1 ? "==" : "");

		return buf.toString();
	}

	public static void main(String[] args) {
		String string = "Man is distinguished, not only by his reason, but by this singular passion from\n"
				+ "other animals, which is a lust of the mind, that by a perseverance of delight\n"
				+ "in the continued and indefatigable generation of knowledge, exceeds the short\n"
				+ "vehemence of any carnal pleasure.";
		Base64 app = new Base64();

		String actual = app.encode(string);
		System.out.println(app.encode(string));

		String expected = java.util.Base64.getEncoder().encodeToString(string.getBytes());

		System.out.println(java.util.Base64.getEncoder().encodeToString(string.getBytes()));

		if (actual.equals(expected)) {
			System.out.println("Base64 corrent");
		} else {
			System.out.println("Base64 is not correct");
		}

	}

}
