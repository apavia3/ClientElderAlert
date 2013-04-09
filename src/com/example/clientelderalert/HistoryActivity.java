package com.example.clientelderalert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

public class HistoryActivity extends Activity {

	// TODO Auto-generated constructor stub
	RadioButton rbToday;
	RadioButton rbYesterday;
	RadioButton rbLastWeek;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_activity_layout);
			
	    rbToday = (RadioButton) findViewById(R.id.rbToday);
	    rbToday.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HistoryActivity.this, TodayActivity.class);
				startActivity(i);
			}
		});
	    
	    rbYesterday = (RadioButton) findViewById(R.id.rbYesterday);
	    rbYesterday.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HistoryActivity.this, YesterdayActivity.class);
				startActivity(i);
			}
		});
	    
	    rbLastWeek = (RadioButton) findViewById(R.id.rbLastWeek);
	    rbLastWeek.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HistoryActivity.this, LastweekActivity.class);
				startActivity(i);
			}
		});
	}
}
