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

	/**
	 * Checks if number n is prime.
	 *
	 * @param n
	 *              the potential prime integer .
	 * @return flag (boolean) depending on if n is prime or not.
	 * @exception IllegalArgumentException
	 *                                         when n < 2.
	 *
	 */

	public boolean isPrime(int n) {

		if (n < 2)
			throw new IllegalArgumentException(
					"n should not be smaller than 2");
		boolean flag = true;

		for (int i = 2; i <= n / 2; ++i) {
			// condition for nonprime number
			if (n % i == 0) {
				flag = false;
				break;
			}
		}

		return flag;
	}

}
