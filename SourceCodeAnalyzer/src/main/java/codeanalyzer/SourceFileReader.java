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
import java.net.MalformedURLException;

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
	 * @exception NullPointerException when the given file does not exist 
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public List<String> readLocalFileIntoList(String filepath)  {
		
	
		
		// declare bufferedReader
		BufferedReader reader = null;
		List<String> lines = new ArrayList<>();
		
		
		
		try {
			
			// if filepath is invalid then NullPointerException is raised
			File file = new File(filepath);
			
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close(); 
			
		} catch (NullPointerException ex1) {
			ex1.printStackTrace();
			System.out.println(ex1.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
			
		} catch (IOException ex2) {
			ex2.printStackTrace();
			System.out.println(ex2.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
		}
		
		
		
		return lines;
		
	}
			
		
	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the URL of a file stored in the web.
	 * @return a List that contains the contents of the file 
	 * @exception NullPointerException when the given file does not exist 
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public List<String> readWebFileIntoList(String filepath)  {
		
		// declare bufferedReader
		BufferedReader reader = null;
		// read a file stored in the web
		List<String> lines = new ArrayList<>();
	    
	    
		
		try {
			
			URL url = new URL(filepath);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	lines.add(line);
	        }
	        reader.close();
			
		} catch (NullPointerException ex1) {
			ex1.printStackTrace();
			System.out.println(ex1.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
			
		} catch (IOException ex2) {
			ex2.printStackTrace();
			System.out.println(ex2.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
		} 
		
		
		
		return lines;
	}
	
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the location of a locally stored file.
	 * @return a String that contains the contents of the file 
	 * @exception NullPointerException when the given file does not exist 
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public String readLocalFileIntoString(String filepath) {
		
		
		
		
		
		// declare bufferedReader
		BufferedReader reader = null;
		// read a locally stored file
		StringBuilder sb = new StringBuilder();
		try {
			// if filepath is invalid then NullPointerException is raised
			File file = new File(filepath);
			
		
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		
		} catch (NullPointerException ex1) {
			ex1.printStackTrace();
			System.out.println(ex1.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
			
		} catch (IOException ex2) {
			ex2.printStackTrace();
			System.out.println(ex2.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
		}
		
		
		
		return sb.toString();
	}		
			
			
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the URL of a file stored in the web.
	 * @return a String that contains the contents of the file 
	 * @exception NullPointerException when the given file does not exist 
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public String readWebFileIntoString(String filepath)  {
		
		// declare bufferedReader
		BufferedReader reader = null;
		// read a file stored in the web
		StringBuilder sb = new StringBuilder();
	
	    
		try {
			
			URL url = new URL(filepath);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line + "\n");
	        }
	        reader.close();
			
		} catch (NullPointerException ex1) {
			ex1.printStackTrace();
			System.out.println(ex1.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
			
		} catch (IOException ex2) {
			ex2.printStackTrace();
			System.out.println(ex2.toString());
			System.out.println("The system will now terminate");
			System.exit(1);
		} 
		
		
		return sb.toString();
	}

}
