package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CCD_FilterSizeCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_filter_size_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_filter_size_calc_title);
        }
    }
}