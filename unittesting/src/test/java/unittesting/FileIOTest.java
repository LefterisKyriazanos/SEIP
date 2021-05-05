package unittesting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import io.FileIO;


public class FileIOTest {

	FileIO fi = new FileIO();
	@Test
	public void test_readFile() {

		int[] methodOutput = fi.readFile("./src/test/resources/grades.txt");
		int[] expected = {4, 9, 10, 7, 0, 7, 2, 8, 2, 0, 0, 5, 8, 3, 9, 5, 8, 5,
				6, 3, 4, 5, 1, 7, 5, 8, 2, 8, 7, 4, 2, 2, 9, 0, 2, 10, 3, 8, 1,
				2, 0, 1, 6, 1, 6, 5, 9, 9, 10, 7, 8, 1, 7, 7, 0, 9, 1, 6, 3, 2,
				5, 4, 9, 0, 0, 0, 9, 0, 1, 3, 10, 4, 4, 1, 6, 9, 9, 3, 8, 1, 1,
				5, 6, 6, 8, 10, 0, 0, 8, 5, 6, 7, 2, 6, 9, 5, 1, 3, 5, 3, 7, 1,
				10, 6, 8, 9, 6, 9, 8, 2, 2, 5, 8, 3, 5, 7, 1, 6, 3, 7, 0, 0,
				3, 0, 1, 2, 4, 10, 10, 3, 2, 4, 1, 8, 1, 7, 0, 9, 5, 6, 4, 3, 5,
				3, 3, 7, 9, 5, 1};

		// verify that the readFile output is equal to the expected
		assertArrayEquals(expected, methodOutput);
	}

}
