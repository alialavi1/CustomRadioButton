package com.puji.customerrangebar;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity{
	
	private CustomerRangeBar mRangeBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mRangeBar = (CustomerRangeBar)findViewById(R.id.rangerBar);
		List<String> data = new ArrayList<String>();
		data.add("0元");
		data.add("5元");
		data.add("10元");
		data.add("15元");
		mRangeBar.setTickCount(data.size());
		mRangeBar.setData(data);
	}
}
