package com.example.expandablelistview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	String [] type=new String[]{
			"我的好友","大学同学","亲戚朋友"};
	//定义组显示的文字
	String [] [] info=new String[] [] {  {
			"张一","张二"},{"张三"},{"张四"}};
	//定义每一组的内容
	int [] groupImgs=new int[]{
			R.drawable.i1,R.drawable.i2,R.drawable.i3};
	int [] [] imgIds=new int[] [] {
			{R.drawable.a,R.drawable.b},{R.drawable.c},{R.drawable.d}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ExpandableListAdapter myAdpater=new BaseExpandableListAdapter(){

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return info[groupPosition] [childPosition];
				//获取指定组的指定序号的项
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout layout=new LinearLayout(MainActivity.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				layout.setGravity(Gravity.CENTER_VERTICAL);
				ImageView  groupImg=new ImageView(MainActivity.this);
				groupImg.setImageResource(groupImgs[groupPosition]);
				
				layout.addView(groupImg);
				TextView textView=getTextView();
				textView.setText(getGroup(groupPosition).toString());
				//设置线性布局，创建ImageView
				
				layout.addView(textView);
				return layout;

			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return info[groupPosition].length;
				//获取指定组的项数
			}

			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return type[groupPosition];
				//获取指定组的定数
			}

			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return type.length;
				//获取组的个数
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				
				return groupPosition;
				//获取ID
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout layout=new LinearLayout(MainActivity.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				layout.setPadding(20, 0, 0, 0);
				ImageView  itemImage=new ImageView(MainActivity.this);
			    itemImage.setPadding(20, 0, 0, 0);
			    itemImage.setImageResource(imgIds[groupPosition] [childPosition]);
			    layout.addView(textView);
				return layout;
			}

			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
				//子项是否选择
			}
		
			private  TextView getTextView(){
				//自己定义一个TextView
				AbsListView.LayoutParams lp=new  AbsListView.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT);
				//设置宽度和高度
				TextView textView=new TextView(MainActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL);
				textView.setTextSize(20);
				textView.setPadding(30, 0, 0, 0);
				textView.setTextColor(Color.BLACK);
				return textView;
			}
			
		
			
			
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
