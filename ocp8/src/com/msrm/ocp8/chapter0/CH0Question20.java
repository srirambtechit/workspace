package com.msrm.ocp8.chapter0;

import java.time.LocalDate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * <pre>
 * Assume that today is June 1, 2016. What is the result of the following?
Stream<LocalDate> s = Stream.of(LocalDate.now()); UnaryOperator<LocalDate> u = l -> l;
s.filter(l -> l != null).map(u).peek(System.out::println);
A. 2016–05–01
B. B. 2016–06–01
C. There is no output.
D. The output is something other than 2016–05–01 or 2016–06–01.
E. The code does not compile.
F. An exception is thrown.
 * </pre>
 * 
 * Answer: C, because peek() is an intermediate operation, output would have
 * displayed in case of expression ends with terminal operation (lazy behavior)
 * 
 * @author srirammuthaiah
 *
 */
public class CH0Question20 {

	public static void main(String[] args) {
		Stream<LocalDate> s = Stream.of(LocalDate.now());
		UnaryOperator<LocalDate> u = l -> l;
		s.filter(l -> l != null).map(u).peek(System.out::println);
	}

}
