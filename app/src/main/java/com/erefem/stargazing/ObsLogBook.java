package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ObsLogBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.obs_log_book_title);
        }
    }
}