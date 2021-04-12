package gradeshistogram;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {



	public static void main(String[] args) throws FileNotFoundException {
		


		if (args.length == 0) {
			System.out.println(
					"Proper Usage is: $ java -jar path-to-jar-file path-to-grades-file");
			System.exit(0);
		

	}	else {
			try {
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

				for (Integer s : gradesArray) {
					System.out.println(s);
				}
				HistogramGenerator hg = new HistogramGenerator();
				hg.generateChart(gradesArray);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println(
						"Proper Usage is: $ java -jar path-to-jar-file path-to-grades-file");
				System.exit(0);
			}
    }
		
	}

	
	
	
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
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
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

}

