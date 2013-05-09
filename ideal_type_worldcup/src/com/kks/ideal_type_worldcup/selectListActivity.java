package com.kks.ideal_type_worldcup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class selectListActivity extends Activity implements OnClickListener {

	ListView list;
	MyAdapter adapter;
	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_list);

		adapter = new MyAdapter(this, MainActivity.StarList);

		list = (ListView) findViewById(R.id.listview);
		list.setAdapter(adapter);
		list.setItemsCanFocus(false);
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		start = (Button) findViewById(R.id.list_start);
		start.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int check_num = 0;
		for (int i = 0; i < 20; i++) {
			if (list.isItemChecked(i)) {
				ImageSelectActivity.Round_16.add(MainActivity.StarList.get(i));
				check_num++;
			}
		}
		if (check_num == 16) {
			Intent intent = new Intent(selectListActivity.this,ImageSelectActivity.class);
			intent.putExtra("auto", false);
			startActivity(intent);
			selectListActivity.this.finish();
		}
	}
}
