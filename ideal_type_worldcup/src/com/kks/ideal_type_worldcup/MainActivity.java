package com.kks.ideal_type_worldcup;

import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startButton;
	private Button rankButton;
	
	int imagelist [] = {R.drawable.hara,R.drawable.minkyung,R.drawable.seoli,R.drawable.seunyeon,R.drawable.sohee,R.drawable.sunny
			,R.drawable.suzy};
	String nameList [] = {"구하라","설리"};
	
	static final Vector<Star> StarList = new Vector<Star>();	
	Star  star;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startButton = (Button) findViewById(R.id.start);
		rankButton = (Button) findViewById(R.id.rank);

		startButton.setOnClickListener(this);
		rankButton.setOnClickListener(this);
		
		star = new Star();
		addList();
	}
	
	public void addList(){
		for(int i =0 ; i < nameList.length ; i++){			
			star.setName(nameList[i]);
			star.setImage(imagelist[i]);			
			StarList.add(star);
		}
		
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
