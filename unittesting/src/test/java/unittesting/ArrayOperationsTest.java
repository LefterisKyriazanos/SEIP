
package unittesting;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;
import math.ArrayOperations;
import math.MyMath;

public class ArrayOperationsTest {

	ArrayOperations ao = new ArrayOperations();

	@Test
	public void test_ArrayOperations_Mock() {
		MyMath mm = mock(MyMath.class);
		FileIO fio = mock(FileIO.class);
		String path = "./src/test/resources/mocking_file.txt";
		int [] array = {2, 6, 19, 22, 23};
		when(fio.readFile(path)).thenReturn(array);
		when(mm.isPrime(2)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		when(mm.isPrime(19)).thenReturn(true);
		when(mm.isPrime(22)).thenReturn(false);
		when(mm.isPrime(23)).thenReturn(true);

		Assert.assertArrayEquals(new int[]{2, 19, 23},
				ao.findPrimesInFile(fio, path, mm));
	}

}