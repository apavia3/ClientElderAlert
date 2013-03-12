package com.example.clientelderalert;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends Activity {

	public ContactsActivity() {
		// TODO Auto-generated constructor stub
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_activity_layout);
		
		ListView listView = (ListView) findViewById(R.id.contactsList);
		String[] values = new String[] { "Andy Pavia", "Vishnu Rajeevan", "Ishwarya Venkat"};
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, values);
	
		// Assign adapter to ListView
		listView.setAdapter(adapter); 
	}
}
