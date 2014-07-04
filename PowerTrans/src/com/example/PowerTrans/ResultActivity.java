package com.example.PowerTrans;

import PTE.PowerTransformer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends FragmentActivity {

    public LayoutInflater lInflater;
    public ResultFragment resultFragment;
    public PowerTransformer pt;
    final String LOG_TAG = "myLogs";

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        pt = (PowerTransformer) i.getSerializableExtra("PowerTransformer");
        lInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (savedInstanceState != null) {
            resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
        }

       /*
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        // Set the text view as the activity layout
        setContentView(textView);
        */
    }

    protected void onResume() {
        super.onResume();
        resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);
        resultFragment.display(pt);
        Log.d(LOG_TAG, "result fragment On resume");

    }

    public void ResultFragment_Click(View view) {
        Log.d(LOG_TAG, "MainFragment fragment click");
        resultFragment.Click(view);
    }
}