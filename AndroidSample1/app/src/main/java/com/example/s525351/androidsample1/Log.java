package com.example.s525351.androidsample1;


import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Log extends  Activity implements OnClickListener {
	TextView txt_home, txt_log, txt_location, txt_settings,txt_signout;
	public RelativeLayout mDrawerList;
	public DrawerLayout mDrawerLayout;
	ImageView img_left_menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log); 
		
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);
		img_left_menu = (ImageView)findViewById(R.id.img_left_menu);
		img_left_menu.setOnClickListener(this);
		
		txt_home 	= (TextView)findViewById(R.id.txt_home);
		txt_home.setOnClickListener(this);
	 		
	 		txt_log 		= (TextView)findViewById(R.id.txt_log);
	 		txt_log.setOnClickListener(this);
	 		
	 		txt_location 	= (TextView)findViewById(R.id.txt_location);
	 		txt_location.setOnClickListener(this);
	 		
	 		txt_settings 	= (TextView)findViewById(R.id.txt_settings);
	 		txt_settings.setOnClickListener(this);
	 		
	 		txt_signout 	= (TextView)findViewById(R.id.txt_signout);
	 		txt_signout.setOnClickListener(this);
	    
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        
		case R.id.img_left_menu:
			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {

				mDrawerLayout.openDrawer(mDrawerList);

			}
			break;
			
            case R.id.txt_home:
            	Intent i = new Intent(getApplicationContext(), Dashboard.class);
            	startActivity(i);
                break; 
                
            case R.id.txt_log:
            	Intent i1 = new Intent(getApplicationContext(), Log.class);
            	startActivity(i1);
                break; 
//
//            case R.id.txt_location:
//            	Intent i2 = new Intent(getApplicationContext(), Location.class);
//            	startActivity(i2);
//                break;
                
            case R.id.txt_settings:
            	Intent i3 = new Intent(getApplicationContext(), Settings.class);
            	startActivity(i3);
                break; 
		
            case R.id.txt_signout:
				mDrawerLayout.closeDrawer(mDrawerList);
				Log.this.finish();
				startActivity(new Intent(Log.this, LoginActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
								| Intent.FLAG_ACTIVITY_CLEAR_TASK));
				break;
	}
	}
}
