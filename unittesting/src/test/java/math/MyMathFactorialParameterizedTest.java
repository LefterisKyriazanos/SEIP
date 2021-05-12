package math;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {

	@Parameter(value = 0)
	public int n;

	@Parameter(value = 1)
	public int factorial;

	MyMath mm = new MyMath();


	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(
				new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}});
	}

	@Test
	public void test_factorial() {

		Assert.assertEquals(factorial, mm.factorial(n));
	}
	
}
