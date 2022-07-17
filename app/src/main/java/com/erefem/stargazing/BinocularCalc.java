package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BinocularCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binocular_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.binocular_calc_title);
        }
    }
}