package com.accolite.travelguidefinder;

import javax.security.auth.DestroyFailedException;

import com.accolite.connect.ServiceActivity;

import android.R.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	 String msg = "Android : ";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button loginBtn=(Button)findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ServiceActivity serviceAct=new ServiceActivity();
				String uid=((TextView) findViewById(R.id.loginId)).getText().toString();
				String paswd=((TextView) findViewById(R.id.password)).getText().toString();
				Intent intent=new Intent(MainActivity.this,userPageActivity.class);
				intent.putExtra("usserId", uid);
				 intent.putExtra("password", paswd);
				 startActivity(intent);
				if(serviceAct.loginCheck(uid,paswd)){
					startActivity(intent);
				}else {
					Intent loginStart=new Intent(getApplicationContext(),MainActivity.class);
					startActivity(loginStart);
					String displayLogin="Login credentials not valid";
					Toast msg = Toast.makeText(getBaseContext(), displayLogin,
							Toast.LENGTH_LONG);
							msg.show();
				};
				
			}
		});
		Log.d(msg, "The onCreate() event");
	}
	
	 @Override
	   protected void onStart() {
	      super.onStart();
	      Log.d(msg, "The onStart() event");
	   }

	   /** Called when the activity has become visible. */
	   @Override
	   protected void onResume() {
	      super.onResume();
	    
	      Log.d(msg, "The onResume() event");
	   }
	   protected void onRestart(){
		      super.onRestart();
		    System.exit(1);
		      Log.d(msg, "The onResume() event");
		   }

	   /** Called when another activity is taking focus. */
	   @Override
	   protected void onPause() {
	      super.onPause();
	      Log.d(msg, "The onPause() event");
	   }

	   /** Called when the activity is no longer visible. */
	   @Override
	   protected void onStop() {
	      super.onStop();
	      Log.d(msg, "The onStop() event");
	   }

	   /** Called just before the activity is destroyed. */
	   @Override
	   public void onDestroy() {
	      super.onDestroy();
	      Log.d(msg, "The onDestroy() event");
	   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
