package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FocalLenghtRatioCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focal_length_ratio_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.focal_calc_title);
        }
    }
}