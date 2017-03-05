package com.example.s525351.androidsample1;


import java.util.prefs.Preferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Dashboard extends Activity implements View.OnClickListener{
	LinearLayout linearLayout1;
	public RelativeLayout mDrawerList;
	public DrawerLayout mDrawerLayout;
	ImageView img_left_menu, img_edit;
	
	TextView txt_home, txt_log, txt_location, txt_settings,txt_signout;
	
	RelativeLayout abhi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);
		img_left_menu = (ImageView)findViewById(R.id.img_left_menu);
		img_left_menu.setOnClickListener(this);
		
		img_edit = (ImageView)findViewById(R.id.img_edit);
		img_edit.setOnClickListener(new OnClickListener() {
 			@Override
 			public void onClick(View v) {
 				Intent i = new Intent(getApplicationContext(), Profile.class);
 				startActivity(i);
 				
 			}
 		});
		
		 linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
         
	 		linearLayout1.setOnClickListener(new OnClickListener() {
	 			
	 			@Override
	 			public void onClick(View v) {
	 				Intent i = new Intent(getApplicationContext(), Dashboard_Profile.class);
	 				startActivity(i);
	 				
	 			}
	 		});
		
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
//            	Intent i1 = new Intent(getApplicationContext(), );
//            	startActivity(i1);
                break; 
                
            case R.id.txt_location:
            	Intent i2 = new Intent(getApplicationContext(), Location.class);
            	startActivity(i2);
                break; 
                
            case R.id.txt_settings:
//            	Intent i3 = new Intent(getApplicationContext(), );
//            	startActivity(i3);
                break; 
		
            case R.id.txt_signout:
				mDrawerLayout.closeDrawer(mDrawerList);
				Dashboard.this.finish();
				startActivity(new Intent(Dashboard.this, LoginActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
								| Intent.FLAG_ACTIVITY_CLEAR_TASK));
				break;
	}
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
}
