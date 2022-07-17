package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FieldOfViewCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_of_view_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.field_of_view_calc_title);
        }
    }
}