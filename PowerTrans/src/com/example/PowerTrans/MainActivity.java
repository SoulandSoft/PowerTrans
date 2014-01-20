package com.example.PowerTrans;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.content.Context;


public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.PowerTrans.MESSAGE";
    public LayoutInflater lInflater;
    public Fragment1 myFragment;


    public void add_wire(View view){

    //myFragment = (Fragment1)getFragmentManager().findFragmentById(R.id.myFragment);
    LinearLayout L = (LinearLayout)lInflater.inflate(R.layout.buttons,null);
    //myFragment.add_wire(L);
    LinearLayout In = (LinearLayout)findViewById(R.id.layout2);
        In.addView(L);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        lInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Some changes
		getMenuInflater().inflate(R.menu.main, menu);
    	return true;
	}

    /*
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
     */

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.item2 :
	          //  sendMessage(this.getCurrentFocus());
	            return true;
	      //  case R.id.action_settings:
	        //    openSettings();
	         //   return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
