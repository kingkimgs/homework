package com.kks.ideal_type_worldcup;

import java.util.Vector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	Vector<Star> arrData;
	CheckBox ch;
	ImageView image;
	TextView name;
	LayoutInflater inflater;

	public MyAdapter(selectListActivity selectListActivity,
			Vector<Star> starlist) {
		// TODO Auto-generated constructor stub
		this.context = selectListActivity;
		this.arrData = starlist;
		inflater = (LayoutInflater) selectListActivity
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
		image = (ImageView) convertView.findViewById(R.id.image);
		name = (TextView) convertView.findViewById(R.id.name);
		ch = (CheckBox) convertView.findViewById(R.id.list_check);		
		image.setImageResource(arrData.get(position).getImage());
		name.setText(arrData.get(position).getName());
		ch.setFocusable(false);
		ch.setClickable(false);
		ch.setChecked(((ListView) parent).isItemChecked(position));
		return convertView;

	}
}
