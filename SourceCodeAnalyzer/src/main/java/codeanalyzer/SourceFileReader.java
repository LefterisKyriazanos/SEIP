package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class SourceFileReader {
	
	

	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the location of a locally stored file
	 * @return a List that contains the contents of the file 
	 * @throws IOException and FileNotFoundException
	 */
	public List<String> readLocalFileIntoList(String filepath) throws FileNotFoundException, IOException {
		
		// declare bufferedReader
		BufferedReader reader = null;
		
		try {
			List<String> lines = new ArrayList<>();
			File file = new File(filepath);
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines; 
			
		} catch (FileNotFoundException ex) {
			System.err.println("File does not exist. Please give a valid path.");
			return null;
		} catch (IOException ex2) {
			System.err.println(ex2);
			return null;
		}
	}
			
		
	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the URL of a file stored in the web.
	 * @return a List that contains the contents of the file 
	 * @throws IOException and FileNotFoundException
	 */
	public List<String> readWebFileIntoList(String filepath) throws FileNotFoundException, IOException {
		
		// declare bufferedReader
		BufferedReader reader = null;
		
		try {
			// read a file stored in the web
			List<String> lines = new ArrayList<>();
	        URL url = new URL(filepath);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	lines.add(line);
	        }
	        reader.close();
			return lines;
			
		} catch (FileNotFoundException ex) {
			System.err.println("File does not exist. Please give a valid path.");
			return null;
		} catch (IOException ex2) {
			System.err.println(ex2);
			return null;
		}
			
		
	}
	
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the location of a locally stored file.
	 * @return a String that contains the contents of the file 
	 * @throws IOException and FileNotFoundException
	 */
	public String readLocalFileIntoString(String filepath) throws FileNotFoundException, IOException {
		
		// declare bufferedReader
		BufferedReader reader = null;
		
		try {
			// read a locally stored file
			StringBuilder sb = new StringBuilder();
			File file = new File(filepath);
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			return sb.toString();
			
		} catch (FileNotFoundException ex) {
			System.err.println("File does not exist. Please give a valid path.");
			return null;
		} catch (IOException ex2) {
			System.err.println(ex2);
			return null;
		}
	}		
			
			
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the URL of a file stored in the web.
	 * @return a String that contains the contents of the file 
	 * @throws IOException and FileNotFoundException
	 */
	public String readWebFileIntoString(String filepath) throws FileNotFoundException, IOException {
		
		// declare bufferedReader
		BufferedReader reader = null;
		
		try {
			
			// read a file stored in the web
			StringBuilder sb = new StringBuilder();
	        URL url = new URL(filepath);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line + "\n");
	        }
	        reader.close();
			return sb.toString();
			
		} catch (FileNotFoundException ex) {
			System.err.println("File does not exist. Please give a valid path.");
			return null;
		} catch (IOException ex2) {
			System.err.println(ex2);
			return null;
		}
	}

}
