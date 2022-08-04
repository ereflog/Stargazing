package com.erefem.stargazing;

import android.widget.EditText;
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
    public static Boolean isEmpty(EditText editTxt){
        return editTxt.getText().toString().isEmpty();
    }

    public static void setToast(EditText editTxt, String string){
        editTxt.requestFocus();
        editTxt.setError(string);
    }




}
