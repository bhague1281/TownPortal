/* MapActivity.java
 * Electric Sheep - K.Hall, C.Munoz, A.Reaves
 * Used with Google Maps activity page to display tabs which are
 *   sub-categories of user selected category
 */

package com.android.electricsheep.townportal;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MapActivity extends TabActivity implements
		AdapterView.OnItemSelectedListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// http://stackoverflow.com/questions/2736389/how-to-pass-object-from-one-activity-to-another-in-android
		Intent intent = getIntent();
		PlaceType pt1 = (PlaceType) intent.getSerializableExtra("PlaceType1");
		PlaceType pt2 = (PlaceType) intent.getSerializableExtra("PlaceType2");
		PlaceType pt3 = (PlaceType) intent.getSerializableExtra("PlaceType3");

		super.onCreate(savedInstanceState);

		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_map);

		// Set up TabHost
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this.getLocalActivityManager());

		TabHost.TabSpec spec; // Reusable TabSpec for each tab
		Intent tabIntent; // Reusable Intent for each tab

		// Tab 1 - first tab is required, others may be null
		tabIntent = new Intent().setClass(this, GooglePlacesMap.class)
				.putExtra("type", pt1.getGoogleName());
		spec = tabHost.newTabSpec(pt1.getDisplayName())
				.setIndicator(pt1.getDisplayName()).setContent(tabIntent);
		tabHost.addTab(spec);

		// Tab 2
		if (pt2 != null) {
			tabIntent = new Intent().setClass(this, GooglePlacesMap.class)
					.putExtra("type", pt2.getGoogleName());
			spec = tabHost.newTabSpec(pt2.getDisplayName())
					.setIndicator(pt2.getDisplayName()).setContent(tabIntent);
			tabHost.addTab(spec);
		}

		// Tab 3
		if (pt3 != null) {
			tabIntent = new Intent().setClass(this, GooglePlacesMap.class)
					.putExtra("type", pt3.getGoogleName());
			spec = tabHost.newTabSpec(pt3.getDisplayName())
					.setIndicator(pt3.getDisplayName()).setContent(tabIntent);
			tabHost.addTab(spec);
		}

		tabHost.setCurrentTab(0);

		// loop through all tab views and set height value
		// http://www.speakingcode.com/2011/10/17/adjust-height-of-android-tabwidget/
		int heightValue = 30;
		for (int i = 0; i < tabHost.getTabWidget().getTabCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = (int) (heightValue * this
					.getResources().getDisplayMetrics().density);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		return;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		return;
	}
}
