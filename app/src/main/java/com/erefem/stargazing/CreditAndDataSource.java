package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CreditAndDataSource extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_and_data_source);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.credit_and_data_source_title);
        }
    }
}