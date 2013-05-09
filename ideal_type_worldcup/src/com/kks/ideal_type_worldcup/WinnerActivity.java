package com.kks.ideal_type_worldcup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class WinnerActivity extends Activity {
	
	private TextView winner_name;
	private ImageView winner_image;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.winner);
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int image = intent.getIntExtra("image", 0);
		
		winner_name = (TextView) findViewById(R.id.winner_name);
		winner_image = (ImageView) findViewById(R.id.winner_image);
		
		winner_name.setText(name);
		Drawable d = getResources().getDrawable(image);
		winner_image.setImageDrawable(d);		
	}

}
