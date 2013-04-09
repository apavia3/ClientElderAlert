/**
 * 
 */
package com.example.clientelderalert;

import java.util.Arrays;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Ishwarya
 *
 */
public class TodayActivity extends Activity {
	private XYPlot mySimpleXYPlot;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.today_activity_layout);
		Integer[] allValues = {58,56,54,55,57,55,60,62,68,70,75,73,70,
				56,57,60,59,60,70,64,70,64,63,60,58,56,54,55,75,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,80,75,73,70,58,66,54,55,57,55,60,62,68,70,75,73,70,
				56,57,58,65,60,62,64,65,70,63,60,58,56,75,55,57,65,60,62,68,70,75,73,70,
				56,62,66,64,60,62,64,65,64,63,70,58,56,54,65,57,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,70,64,63,77,58,49,54,55,57,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,65,64,63,55,58,56,54,55,57,55,60,62,68,70,75,73,70};
		mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        // Create a couple arrays of y-values to plot:
		 int endpoint = allValues.length - 144;
		 
		 Number[] series1YNumbers = new Number [endpoint];
	     Number[] series1XNumbers = new Number [endpoint];
	     
	     for(int i = 0; i < endpoint; i++) {
	    	 series1YNumbers[i] = allValues[i];
	    	 series1XNumbers[i] = i;
	     }
         Number[] time = {
                978307200,  // 2001
                1009843200, // 2002
                1041379200, // 2003
                1072915200, // 2004
                1104537600  // 2005
        }; 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1XNumbers),          // SimpleXYSeries takes a List so turn our array into a List
                Arrays.asList(series1YNumbers),// Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series
        // same as above
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(255, 0, 0),                   // line color
                Color.rgb(255, 0, 0),                   // point color
                null);                                  // fill color (none)
        // add a new series' to the xyplot:
        mySimpleXYPlot.addSeries(series1, series1Format);
        mySimpleXYPlot.setDomainLabel("Hour");
        mySimpleXYPlot.setRangeLabel("Average BPM"); 
        mySimpleXYPlot.setDomainBoundaries(0, 24, BoundaryMode.FIXED);
        mySimpleXYPlot.setRangeBoundaries(0, 100, BoundaryMode.FIXED);
        mySimpleXYPlot.setTitle("Today's History");

        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(2);
        // by default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
	}
}
