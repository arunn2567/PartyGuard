package com.example.s525351.androidsample1;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login_IntroSlider extends Activity {
	

	private ViewPager viewPager;
	private MyViewPagerAdapter myViewPagerAdapter;
	private ArrayList<Integer> listOfItems;
	
	private LinearLayout dotsLayout;
	private int dotsCount;
	private TextView[] dots;
	
	TextView txt_skip, txt_finish;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login__intro_slider);
	
		
		txt_skip = (TextView)findViewById(R.id.txt_skip);
		txt_skip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Dashboard.class);
				startActivity(i);
			}
		});
		
		txt_finish = (TextView)findViewById(R.id.txt_finish);
		txt_finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Dashboard.class);
				startActivity(i);
			}
		});
	
		initViews();
		setViewPagerItemsWithAdapter();
		setUiPageViewController();
	}

	
	private void setUiPageViewController() {
		dotsLayout = (LinearLayout)findViewById(R.id.viewPagerCountDots);
		dotsCount = myViewPagerAdapter.getCount();
		dots = new TextView[dotsCount];
		
		for (int i = 0; i < dotsCount; i++) {
			dots[i] = new TextView(this);
			dots[i].setText(Html.fromHtml("&#8226;"));
			dots[i].setTextSize(30);
			dots[i].setTextColor(getResources().getColor(android.R.color.black));
			dotsLayout.addView(dots[i]);			
		}
		
		dots[0].setTextColor(getResources().getColor(R.color.app_green));
	}

	private void setViewPagerItemsWithAdapter() {
		myViewPagerAdapter = new MyViewPagerAdapter(listOfItems);
		viewPager.setAdapter(myViewPagerAdapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
	}
	
	//	page change listener
	OnPageChangeListener viewPagerPageChangeListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			for (int i = 0; i < dotsCount; i++) {
				dots[i].setTextColor(getResources().getColor(android.R.color.black));
			}
			dots[position].setTextColor(getResources().getColor(R.color.app_green));
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}
	};

	private void initViews() {
		

		
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		
		listOfItems = new ArrayList<Integer>();
		listOfItems.add(1);
		listOfItems.add(2);
		listOfItems.add(3);
	}
	
	//	adapter
	public class MyViewPagerAdapter extends PagerAdapter{
		
		private LayoutInflater layoutInflater;
		private ArrayList<Integer> items;

		public MyViewPagerAdapter(ArrayList<Integer> listOfItems) {
			this.items = listOfItems;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view = layoutInflater.inflate(R.layout.view_pager_item, container,false);
			
			TextView tView = (TextView)view.findViewById(R.id.PageNumber);
			
			tView.setText(listOfItems.get(position).toString());
			
			((ViewPager) container).addView(view);
			
			return view;
		}

		@Override
		public int getCount() {
			return items.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == ((View)obj);
		}
		
				
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			View view = (View)object;
	        ((ViewPager) container).removeView(view);
		}
	}
}
