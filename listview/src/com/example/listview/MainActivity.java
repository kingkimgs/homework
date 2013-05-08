package com.example.listview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	ListView list;
	MyAdapter adapter;
	ArrayList<Mydata> arrData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setData();
		adapter = new MyAdapter(this,arrData);
		
		list = (ListView) findViewById(R.id.listView);
		list.setAdapter(adapter);
	}

	private void setData() {
		arrData = new ArrayList<Mydata>();
		arrData.add(new Mydata(R.drawable.ic_launcher, "and", "1234", "123.com"));
		arrData.add(new Mydata(R.drawable.ic_launcher, "and1", "12345", "1235.com"));
		arrData.add(new Mydata(R.drawable.ic_launcher, "and2", "12346", "1236.com"));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
