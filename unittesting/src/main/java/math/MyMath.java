package math;

/**
 * @author LefterisKyriazanos
 * @version 1.0
 */
public class MyMath {

	/**
	 * Finds the factorial of an integer number (n).
	 *
	 * @param n
	 *              the integer which factorial we want to calculate.
	 * @return factorial the factorial of number n.
	 * @exception IllegalArgumentException
	 *                                         when n < 0 or n > 12.
	 *
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12)
			throw new IllegalArgumentException("n should be between 0 and 12");
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

}
