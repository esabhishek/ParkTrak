package com.example.parktrak;



import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainPage extends Activity {

	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		  @Override
		  public void onReceive(Context context, Intent intent) {
		    // Get extra data included in the Intent
		    String message = intent.getStringExtra("message");
		    Log.d("receiver", "Got message: " + message);
		    
			/*EditText edittext;
			
			edittext = (EditText) findViewById(R.id.editText1);
			edittext.setText(message);*/
		  }
			

		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_page, menu);
		
		  // Register to receive messages.
		  // We are registering an observer (mMessageReceiver) to receive Intents
		  // with actions named "custom-event-name".
		  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
		      new IntentFilter("update-received"));
		
		return true;
	}

}
