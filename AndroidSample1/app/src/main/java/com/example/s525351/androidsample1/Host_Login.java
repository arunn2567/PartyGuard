package com.example.s525351.androidsample1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Host_Login extends ActionBarActivity {

	Button btn_login1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_host__login);

		btn_login1 = (Button)findViewById(R.id.btn_login);
		btn_login1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Host_Dashboard.class);
				startActivity(i);
			}
		});
	}


}
