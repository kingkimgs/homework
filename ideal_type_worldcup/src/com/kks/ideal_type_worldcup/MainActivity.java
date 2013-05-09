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
		
	int imagelist [] = {R.drawable.cristal,R.drawable.gain,R.drawable.hara,R.drawable.hyuna,R.drawable.jesica,R.drawable.jihyun,R.drawable.minkyung,R.drawable.parkbom,R.drawable.sandara,R.drawable.sehyun,R.drawable.seoli,R.drawable.seunyeon,R.drawable.sohee,R.drawable.sooyoung,R.drawable.sunny,R.drawable.suzy,R.drawable.teayeon,R.drawable.victoria,R.drawable.youna,R.drawable.yui};		
	String nameList [] = {"크리스탈","가인","구하라","현아","제시카","남지현","강민경","박봄","산다라박","서현","설리","한승연","소희","수영","써니","수지","태연","빅토리아","윤아","유리"};
	
	static final Vector<Star> StarList = new Vector<Star>();	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startButton = (Button) findViewById(R.id.start);		

		startButton.setOnClickListener(this);		
		
		
		addList();
	}
	
	public void addList(){
		for(int i =0 ; i < 16 ; i++){
			Star star = new Star();
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
			localBuilder.setNeutralButton("자동선택",
					new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface paramAnonymousDialogInterface,
								int paramAnonymousInt) {

							Intent intent = new Intent(MainActivity.this,
									ImageSelectActivity.class);
							intent.putExtra("auto", true);
							startActivity(intent);							
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
						}
					});
			localBuilder.show();
		} 
	}
}
