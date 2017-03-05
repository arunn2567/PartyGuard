package com.example.s525351.androidsample1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment_dashboard_alertdialog extends DialogFragment {
	private Button btnSubmit, btncancel;
    private EditText mEditText;


	public static int ref_id;
    
    public interface Fragment_dashboard_alertdialogListener {
        void onFinishEditDialog(String inputText);
    }

	public static Fragment_dashboard_alertdialog newInstance(String title) {
		Fragment_dashboard_alertdialog frag = new Fragment_dashboard_alertdialog();
	        Bundle args = new Bundle();
	        args.putString("title", title);
	        frag.setArguments(args);
	        return frag;
	}
    
	  
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        final View view = inflater.inflate(R.layout.activity_fragment_dashboard_alertdialog, container, false);
			getDialog().setTitle("Simple Dialog");
	        mEditText = (EditText) view.findViewById(R.id.txt_your_name);



	        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
	        btnSubmit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
//					Fragment_dashboard_alertdialogListener listener = (Fragment_dashboard_alertdialogListener);
//		            listener.onFinishEditDialog(mEditText.getText().toString());

					RecipentDataBase db=new RecipentDataBase(getActivity());
					Cursor chek_vendor;

					db.open();
					//getting vendor details to check previously there or not in database
					chek_vendor=db.getVendorDetails();
					chek_vendor.moveToFirst();

					if(chek_vendor.getCount()==0)
					{
						ref_id=01;

					}
					else
					{
						chek_vendor.moveToPosition(chek_vendor.getCount());
						ref_id=chek_vendor.getCount()+1;
					}

					long inserted=db.insertVendorDetails(mEditText.getText().toString());
					Toast.makeText(getActivity(),"Successfully Inserted into database "+ mEditText.getText().toString() ,Toast.LENGTH_LONG).show();

					//db.close();

					Intent intent = new Intent(getActivity().getBaseContext(), Dashboard_unsafe.class);
					startActivity(intent);



				}
			});
	        
	        
	        btncancel = (Button) view.findViewById(R.id.btncancel);
	        btncancel.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
//					Fragment_dashboard_alertdialogListener listener = (Fragment_dashboard_alertdialogListener) getActivity();
//		            listener.onFinishEditDialog(mEditText.getText().toString());
//		            dismiss();

					Intent intent = new Intent(getActivity().getBaseContext(), Dashboard_unsafe.class);
					startActivity(intent);
				}
			});
	        
	        String title = getArguments().getString("title", "Enter Name");
	        getDialog().setTitle(title);
	        // Show soft keyboard automatically
	        mEditText.requestFocus();
	        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
	        return view;
	    }
	}
