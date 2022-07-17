package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CCDTelescopeCombinationCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_telescope_combination_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_telescope_combination_calc_title);
        }
    }
}