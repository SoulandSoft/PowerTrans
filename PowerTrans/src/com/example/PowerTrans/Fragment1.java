package com.example.PowerTrans;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.app.Fragment;



public class Fragment1 extends Fragment {

    final String LOG_TAG = "myLogs";
    View rootView;
    LinearLayout lLayout;


    public void remove_wire(View view){
        LinearLayout fl=(LinearLayout) view.getParent();
        LinearLayout ll=(LinearLayout) fl.getParent();
        ll.removeViewAt(ll.indexOfChild(fl));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lLayout = (LinearLayout)inflater.inflate(R.layout.fragment,null);
        return lLayout;
    }

 }