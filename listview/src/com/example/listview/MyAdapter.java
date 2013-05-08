package com.example.listview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<Mydata> arrData;
	LayoutInflater inflater;

	
	public MyAdapter(MainActivity mainActivity, ArrayList<Mydata> arrData) {
		// TODO Auto-generated constructor stub
		this.context = mainActivity;
		this.arrData = arrData;
		inflater = (LayoutInflater) mainActivity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrData.get(position).getName();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_layout, parent, false);
		}
		ImageView image = (ImageView) convertView.findViewById(R.id.image);
		image.setImageResource(arrData.get(position).getImage());
		
		TextView name = (TextView) convertView.findViewById(R.id.name);
		name.setText(arrData.get(position).getName());
		
		TextView tel = (TextView) convertView.findViewById(R.id.tel);
		tel.setText(arrData.get(position).getTel());
		
		TextView email = (TextView) convertView.findViewById(R.id.email);
		email.setText(arrData.get(position).getEmail());
		
		Button modifybtn = (Button) convertView.findViewById(R.id.modifybtn);
		modifybtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "수정", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		Button delbtn = (Button) convertView.findViewById(R.id.delbtn);
		delbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "삭제", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		return convertView;
		
	}

}
