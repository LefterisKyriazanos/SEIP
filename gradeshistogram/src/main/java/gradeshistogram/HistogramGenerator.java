package gradeshistogram;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author LefterisKyriazanos The purpose of this class is to read a text file
 *         of Student grades (on runtime), store it in an Integer Array and
 *         create its Histogram by calling the generateChart method
 * 
 * 
 */

public class HistogramGenerator {



	public static void main(String[] args) throws FileNotFoundException {
		

		/***
		 * checks if the user gave a text file path. If not, a message that
		 * suggests the right way to call the program is printed. Program
		 * Terminates and the user has to call it again
		 */
		if (args.length == 0) {
			System.out.println(
					"Proper Usage is: $ java -jar path-to-jar-file path-to-grades-file");
			System.exit(0);
		
			/***
			 * If the user has given a Path for a text file this block (else) is
			 * executed.
			 * 
			 * case 1: the user has given an invalid Path an exception is raised
			 * and a message that suggests the right way to call the program is
			 * printed. Also the exception message is printed. Program
			 * Terminates and the user has to call it again
			 * 
			 * case 2: the user has given a proper text file Path. The file is
			 * read and stored in an Integer Array. The Array is passed to
			 * generateChart method.
			 * 
			 */
	}	else {
			// try block
			try {
				// read file and store to Integer Array (gradesArray)
				File file = new File(args[0]);
				Scanner grades_file = new Scanner(file);
				List<Integer> grades = new ArrayList<Integer>();
				while (grades_file.hasNext()) {
					// find next line
					float grade1 = grades_file.nextInt();
					grades.add((int) grade1);
				}
				grades_file.close();

				Integer[] gradesArray = grades.toArray(new Integer[0]);
				Integer[] freq = new Integer[11];

				// create a HistogramGenerator Object
				HistogramGenerator hg = new HistogramGenerator();

				// call countFrequency, to get the frequency of each grade
				freq = hg.countFrequency(gradesArray);

				// call generateChart, while giving the grades frequency array
				// as argument
				hg.generateChart(freq);

				// inform the user about handling the program
				System.out
						.println("The histogram will pop up in a new window!");
				System.out.println("Press CTRL + C to exit");

				// catch block if FileNotFoundException Exception raises
			} catch (Exception e) {
				System.out.println(e);
				System.out.println(
						"Proper Usage is: $ java -jar path-to-jar-file path-to-grades-file");
				System.exit(0);
			}
    }
		
	}

	
	
	/***
	 * 
	 * original @author agkortzis The purpose of this class is to demonstrate a
	 * simple scenario of a JFreeChart XYLine chart. i (@author
	 * LefterisKyriazanos) just added a few modifications in order to show a
	 * Chart Tittle and tittles for X,Y axis.
	 */
	public void generateChart(Integer[] gradesArray) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < gradesArray.length; i++) {
			data.add(i, gradesArray[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Student Grades Frequency Histogram", "Grade", "Frequency",
				dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/*
	 * This method takes the Student Grades array and counts the frequency of
	 * each element
	 */
	public Integer[] countFrequency(Integer[] gradesArray) {

		// Array fr will store frequencies of element
		Integer[] fr = new Integer[11];
		boolean[] visited = new boolean[11];
		for (int i = 0; i < gradesArray.length; i++) {

			if (!visited[gradesArray[i]]) {
				int count = 1;
				for (int j = i + 1; j < gradesArray.length; j++) {
					if (gradesArray[i] == gradesArray[j]) {
						count++;
						visited[gradesArray[i]] = true;
					}
				}

				fr[gradesArray[i]] = count;
			}
		}
		System.out.println(Arrays.toString(fr));
		return fr;
	}

}

