package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.unit_converter_title);
        }
    }
}