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
public class LastweekActivity extends Activity {
	private XYPlot mySimpleXYPlot;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lastweek_activity_layout);
		
		mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        // Create a couple arrays of y-values to plot:
		Integer[] allValues = {58,56,54,55,57,55,60,62,68,70,75,73,70,
				56,57,60,59,60,70,64,70,64,63,60,58,56,54,55,75,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,80,75,73,70,58,66,54,55,57,55,60,62,68,70,75,73,70,
				56,57,58,65,60,62,64,65,70,63,60,58,56,75,55,57,65,60,62,68,70,75,73,70,
				56,62,66,64,60,62,64,65,64,63,70,58,56,54,65,57,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,70,64,63,77,58,49,54,55,57,55,60,62,68,70,75,73,70,
				56,57,58,59,60,62,64,65,64,63,55,58,56,54,55,57,55,60,62,68,70,75,73,70};
		Integer weekAvg = 0;
		Number[] series1YNumbers = new Number [7];
		for(int i = allValues.length-24; i < allValues.length; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[6] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-48; i < allValues.length-24; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[5] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-72; i < allValues.length-48; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[4] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-96; i < allValues.length-72; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[3] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-120; i < allValues.length-96; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[2] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-144; i < allValues.length-120; i++) {
			weekAvg+=allValues[i];
		}
		weekAvg/=24;
        series1YNumbers[1] = (Number) weekAvg;
        weekAvg = 0;
        
		for(int i = allValues.length-144; i >= 0; i--) {
			weekAvg+=allValues[i];
		}
		weekAvg/=(allValues.length-144);
        series1YNumbers[0] = (Number) weekAvg;
        weekAvg = 0;
        
        Number[] series1XNumbers = {0,1,2,3,4,5,6};
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
        mySimpleXYPlot.setDomainLabel("Day");
        mySimpleXYPlot.setRangeLabel("Average BPM per day"); 
        mySimpleXYPlot.setDomainBoundaries(0, 7, BoundaryMode.FIXED);
        mySimpleXYPlot.setRangeBoundaries(0, 100, BoundaryMode.FIXED);
        mySimpleXYPlot.setTitle("Last Week's History");

        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(3);
        // by default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
	}
}
