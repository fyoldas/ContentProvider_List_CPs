package com.jpassion.contentprovider_list_cps;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ListCPs extends ListActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_list_cps);
		// Get a list of Activities which can handle the intent
		Context context = ListCPs.this;
		PackageManager packageManager = context.getPackageManager();
		List pkgAppsList = packageManager.queryContentProviders(null, 0, 0);

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				this, // Context
		        R.layout.activity_list_cps_row, // layout description for each list item
		        pkgAppsList);

		// setListAdaptor(..) is a method of ListActivity.
		setListAdapter(arrayAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_cps, menu);
		return true;
	}

}
