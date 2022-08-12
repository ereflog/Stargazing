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

        btn_dawes.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_tele_aper)) {
                SUtils.setToast(et_tele_aper,"is Empty!!!");
            } else {
                float tele_aperture = Float.parseFloat(et_tele_aper.getText().toString());
                float result_aper =
                        (float) (116 / tele_aperture);
                tv_max_resolution.setText(String.valueOf(result_aper));
            }
        });
        btn_rayleigh.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_tele_ray)) {
                SUtils.setToast(et_tele_ray,"is Empty!!!");
            } else {
                float tele_ray = Float.parseFloat(et_tele_ray.getText().toString());
                float result_ray =
                        (float) (138 / tele_ray);
                tv_max_resolution_aper.setText(String.valueOf(result_ray));
            }
        });
        btn_limiting.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_tele_limit)) {
                SUtils.setToast(et_tele_limit,"is Empty!!!");
            } else {
                float tele_limit = Float.parseFloat(et_tele_limit.getText().toString());
                float var1 = tele_limit / 10;
                float var2 =
                        (float) (5 * (Math.log(var1))/2.302);
                float result_limit =
                        (float) 7.7 + var2;
                tv_max_resolution_limiting.setText(String.valueOf(result_limit));
            }
        });
        btn_light.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_larger_light)) {
                SUtils.setToast(et_larger_light,"is Empty!!!");
            } else if (SUtils.isEmpty(et_smaller_light)) {
                SUtils.setToast(et_smaller_light,"is Empty!!!");
            } else {
                float large_light = Float.parseFloat(et_larger_light.getText().toString());
                float smaller_light = Float.parseFloat(et_smaller_light.getText().toString());

                float var1 = (float) Math.pow(large_light, 2);
                float var2 = (float) Math.pow(smaller_light, 2);

                float result_light =
                        (float) (var1 / var2 );
                tv_max_resolution_light.setText(String.valueOf(result_light));
            }
        });
    }
}
