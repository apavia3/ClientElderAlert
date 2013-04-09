package com.example.clientelderalert;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
/**
* The simplest possible example of using AndroidPlot to plot some data.
*/
public class StatusActivity extends Activity
{
    private XYPlot mySimpleXYPlot;
    
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_status);
        
        mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        // Create a couple arrays of y-values to plot:
        Number[] series1YNumbers = {56,57,58,59,60,62,64,65,64,63,60,58,56,54,55,57,55};
        Number[] series1XNumbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
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
        mySimpleXYPlot.setDomainBoundaries(0, 20, BoundaryMode.FIXED);
        mySimpleXYPlot.setRangeBoundaries(0, 100, BoundaryMode.FIXED);
        mySimpleXYPlot.setTitle("Today's History");

        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(3);
        // by default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
    }
    
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_relatives:
			startActivity(new Intent(this, ContactsActivity.class));
			return true;
		case R.id.action_history:
			startActivity(new Intent(this,HistoryActivity.class));
			return true;
		case R.id.action_settings:
			startActivity(new Intent(this,SettingsActivity.class));
			return true;
		}
		return false;
	}

}