package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WeatherForecast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_forecast);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.weather_forecast_title);
        }
    }
}