package com.example.PowerTrans;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


public class ResultActivity extends FragmentActivity {

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        // Set the text view as the activity layout
        setContentView(textView);
    }

}