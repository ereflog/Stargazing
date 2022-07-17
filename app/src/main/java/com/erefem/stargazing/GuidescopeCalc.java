package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GuidescopeCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidescope_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.guidescope_calc_title);
        }
    }
}