package com.erefem.stargazing;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SUtils {
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

    public static Boolean isEmpty(EditText editTxt){
        return editTxt.getText().toString().isEmpty();
    }

    public static void setToast(EditText editTxt, String string){
        editTxt.requestFocus();
        editTxt.setError(string);
    }

}
