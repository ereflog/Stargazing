package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TelescopeCapabilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telescope_capabilities);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.telescope_capabilities_calc_title);
        }
    }
}