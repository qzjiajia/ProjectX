package com.am.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.am.widget.R;
import com.am.widget.citylistview.CitysListView.BaseCitysAdapter;

public class CityListActivity extends Activity {


	private ListView listView;

	private BaseCitysAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_citylist);
		super.onCreate(savedInstanceState);
		listView = (ListView) findViewById(android.R.id.list);
		adapter = new MyCitysAdapter(this, android.R.layout.simple_list_item_2);
		listView.setAdapter(adapter);

	}

}
