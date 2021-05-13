package math;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyMathTest {

	MyMath mm = new MyMath();

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_negative_n() {
		try {
			mm.factorial(-3);
		//Run exception throwing operation here
		} catch(IllegalArgumentException ex) {
			String expected_message = "n should be between 0 and 12";
			assertEquals(expected_message, ex.getMessage());
			throw ex;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_factorial_n_bigger_than_12() {
		try {
			mm.factorial(14);
		//Run exception throwing operation here
		} catch(IllegalArgumentException ex) {
			String expected_message = "n should be between 0 and 12";
			assertEquals(expected_message, ex.getMessage());
			throw ex;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_isPrime_n_smaller_than_2() {
		mm.isPrime(-2);
	}

}
