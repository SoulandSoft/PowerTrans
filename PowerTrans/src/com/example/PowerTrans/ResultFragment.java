package com.example.PowerTrans;

import PTE.Coil;
import PTE.PowerTransformer;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

    // Method, that display formatted data.
    public void display(PowerTransformer pt) {
        for (Coil c : pt.secondaries) {
            Log.d(LOG_TAG, "Output Wire");
            LinearLayout L = (LinearLayout) lInflater.inflate(R.layout.secondary_coil_output, null);
            LinearLayout In = (LinearLayout) lLayout.findViewById(R.id.resultFragment);
            TextView V = (TextView) L.findViewById(R.id.Voltage_output);
            V.setText(" " + c.getVoltage());
            TextView C = (TextView) L.findViewById(R.id.Current_output);
            C.setText(" " + c.getCurrent());
            In.addView(L);
        }


    }
}
