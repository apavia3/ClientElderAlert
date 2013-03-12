package com.example.clientelderalert;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    private ImageView settingsImage;
    private ImageView contactsImage;
    private ImageView historyImage;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_status);
        
        settingsImage = (ImageView) findViewById(R.id.settings);
        settingsImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(StatusActivity.this, SettingsActivity.class);
				startActivity(i);
			}
		});
        
        contactsImage = (ImageView) findViewById(R.id.contacts);
        contactsImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(StatusActivity.this, ContactsActivity.class);
				startActivity(i);
			}
		});
        
        historyImage = (ImageView) findViewById(R.id.history);
        historyImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(StatusActivity.this, HistoryActivity.class);
				startActivity(i);
			}
		});
        
        mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {50,50,50,50,50,50,50,50,65,60,60,60,65,65,60,65,55};
        Number[] time = {
                978307200,  // 2001
                1009843200, // 2002
                1041379200, // 2003
                1072915200, // 2004
                1104537600  // 2005
        }; 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series
        // same as above
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(256, 0, 0),                   // line color
                Color.rgb(256, 0, 0),                   // point color
                null);                                  // fill color (none)
        // add a new series' to the xyplot:
        mySimpleXYPlot.addSeries(series1, series1Format);
        mySimpleXYPlot.setDomainLabel("Hour");
        mySimpleXYPlot.setRangeLabel("Average BPM"); 
        mySimpleXYPlot.setDomainBoundaries(0, 200, BoundaryMode.AUTO);

        // reduce the number of range labels
        mySimpleXYPlot.setTicksPerRangeLabel(3);
        // by default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
    }
}