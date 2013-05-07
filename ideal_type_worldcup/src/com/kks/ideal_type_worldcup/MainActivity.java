package com.kks.ideal_type_worldcup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button startButton;
	Button rankButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startButton = (Button) findViewById(R.id.start);
		rankButton = (Button) findViewById(R.id.rank);

		startButton.setOnClickListener(this);
		rankButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.equals(startButton)) {
			AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
			localBuilder.setTitle("선택하세요.");
			localBuilder.setNeutralButton("랜덤선택",
					new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface paramAnonymousDialogInterface,
								int paramAnonymousInt) {

							Intent intent = new Intent(MainActivity.this,
									ImageSelectActivity.class);
							startActivity(intent);
							MainActivity.this.finish();
						}
					});
			localBuilder.setNegativeButton("직접선택",
					new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface paramAnonymousDialogInterface,
								int paramAnonymousInt) {							
							Intent intent = new Intent(
									MainActivity.this,
									selectListActivity.class);
							startActivity(intent);
							MainActivity.this.finish();
						}
					});
			localBuilder.show();
		} else {
			Intent intent = new Intent(MainActivity.this, RankActivity.class);
			startActivity(intent);
		}
	}
}
