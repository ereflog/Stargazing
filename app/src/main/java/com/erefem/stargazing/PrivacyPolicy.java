package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.privacy_policy_title);
        }
    }
}