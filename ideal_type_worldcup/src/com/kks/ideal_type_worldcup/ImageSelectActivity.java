package com.kks.ideal_type_worldcup;

import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageSelectActivity extends Activity implements OnClickListener {

	private ImageView left;
	private ImageView right;
	private Star star_left;
	private Star star_right;
	static Vector<Star> Round_16 = new Vector<Star>();
	private Vector<Star> Round_8 = new Vector<Star>();
	private Vector<Star> Round_4 = new Vector<Star>();
	private Vector<Star> Round_2 = new Vector<Star>();

	private int round = 0;
	private int now_tournament = 0;
	private int round_num = 1;
	private CheckBox left_check;
	private CheckBox right_check;
	private TextView left_star_name;
	private TextView right_star_name;
	private TextView kang_text;
	private TextView round_text;
	private Button ok_button;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_select);
		
		Intent intent = getIntent();
		boolean auto = intent.getBooleanExtra("auto", false);
		if (auto) {
			setVector();
		}

		left = (ImageView) findViewById(R.id.left_image);
		right = (ImageView) findViewById(R.id.right_image);
		left_check = (CheckBox) findViewById(R.id.left_checkBox);
		right_check = (CheckBox) findViewById(R.id.right_checkBox);
		left_star_name = (TextView) findViewById(R.id.left_name);
		right_star_name = (TextView) findViewById(R.id.right_name);
		ok_button = (Button) findViewById(R.id.button_ok);
		kang_text = (TextView) findViewById(R.id.kang);
		round_text = (TextView) findViewById(R.id.round);

		left.setOnClickListener(this);
		right.setOnClickListener(this);
		ok_button.setOnClickListener(this);
		now_tournament = 16;
		kang_text.setText(now_tournament + "");
		round_text.setText(round_num + "");
		Set_Round_16();
	}

	private void setVector() {
		for (int i = 0; i < 16; i++) {
			Round_16.add(MainActivity.StarList.get(i));
		}
	}

	private void Set_Round_2() {
		star_left = new Star();
		star_right = new Star();
		star_left = Round_2.get(round);
		star_right = Round_2.get(round + 1);

		Drawable d = getResources().getDrawable(star_left.getImage());
		left.setImageDrawable(d);
		left_star_name.setText(star_left.getName());

		Drawable d1 = getResources().getDrawable(star_right.getImage());
		right.setImageDrawable(d1);
		right_star_name.setText(star_right.getName());
	}

	private void Set_Round_4() {
		star_left = new Star();
		star_right = new Star();
		star_left = Round_4.get(round);
		star_right = Round_4.get(round + 1);

		Drawable d = getResources().getDrawable(star_left.getImage());
		left.setImageDrawable(d);
		left_star_name.setText(star_left.getName());

		Drawable d1 = getResources().getDrawable(star_right.getImage());
		right.setImageDrawable(d1);
		right_star_name.setText(star_right.getName());
	}

	private void Set_Round_8() {
		star_left = new Star();
		star_right = new Star();
		star_left = Round_8.get(round);
		star_right = Round_8.get(round + 1);

		Drawable d = getResources().getDrawable(star_left.getImage());
		left.setImageDrawable(d);
		left_star_name.setText(star_left.getName());

		Drawable d1 = getResources().getDrawable(star_right.getImage());
		right.setImageDrawable(d1);
		right_star_name.setText(star_right.getName());
	}

	public void Set_Round_16() {
		star_left = new Star();
		star_right = new Star();
		star_left = Round_16.get(round);
		star_right = Round_16.get(round + 1);

		Drawable d = getResources().getDrawable(star_left.getImage());
		left.setImageDrawable(d);
		left_star_name.setText(star_left.getName());

		Drawable d1 = getResources().getDrawable(star_right.getImage());
		right.setImageDrawable(d1);
		right_star_name.setText(star_right.getName());
	}

	@Override
	public void onClick(View v) {
		if (v.equals(left)) {
			left_check.setChecked(true);
			right_check.setChecked(false);
		} else if (v.equals(right)) {
			right_check.setChecked(true);
			left_check.setChecked(false);
		} else if (v.equals(ok_button)) {
			check_round();
			left_check.setChecked(false);
			right_check.setChecked(false);
		}
	}

	public void check_round() {
		if (left_check.isChecked() == true) {
			if (now_tournament == 16 && round < 14) {
				check_16_left();
				return;
			} else if (now_tournament == 16 && round_num == 8) {
				Round_8.add(Round_16.get(round));
				round_num = 1;
				round = 0;
				now_tournament = 8;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_8();
				return;
			} else if (now_tournament == 8 && round < 6) {
				check_8_left();
				return;
			} else if (now_tournament == 8 && round == 6) {
				Round_4.add(Round_8.get(round));
				round_num = 1;
				round = 0;
				now_tournament = 4;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_4();
				return;
			} else if (now_tournament == 4 && round < 2) {
				check_4_left();
				return;
			} else if (now_tournament == 4 && round == 2) {
				Round_2.add(Round_8.get(round));
				round_num = 1;
				round = 0;
				now_tournament = 2;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_2();
				return;
			}
			else if (now_tournament == 2) {
				Star star = new Star();
				star = Round_2.get(0);				
				Intent intent = new Intent(ImageSelectActivity.this, WinnerActivity.class);
				intent.putExtra("name", star.getName());
				intent.putExtra("image", star.getImage());
				startActivity(intent);
				ImageSelectActivity.this.finish();				
			}

		} else if (right_check.isChecked() == true) {
			if (now_tournament == 16 && round < 14) {
				check_16_right();
				return;
			} else if (now_tournament == 16 && round_num == 8) {
				Round_8.add(Round_16.get(round + 1));
				round_num = 1;
				round = 0;
				now_tournament = 8;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_8();
				return;
			} else if (now_tournament == 8 && round < 6) {
				check_8_right();
				return;
			} else if (now_tournament == 8 && round == 6) {
				Round_4.add(Round_8.get(round + 1));
				round_num = 1;
				round = 0;
				now_tournament = 4;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_4();
				return;
			}
			else if (now_tournament == 4 && round < 2) {
				check_4_right();
				return;
			} else if (now_tournament == 4 && round == 2) {
				Round_2.add(Round_8.get(round+1));
				round_num = 1;
				round = 0;
				now_tournament = 2;
				kang_text.setText(now_tournament + "");
				round_text.setText(round_num + "");
				Set_Round_2();
				return;
			}
			else if (now_tournament == 2) {
				Star star = new Star();
				star = Round_2.get(1);				
				Intent intent = new Intent(ImageSelectActivity.this, WinnerActivity.class);
				intent.putExtra("name", star.getName());
				intent.putExtra("image", star.getImage());
				startActivity(intent);
				ImageSelectActivity.this.finish();
				return;
			}

		} else {
			Toast.makeText(this, "한명을 선택하세요", Toast.LENGTH_SHORT).show();
		}
	}

	private void check_4_left() {
		Round_2.add(Round_4.get(round));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_4();
	}

	public void check_16_left() {
		Round_8.add(Round_16.get(round));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_16();
	}

	private void check_8_left() {
		if (round == 6) {
			Round_4.add(Round_8.get(round));
			round_num = 1;
			now_tournament = 8;
			Set_Round_4();
			return;
		}
		Round_4.add(Round_8.get(round));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_8();
	}

	private void check_4_right() {
		Round_2.add(Round_4.get(round + 1));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_4();
	}

	private void check_8_right() {
		if (round == 6) {
			Round_4.add(Round_8.get(round + 1));
			round_num = 1;
			now_tournament = 8;
			Set_Round_4();
			return;
		}
		Round_4.add(Round_8.get(round + 1));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_8();
	}

	public void check_16_right() {
		if (round == 14) {
			Round_8.add(Round_16.get(round + 1));
			round_num = 1;
			now_tournament = 8;
			Set_Round_8();
			return;
		}
		Round_8.add(Round_16.get(round + 1));
		round = round + 2;
		round_num++;
		round_text.setText(round_num + "");
		Set_Round_16();
	}
}
