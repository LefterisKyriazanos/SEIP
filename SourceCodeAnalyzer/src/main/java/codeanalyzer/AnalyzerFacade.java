package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class serves as a front-facing interface masking more complex underlying
 * or structural code
 * 
 * Communicates directly with DemoClient and it defines an entry point to each
 * subsystem
 * 
 * @author LefterisKyriazanos
 *
 */
public class AnalyzerFacade {
	
	/**
	 * Takes the user arguments from the DemoClient and acts as the a client
	 * responsible for the order of operations
	 *
	 */
	public void codeAnalyzer(String filePath, String scaType, String location,
			String outputFilePath, String outputFileType) throws IOException {

		SourceFileReader fileReader = new SourceFileReader();
		String sourceCode = null;
		List<String> sourceCodeList = null;
		SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer();
		int loc = -1;
		int nom = -1;
		int noc = -1;

		if (scaType.equals("regex")) {
		// convert source file to String
			if (location.equals("local")) {
				sourceCode = fileReader.readLocalFileIntoString(filePath);
			} else if (location.equals("web")) {
				sourceCode = fileReader.readWebFileIntoString(filePath);
			} else {
				// exit if @param location is not web or local
				System.err.println("Invalid Source Code Location Type. Try web OR local");
				System.exit(1);
			}
			
			// calculate metrics
			loc = analyzer.calculateRegexLOC(sourceCode);
			nom = analyzer.calculateRegexNOM(sourceCode);
			noc = analyzer.calculateRegexNOC(sourceCode);
		} else if (scaType.equals("strcomp")) {
			// convert source file to List<String>

			if (location.equals("local")) {
				sourceCodeList = fileReader.readLocalFileIntoList(filePath);
			} else if (location.equals("web")) {
				sourceCodeList = fileReader.readWebFileIntoList(filePath);
			} else {
				// exit if @param location is not web or local
				System.err.println("Invalid Source Code Location Type. Try web OR local");
				System.exit(1);
			}
				
			// calculate metrics	
			loc = analyzer.calculateStringLOC(sourceCodeList);
			nom = analyzer.calculateStringNOM(sourceCodeList);
			noc = analyzer.calculateStringNOC(sourceCodeList);

		}

		if (loc != -1 && nom != -1 && noc != -1) {
			// create the output file
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc", loc);
			metrics.put("nom", nom);
			metrics.put("noc", noc);
			MetricsExporter exporter = new MetricsExporter();
			exporter.writeFile(outputFileType, metrics, outputFilePath);
			
		} else {
			System.err.println("An error occured");
			System.exit(1);
		}


	}
}
