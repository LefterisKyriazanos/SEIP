package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
 * The ArrayOperations provides array operations, using readFile and isPrime
 * methods to read a file of integers and return an array of it's prime numbers
 *
 * @author LefterisKyriazanos
 */

public class ArrayOperations {

	// input -> FileIO object, MyMath Object, a filepath
	// output -> integers array of primes located in the file.
	public int[] findPrimesInFile(FileIO fileIo, String filepath,
			MyMath myMath) {

		List<Integer> primesList = new ArrayList<>();
		int[] int_array = fileIo.readFile(filepath);
		for (int i = 0; i < int_array.length; i++) {

			if (myMath.isPrime(int_array[i])
					&& !primesList.contains(int_array[i])) {
				primesList.add(int_array[i]);
			}
		}
		
		return primesList.stream().mapToInt(i -> i).toArray();

	}

}
