package com.example.PowerTrans;

import PTE.PowerTransformer;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultFragment extends Fragment {
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
        lLayout = (LinearLayout) inflater.inflate(R.layout.fragment_result, null);
        return lLayout;
    }

    // Click Handler
    public void Click(View view) {
    }

    public void display(PowerTransformer pt) {
        TextView T = (TextView) lLayout.findViewById(R.id.textView1);
        T.setText("Power is " + pt.get_Power());

    }
}
