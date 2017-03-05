package com.example.s525351.androidsample1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity {
Button btn_login,btn_signup;
	TextView txt_host;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_login);
		
		
		
		btn_login = (Button)findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Login_IntroSlider.class);
				startActivity(i);
			}
		});
		
		btn_signup = (Button)findViewById(R.id.btn_signup);
		btn_signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Signup.class);
				startActivity(i);


			}
		});


		
		txt_host = (TextView)findViewById(R.id.txt_host);
		txt_host.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Host_Login.class);
				startActivity(i);
			}
		});
	}


}

