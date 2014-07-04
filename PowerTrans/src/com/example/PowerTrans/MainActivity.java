package com.example.PowerTrans;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {


    public LayoutInflater lInflater;
    public MainFragment mainFragment;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (savedInstanceState != null) {
            mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        }
        // else {
        // myFragment = new MainFragment();
        // getSupportFragmentManager().beginTransaction().add(R.id.layout1, myFragment).commit();
        // }

    }

    protected void onResume() {
        super.onResume();
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        Log.d(LOG_TAG, "On resume");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Some changes
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.item2:
                //  sendMessage(this.getCurrentFocus());
                return true;
            //  case R.id.action_settings:
            //    openSettings();
            //   return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Click(View view) {
        Log.d(LOG_TAG, "MainFragment fragment click");
        mainFragment.Click(view);
    }


}
