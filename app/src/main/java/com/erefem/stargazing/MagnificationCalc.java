package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MagnificationCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnification_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.magnification_calc_title);
        }
    }
}