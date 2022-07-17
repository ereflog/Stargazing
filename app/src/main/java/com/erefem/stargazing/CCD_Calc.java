package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CCD_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_calc_title);
        }
    }
}