package com.erefem.stargazing;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SUtils {

    public final static String SATU="1x1";
    public final static String DUA="2x2";
    public final static String TIGA="3x3";
    public final static String EMPAT="4x4";
    public final static String LIMA="5x5";

    private EditText textView;
    private TextView editTxt;

    @NonNull
    public static Integer getInteger(EditText editTxt){
        return Integer.parseInt(editTxt.getText().toString());
    }

    @NonNull
    public static Double getDouble(EditText editTxt){
        return Double.parseDouble(editTxt.getText().toString());
    }

    @NonNull
    public static Float getFloat(EditText editTxt){
        return Float.parseFloat(editTxt.getText().toString());
    }

    @NonNull
    public static Float getFloatSpinnerValue(Spinner spinner){
        float fl;
        String tspinner = spinner.getSelectedItem().toString();
        if(tspinner.equalsIgnoreCase("none") ) {
            fl = 1.0f;
        }else{
           fl = Float.parseFloat(tspinner);
        }
        return fl;
    }

    @NonNull
    public static Float getBinningSpinnerValue(Spinner spinner){
        float fl;
        String tspinner = spinner.getSelectedItem().toString();
        if(tspinner.equalsIgnoreCase(SATU) ) {
            fl = 1.0f;
        }else if(tspinner.equalsIgnoreCase(DUA)) {
            fl = 2.0f;
        }else if(tspinner.equalsIgnoreCase(TIGA)) {
            fl = 3.0f;
        }else if(tspinner.equalsIgnoreCase(EMPAT)) {
            fl = 4.0f;
        }else if(tspinner.equalsIgnoreCase(LIMA)) {
            fl = 5.0f;
        }else  {
            fl = 0.0f;
        }
        return fl;
    }

    public static Boolean isEmpty(EditText editTxt){
        return editTxt.getText().toString().isEmpty();
    }

    public static void setToast(EditText editTxt, String string){
        editTxt.requestFocus();
        editTxt.setError(string);
    }

}
