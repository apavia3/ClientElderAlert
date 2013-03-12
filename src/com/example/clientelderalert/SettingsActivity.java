/**
 * 
 */
package com.example.clientelderalert;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Ishwarya
 *
 */
public class SettingsActivity extends Activity {

	/**
	 * 
	 */
	public SettingsActivity() {
		// TODO Auto-generated constructor stub
		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_activity_layout);
		
		ListView listView = (ListView) findViewById(R.id.settingsList);
		String[] values = new String[] { "Calibration", "Account Settings", "Display Settings"};
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, values);
	
		// Assign adapter to ListView
		listView.setAdapter(adapter); 
	}
}
