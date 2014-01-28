package com.example.PowerTrans;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	public final static String EXTRA_MESSAGE = "com.example.PowerTrans.MESSAGE";
    public LayoutInflater lInflater;
    public Fragment1 myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        lInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Fragment1 fragment;
        if (savedInstanceState != null) {
        fragment = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.myFragment);
    }
     /*   else {
        fragment = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.layout1, fragment).commit();
        }
        */
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
