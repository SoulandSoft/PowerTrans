package com.example.PowerTrans;

import PTE.PowerTransformer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainFragment extends Fragment {

    public final static String EXTRA_MESSAGE = "com.example.PowerTrans.MESSAGE";
    final String LOG_TAG = "myLogs";
    public LinearLayout lLayout;
    public LayoutInflater lInflater;
    public PowerTransformer Pt;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pt = new PowerTransformer();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lInflater = inflater;
        lLayout = (LinearLayout) inflater.inflate(R.layout.fragment_main, null);
        return lLayout;
    }

    //Handling section

    // main handling switcher
    public void Click(View v) {

        switch (v.getId()) {
            case R.id.Add_button:
                add_wire(v);
                break;
            case R.id.Remove_button:
                Log.d(LOG_TAG, "Remove Wire switch");
                remove_wire(v);
                break;
            case R.id.Calculate_button:
                Log.d(LOG_TAG, "Calculate");
                calculate();
                break;
        }
    }

    public void getResult() {
        Intent intent = new Intent(getActivity().getApplicationContext(), ResultActivity.class);
        intent.putExtra("PowerTransformer", Pt);
        startActivity(intent);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        // send :
        // intent.putExtra("PowerTransformer", Pt);
        // recieve
        // Intent i = getIntent();
        // PowerTeansformer pt = (PowerTransformer)i.getSerializableExtra("PowerTransformer");

    }

    // Custom handling methods
    public void add_wire(View view) {
        Log.d(LOG_TAG, "Add Wire");
        LinearLayout L = (LinearLayout) lInflater.inflate(R.layout.secondary_coil_input, null);
        LinearLayout In = (LinearLayout) lLayout.findViewById(R.id.MainControls);
        In.addView(L);
        Pt.add_secondary();

    }

    public void remove_wire(View view) {
        Log.d(LOG_TAG, "Remove Wire");
        LinearLayout fl = (LinearLayout) view.getParent();
        LinearLayout ll = (LinearLayout) fl.getParent();
        int ind = ll.indexOfChild(fl);

        Pt.remove_secondary(ind - 3);
        ll.removeViewAt(ind);
    }

    public void calculate() {

        submit();
        Pt.calculate();
        Log.d(LOG_TAG, "Sst * Sok = " + Pt.calc_min_SstSok());
        Log.d(LOG_TAG, "Power = " + Pt.get_Power());
        Log.d(LOG_TAG, "Kpd = " + Pt.get_kpd());
        getResult();

    }

    public void submit() {

        // get Transformer type from spinner
        Spinner S = (Spinner) lLayout.findViewById(R.id.TypeSpinner);
        Pt.setCore(S.getSelectedItemPosition());
        // Sok
        EditText E = (EditText) lLayout.findViewById(R.id.AB_input);
        Pt.set_Sok(Double.parseDouble(E.getText().toString()));
        // Sst
        E = (EditText) lLayout.findViewById(R.id.CD_input);
        Pt.set_Sst(Double.parseDouble(E.getText().toString()));

        // Primary Voltage
        E = (EditText) lLayout.findViewById(R.id.PrimaryVoltage_input);
        Pt.primary.setVoltage(Double.parseDouble(E.getText().toString()));

        //Get secondaries
        LinearLayout L = (LinearLayout) lLayout.findViewById(R.id.MainControls);
        int c = L.getChildCount();
        if (c > 3) {
            for (int i = 3; i < c; i++) {
                E = (EditText) L.getChildAt(i).findViewById(R.id.Current_input);
                Pt.secondaries.get(i - 3).setCurrent(Double.parseDouble(E.getText().toString()));
                E = (EditText) L.getChildAt(i).findViewById(R.id.Voltage_input);
                Pt.secondaries.get(i - 3).setVoltage(Double.parseDouble(E.getText().toString()));
                Log.d(LOG_TAG, "Secondary add layout " + (i - 3));
            }
        } else Log.d(LOG_TAG, "No secondaries!!");

    }

}