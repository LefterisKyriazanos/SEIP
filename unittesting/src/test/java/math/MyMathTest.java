package unittesting;

import org.junit.Test;

import math.MyMath;

public class MyMathTest {

	MyMath mm = new MyMath();

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_negative_n() {
		mm.factorial(-3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_n_bigger_than_12() {
		mm.factorial(14);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_isPrime_n_smaller_than_2() {
		mm.isPrime(-2);
	}

}
