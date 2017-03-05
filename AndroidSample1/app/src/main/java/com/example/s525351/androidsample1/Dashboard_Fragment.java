package com.example.s525351.androidsample1;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Dashboard_Fragment extends Fragment {
	
	LinearLayout linearLayout1;
	View myView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	 myView = inflater.inflate(R.layout.activity_dashboard__fragment, container, false);
    	 
    	 linearLayout1 = (LinearLayout)myView.findViewById(R.id.linearLayout1);
         
 		linearLayout1.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent i = new Intent(getActivity(), Dashboard_Profile.class);
 				startActivity(i);
 				
 			}
 		});
		return myView;
     
      
   
    
       
    }
  

	
}
