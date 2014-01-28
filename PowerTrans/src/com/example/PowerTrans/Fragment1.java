package com.example.PowerTrans;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class Fragment1 extends Fragment implements OnClickListener{

    final String LOG_TAG = "myLogs";
    public LinearLayout lLayout;
    public LayoutInflater lInflater;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lInflater = inflater;
        lLayout = (LinearLayout)inflater.inflate(R.layout.fragment,null);
       Button add = (Button) lLayout.findViewById(R.id.Add_button);
        add.setOnClickListener(this);
       // Button remove = (Button)getView().findViewById(R.id.Remove_button);
       // remove.setOnClickListener(this);

        return lLayout;
    }

    @Override
    public void onClick(View v){
    switch (v.getId()) {
        case R.id.Add_button:
            add_wire(v);
            break;
        case R.id.Remove_button:
            remove_wire(v);
            break;
        }
    }

    public void add_wire(View view){
    Log.d(LOG_TAG, "Add Wire");
    LinearLayout L = (LinearLayout)lInflater.inflate(R.layout.buttons,null);
    LinearLayout In = (LinearLayout)lLayout.findViewById(R.id.layout2);
    In.addView(L);
    }

    public void remove_wire(View view){
        Log.d(LOG_TAG, "Remove Wire");
        //LinearLayout fl=(LinearLayout) view.getParent();
        //LinearLayout ll=(LinearLayout) fl.getParent();
        //ll.removeViewAt(ll.indexOfChild(fl));
    }
 }