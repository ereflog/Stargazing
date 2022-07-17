package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RedLightTool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_light_tool);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.red_light_tool_title);
        }
    }
}