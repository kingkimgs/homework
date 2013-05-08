package com.kks.ideal_type_worldcup;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageSelectActivity extends Activity implements OnClickListener{
	
	ImageView left;
	ImageView right;
	Star star;
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_select);
		
		left = (ImageView) findViewById(R.id.left_image);
		right = (ImageView) findViewById(R.id.right_image);
		left.setOnClickListener(this);
		right.setOnClickListener(this);
		
//		star = new Star();
//		star = MainActivity.StarList.get(0);
		
		Drawable d =  getResources().getDrawable(R.drawable.hara);		
		left.setImageDrawable(d);
		
		Drawable d1 =  getResources().getDrawable(R.drawable.suzy);		
		right.setImageDrawable(d1);
	}

	@Override
	public void onClick(View v) {
		if(v.equals(left)){
			Toast.makeText(this, "left", Toast.LENGTH_SHORT).show();
		}
		else{
			
		}
		
	}


}
