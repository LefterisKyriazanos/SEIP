package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import codeanalyzer.SourceFileReader;

public class SourceFileReaderTest {
	SourceFileReader sfr = null;
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testReadLocalFileIntoList() throws IOException {
		//read a locally stored file into a List
		sfr = new SourceFileReader();
		List<String> actualList = sfr.readLocalFileIntoList(TEST_CLASS_LOCAL);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadLocalFileIntoString() throws IOException {
		//read a locally stored file into a String
		sfr = new SourceFileReader();
		String actuals = sfr.readLocalFileIntoString(TEST_CLASS_LOCAL);
				
		assertEquals(expectedString, actuals);
	}
	
	@Test
	public void testReadWebFileIntoList() throws IOException {
		//read a file stored in the web into a List
		sfr = new SourceFileReader();
		List<String> actualList = sfr.readWebFileIntoList(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testreadWebFileIntoString() throws IOException {
		//read a file stored in the web into a String
		sfr = new SourceFileReader();
		String actuals = sfr.readWebFileIntoString(TEST_CLASS_WEB);
				
		assertEquals(expectedString, actuals);
	}
	
	/*
	@Test(expected = IOException.class)
	public void testReadWebFileIntoListException() throws IOException {
		try {
			//give a none existing type to cause a null List return
			sfr = new SourceFileReader();
			sfr.readFileIntoList("any-filepath");
		} catch (IOException ex) {
			
			assertThat(ex.getMessage(), containsString("java.io.FileNotFoundException"));
		}
	}
	
	@Test
	public void testReadFileIntoStringNull() throws IOException {
		give a none existing type to cause a null String return
		sfr = new SourceFileReader();
		String actualString = sfr.readFileIntoString("any-filepath", TYPE_LOCAL);
		
		assertNull(actualString);
	}
	*/
}
