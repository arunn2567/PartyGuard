package com.example.s525351.androidsample1;


import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Host_alert_sub extends ActionBarActivity {
	RelativeLayout rel_pgteam,rel_history,rel_profile;
	ImageView img_back;
	Button btn_claim, btn_resolve;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_host_alert_sub);
		
		img_back = (ImageView)findViewById(R.id.img_back);
		img_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Host_Alert.class);
				startActivity(i);
			}
		});
		
		btn_claim = (Button)findViewById(R.id.btn_claim);
		btn_claim.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(Host_alert_sub.this);
				builder.setTitle("Party Guard");
				builder.setMessage("Are You Sure?");
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//finish();
						//startActivity(new Intent(Host_alert_sub.this, Farmer.class));
					}
				});
				builder.show();
			}
		});   
		
		btn_resolve = (Button)findViewById(R.id.btn_resolve);
		btn_resolve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(Host_alert_sub.this);
				builder.setTitle("Party Guard");
				builder.setMessage("A resolution confirmation has been sent");
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//finish();

					}
				});
				builder.show();
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
//				Intent i = new Intent(getApplicationContext(), );
// 				startActivity(i);
			}
		});
		
		rel_profile = (RelativeLayout)findViewById(R.id.rel_profile);
		rel_profile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent i = new Intent(getApplicationContext(), Host_Signup.class);
// 				startActivity(i);
			}
		});
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), Host_Dashboard.class);
		startActivity(intent);
	}
}
