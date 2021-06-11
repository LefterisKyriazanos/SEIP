package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzerFacade {
	
	
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
			if (location.equals("local")) {
				sourceCode = fileReader.readLocalFileIntoString(filePath);
			} else if (location.equals("web")) {
				sourceCode = fileReader.readWebFileIntoString(filePath);
			} else {
				System.err.println("Invalid Source Code Location Type. Try web OR local");
				System.exit(1);
			}

			loc = analyzer.calculateRegexLOC(sourceCode);
			nom = analyzer.calculateRegexNOM(sourceCode);
			noc = analyzer.calculateRegexNOC(sourceCode);
		} else if (scaType.equals("strcomp")) {
			

			if (location.equals("local")) {
				sourceCodeList = fileReader.readLocalFileIntoList(filePath);
			} else if (location.equals("web")) {
				sourceCodeList = fileReader.readWebFileIntoList(filePath);
			} else {
				System.err.println("Invalid Source Code Location Type. Try web OR local");
				System.exit(1);
			}
				
				
			loc = analyzer.calculateStringLOC(sourceCodeList);
			nom = analyzer.calculateStringNOM(sourceCodeList);
			noc = analyzer.calculateStringNOC(sourceCodeList);

		}
		if (loc != -1 && nom != -1 && noc != -1) {
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc", loc);
			metrics.put("nom", nom);
			metrics.put("noc", noc);
			MetricsExporter exporter = new MetricsExporter();
			exporter.writeFile(outputFileType, metrics, outputFilePath);
		}


	}
}
