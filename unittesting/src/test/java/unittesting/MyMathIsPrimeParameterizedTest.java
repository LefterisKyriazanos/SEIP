package unittesting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import math.MyMath;

@RunWith(Parameterized.class)
public class MyMathIsPrimeParameterizedTest {

	@Parameter(value = 0)
	public int n;

	@Parameter(value = 1)
	public boolean flag;

	MyMath mm = new MyMath();


	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{{2, true}, {6, false}, {19, true},
				{22, false}, {23, true}});
	}

	@Test
	public void test_factorial() {

		Assert.assertEquals(flag, mm.isPrime(n));
	}

}