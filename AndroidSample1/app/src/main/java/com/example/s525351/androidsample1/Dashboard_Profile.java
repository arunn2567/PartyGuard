package com.example.s525351.androidsample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard_Profile extends Activity implements OnClickListener{
	
	
    RelativeLayout rel_feeling_unsafe, accident, fight, rel_other;
	ImageView img_back;
	TextView txt_emergency;
	ImageView  img_edit;
	TextView txt_home, txt_log, txt_location, txt_settings,txt_signout;
	public RelativeLayout mDrawerList;
	public DrawerLayout mDrawerLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard__profile);
		
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);

		img_edit = (ImageView)findViewById(R.id.img_edit);
		img_edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), Profile.class);
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
	
		img_back = (ImageView)findViewById(R.id.img_back);
		img_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Dashboard.class);
				startActivity(i);
			}
		});
		
		rel_feeling_unsafe = (RelativeLayout)findViewById(R.id.rel_feeling_unsafe);
		rel_feeling_unsafe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Dashboard_unsafe.class);
				startActivity(i);
			}
		});
		
		accident = (RelativeLayout)findViewById(R.id.accident);
		accident.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Dashboard_unsafe.class);
				startActivity(i);
			}
		});
		
		fight = (RelativeLayout)findViewById(R.id.fight);
		fight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Dashboard_unsafe.class);
				startActivity(i);
			}
		});
		
		rel_other = (RelativeLayout)findViewById(R.id.rel_other);
		rel_other.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), Dashboard_unsafe.class);
				startActivity(i);
			}
		});
		
		txt_emergency = (TextView)findViewById(R.id.txt_emergency);
		txt_emergency.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Emergency", Toast.LENGTH_LONG).show();
			}
		});
	
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
            	Intent i2 = new Intent(getApplicationContext(),Location.class );
            	startActivity(i2);
                break; 
                
            case R.id.txt_settings:
//            	Intent i3 = new Intent(getApplicationContext(), );
//            	startActivity(i3);
                break; 
		
            case R.id.txt_signout:
				mDrawerLayout.closeDrawer(mDrawerList);
				Dashboard_Profile.this.finish();
				startActivity(new Intent(Dashboard_Profile.this, LoginActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
								| Intent.FLAG_ACTIVITY_CLEAR_TASK));
				break;
	}
	}
	

	
	/*public void onShowDialogWindow(View v) {
		android.app.FragmentManager fm = getFragmentManager();
		Fragment_dashboard_alertdialog fragment_dashboard_alertdialog = Fragment_dashboard_alertdialog.newInstance("Type your name");
		fragment_dashboard_alertdialog.show(fm, "activity_fragment_dashboard_alertdialog");
	}

	



	public void onFinishEditDialog(String inputText) {
		//Toast.makeText(this, "Your name is: " + inputText, Toast.LENGTH_SHORT).show();
	}
*/

	        
	        
	       
	 
	  /* public void buttonPress(View view) {
	        // show imm
	        InputMethodManager imm = (InputMethodManager) this.getSystemService(
	                Context.INPUT_METHOD_SERVICE);
	        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
	                InputMethodManager.HIDE_IMPLICIT_ONLY);
	    }*/
}
