package com.example.s525351.androidsample1;

import android.database.Cursor;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Host_Alert extends ActionBarActivity implements OnClickListener {
	RelativeLayout rel_pgteam,rel_history,rel_profile;
	LinearLayout linearLayout1;

	ListView vendor_list;
	ArrayList<String> vendor_names=new ArrayList<String>();
	RecipentDataBase db=new RecipentDataBase(this);
	Cursor c;
	
	public RelativeLayout mDrawerList;
	public DrawerLayout mDrawerLayout;
	ImageView img_left_menu, img_edit;
	
	TextView txt_home, txt_log, txt_location, txt_settings,txt_signout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_host__alert);

		Button sample = (Button) findViewById(R.id.sampleBtn);
		sample.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


     			db.open();
				c=db.getVendorDetails();
				for(int i=0;i<c.getCount();i++)
				{
					c.moveToPosition(i);
					vendor_names.add(c.getString(0));
					Toast.makeText(getApplicationContext(),c.getString(0), Toast.LENGTH_LONG).show();
				}



			}
		});


		final ArrayAdapter<String> vendor_adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				vendor_names);
		vendor_list=(ListView)findViewById(R.id.listView);
		vendor_list.setAdapter(vendor_adapter);



//		vendor_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
//			{
//
//
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(),(CharSequence) vendor_list.getItemAtPosition(position), Toast.LENGTH_LONG).show();
//
//
//
//
//				c.moveToFirst();
//				for(int i=0;i<vendor_names.size();i++)
//				{
//
//					if(vendor_names.get(i).equals(vendor_list.getItemAtPosition(position)))
//					{
//
//						Toast.makeText(getApplicationContext(),"number:", Toast.LENGTH_LONG).show();
//
//					}
//					c.moveToNext();
//				}
//
//				c.moveToPrevious();
//
//
//
//			}
//		});






		img_edit = (ImageView)findViewById(R.id.img_edit);
		img_edit.setOnClickListener(new OnClickListener() {
 			@Override
 			public void onClick(View v) {
 				//Intent i = new Intent(getApplicationContext(), Host_Signup.class);
 				//startActivity(i);
 				
 			}
 		});
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);
		img_left_menu = (ImageView)findViewById(R.id.img_left_menu);
		img_left_menu.setOnClickListener(this);
		
		linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		linearLayout1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Host_alert_sub.class);
 				startActivity(i);
			}
		});
		
		
	
	
		rel_pgteam = (RelativeLayout)findViewById(R.id.rel_pgteam);
		rel_pgteam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Host_Dashboard.class);
 				startActivity(i);
			}
		});
		
		rel_history = (RelativeLayout)findViewById(R.id.rel_history1);
		rel_history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i = new Intent(getApplicationContext(), Host_History.class);
 				//startActivity(i);
			}
		});
		
		rel_profile = (RelativeLayout)findViewById(R.id.rel_profile);
		rel_profile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i = new Intent(getApplicationContext(), Host_Signup.class);
 				//startActivity(i);
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
                
            //case R.id.txt_log:
            //	Intent i1 = new Intent(getApplicationContext(), Log.class);
            	//startActivity(i1);
             //   break;
                
         //   case R.id.txt_location:
           /// 	Intent i2 = new Intent(getApplicationContext(), Location.class);
            //	startActivity(i2);
              //  break;
                
            case R.id.txt_settings:
            	Intent i3 = new Intent(getApplicationContext(), Settings.class);
            	startActivity(i3);
                break;
		
        //    case R.id.txt_signout:
		//////		mDrawerLayout.closeDrawer(mDrawerList);
			//	Host_Alert.this.finish();
			//	startActivity(new Intent(Host_Alert.this, Login.class)
			//			.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
			//					| Intent.FLAG_ACTIVITY_CLEAR_TASK));
			//	break;
	}
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), Host_Dashboard.class);
		startActivity(intent);
	}
}
