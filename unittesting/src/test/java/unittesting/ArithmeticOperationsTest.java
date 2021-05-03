package unittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import math.ArithmeticOperations;

public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();

	@Test(expected = ArithmeticException.class)
	public void test_divide_zero_exception() {
		ao.divide(1, 0);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_multiply_negative_number_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(3, -2);
	}

	@Test
	public void test_multiply_integer_max_value_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 2);
	}

}
