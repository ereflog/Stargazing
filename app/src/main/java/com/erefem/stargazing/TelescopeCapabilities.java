package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelescopeCapabilities extends AppCompatActivity {

    EditText
            et_tele_aper, et_tele_ray,et_tele_limit,et_larger_light,et_smaller_light;
    TextView
            tv_max_resolution,tv_max_resolution_aper,tv_max_resolution_limiting,tv_max_resolution_light;
    Button
            btn_dawes,btn_rayleigh,btn_limiting,btn_light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telescope_capabilities);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.telescope_capabilities_calc_title);
        }

        et_tele_aper = findViewById(R.id.et_tele_aper);
        et_tele_ray = findViewById(R.id.et_tele_ray);
        et_tele_limit = findViewById(R.id.et_tele_limit);
        et_larger_light = findViewById(R.id.et_larger_light);
        et_smaller_light = findViewById(R.id.et_smaller_light);


        tv_max_resolution = findViewById(R.id.tv_max_resolution);
        tv_max_resolution_aper = findViewById(R.id.tv_max_resolution_aper);
        tv_max_resolution_limiting = findViewById(R.id.tv_max_resolution_limiting);
        tv_max_resolution_light = findViewById(R.id.tv_max_resolution_light);


        btn_dawes = findViewById(R.id.btn_dawes);
        btn_rayleigh = findViewById(R.id.btn_rayleigh);
        btn_limiting = findViewById(R.id.btn_limiting);
        btn_light = findViewById(R.id.btn_light);
    }
    }
