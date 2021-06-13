package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

// This test class depends on the functionality of codeanalyzer.SourceFileReader class

public class SourceCodeAnalyzerTest {
	private static List<String> testSourceCode;
	private static String sourceCode;
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzer sca = new SourceCodeAnalyzer();
	private static SourceFileReader sfr = new SourceFileReader();

	// create List<String> testSourceCode and String sourceCode
	@BeforeClass
	public static void setUp() throws IOException {
		testSourceCode = sfr.readLocalFileIntoList(TEST_CLASS);
		sourceCode = sfr.readLocalFileIntoString(TEST_CLASS);
	}
	
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, sca.calculateRegexLOC(sourceCode));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, sca.calculateStringLOC(testSourceCode));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, sca.calculateRegexNOM(sourceCode));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, sca.calculateStringNOM(testSourceCode));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, sca.calculateRegexNOC(sourceCode));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, sca.calculateStringNOC(testSourceCode));
	}
	
}
