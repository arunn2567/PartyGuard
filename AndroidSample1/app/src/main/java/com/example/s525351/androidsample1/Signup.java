package com.example.s525351.androidsample1;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Signup extends AppCompatActivity {

	private GoogleApiClient client;
	EditText fname;
	EditText lname;
	EditText email;
	EditText password;
	EditText repass;
	Boolean errorThrown = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		Button signUpCreatAccBtn=(Button)findViewById(R.id.btn_signup);
		fname= (EditText) findViewById(R.id.editText1);
		lname= (EditText) findViewById(R.id.editText2);
		email= (EditText) findViewById(R.id.editText3);
		password= (EditText) findViewById(R.id.editText4);
		repass= (EditText) findViewById(R.id.editText5);

//        signUpCreatAccBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent loginIntent=new Intent(SignUpActivity.this,HowToUseActivity.class);
//                startActivity(loginIntent);
//            }
//        });




		signUpCreatAccBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new HttpAsyncTask().execute("http://partyguardservices20160912122440.azurewebsites.net/api/Account/Register");
				Intent loginIntent = new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(loginIntent);
			}
		});


		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}



	private class HttpAsyncTask extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... urls) {
			return POST(urls[0]);
		}


//        signUPcreateAccountBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent loginIntent = new Intent(getApplicationContext(),LoginActivity.class);
//                startActivity(loginIntent);
//            }
//        });

		public String POST(String url) {
			InputStream inputStream = null;
			String result = "";
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);

				String json = "";
				JSONObject jsonObject = new JSONObject();

				String firstName = fname.getText().toString();
				String lastName = lname.getText().toString();
				String emailID = email.getText().toString();
				String pass = password.getText().toString();
				String repPass = repass.getText().toString();

				jsonObject.put("Email", emailID);
				jsonObject.put("Password", pass);
				jsonObject.put("ConfirmPassword", repPass);

				json = jsonObject.toString();
				StringEntity se = new StringEntity(json);
				httpPost.setEntity(se);

				httpPost.setHeader("accept", "json");
				httpPost.setHeader("Content-type", "application/json");

				HttpResponse httpResponse = httpclient.execute(httpPost);

				inputStream = httpResponse.getEntity().getContent();
				result = convertInputStreamToString(inputStream);
				// convert inputstream to string
				if (result.contains("invalid") == true) {
					errorThrown = true;
					Log.d("PartyGuard", "result" + result);

				} else
					errorThrown = false;
				Log.d("PartyGuard", "inputStream result" + result);

			} catch (Exception e) {
				Log.d("json", "e.getLocalizedMessage()" + e.getLocalizedMessage());
			}

			//  return result
			return result;
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			if(errorThrown == false) {
				Toast.makeText(getBaseContext(), "Registration Successful!", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
			}
		}

	}

	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}
}


