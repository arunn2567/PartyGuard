package com.example.s525351.androidsample1;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard_unsafe extends ActionBarActivity implements OnClickListener {

	ImageView img_back, img_edit;
	TextView txt_emergency;
	RelativeLayout upstairs,mainfloor,basement,deck;
	
	TextView txt_home, txt_log, txt_location, txt_settings,txt_signout;
	public RelativeLayout mDrawerList;
	public DrawerLayout mDrawerLayout;
	Button btn_login1;
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_dashboard_unsafe);


		img_edit = (ImageView)findViewById(R.id.img_edit);
		img_edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), Profile.class);
				startActivity(i);

			}
		});


		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);



//
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
				Intent i = new Intent(getApplicationContext(), Dashboard_Profile.class);
				startActivity(i);
			}
		});


//		btn_login1 = (Button)findViewById(R.id.dialogButton);
//		btn_login1.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Fragment_dashboard_alertdialog dialog = new Fragment_dashboard_alertdialog().newInstance("PartyGuard");
//				dialog.show(getSupportFragmentManager(),"Fragment_dashboard_alertdialog");
//
//			}
//		});
		upstairs = (RelativeLayout)findViewById(R.id.upstairs);
		upstairs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Fragment_dashboard_alertdialog dialog = new Fragment_dashboard_alertdialog().newInstance("PartyGuard");
				dialog.show(getSupportFragmentManager(),"Fragment_dashboard_alertdialog");
			}
		});
		
		mainfloor = (RelativeLayout)findViewById(R.id.mainfloor);
		mainfloor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment_dashboard_alertdialog dialog = new Fragment_dashboard_alertdialog().newInstance("PartyGuard");
				dialog.show(getSupportFragmentManager(),"Fragment_dashboard_alertdialog");
			}
		});
		
		basement = (RelativeLayout)findViewById(R.id.basement);
		basement.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment_dashboard_alertdialog dialog = new Fragment_dashboard_alertdialog().newInstance("PartyGuard");
				dialog.show(getSupportFragmentManager(),"Fragment_dashboard_alertdialog");
			}
		});
		
		deck = (RelativeLayout)findViewById(R.id.deck);
		deck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment_dashboard_alertdialog dialog = new Fragment_dashboard_alertdialog().newInstance("PartyGuard");
				dialog.show(getSupportFragmentManager(),"Fragment_dashboard_alertdialog");
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

//	public Dialog onCreateDialog(int id) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		builder.setTitle("Simple Dialog");
//		builder.setMessage("Some message here");
//
//		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});
//
//		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//			}
//		});
//
//		return builder.create();
//	}

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
                
            case R.id.txt_location:
            	Intent i2 = new Intent(getApplicationContext(), Location.class);
            	startActivity(i2);
                break; 
                
            case R.id.txt_settings:
            	Intent i3 = new Intent(getApplicationContext(), Settings.class);
            	startActivity(i3);
                break; 
		
            case R.id.txt_signout:
				mDrawerLayout.closeDrawer(mDrawerList);
				Dashboard_unsafe.this.finish();
				startActivity(new Intent(Dashboard_unsafe.this, LoginActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
								| Intent.FLAG_ACTIVITY_CLEAR_TASK));
				break;
	}
	}

	
}
