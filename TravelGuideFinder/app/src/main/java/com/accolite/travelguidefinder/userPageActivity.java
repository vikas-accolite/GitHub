package com.accolite.travelguidefinder;

import java.io.InputStream;

import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.R.*;

import java.util.List;

import com.accolite.connect.CityList;



public class userPageActivity extends Activity {
	 String msg = "Android : ";
	String[] city1={"bangalore","delhi","pune","goa","elhi","elha","della","delha"};
	private ListView cityView;
	private AutoCompleteTextView cityView1;
	private ArrayAdapter itemArrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomeuser);
		InputStream inputStream = getResources().openRawResource(R.raw.indiacity);
		CityList cityList = new CityList(inputStream);
		String[] scoreList = cityList.read();
		//Log.d(toString()," $$$$$ "+scoreList.toString());
//		String[] city2=new String[100];
//		for (int i = 0; i < scoreList.size(); i++) {
//			city2[i] = scoreList.get(i).toString();
//			Log.d(toString(), city2[i]);
	//	}

		cityView1=(AutoCompleteTextView)findViewById(R.id.searchCityView);
		ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,scoreList);
//		for(String[] scoreData:scoreList ) {
//			adapter.add(scoreData);
//		}
		cityView1.setAdapter(adapter);
		cityView1.setThreshold(1);

		//cityView = (ListView) findViewById(R.id.listView);
		//itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);


		Log.d(msg, "The onCreate() User page2");
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
