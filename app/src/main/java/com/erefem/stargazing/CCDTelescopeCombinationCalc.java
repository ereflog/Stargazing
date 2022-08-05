package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CCDTelescopeCombinationCalc extends AppCompatActivity {

    EditText
            et_pixel_size, et_focal_lenght;
    TextView
            tv_resolution;

    Button
            btn_resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_telescope_combination_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_telescope_combination_calc_title);
        }
        et_pixel_size = findViewById(R.id.et_pixel_size);
        et_focal_lenght = findViewById(R.id.et_focal_lenght);

        tv_resolution = findViewById(R.id.tv_resolution);

        btn_resolution = findViewById(R.id.btn_resolution);

        btn_resolution.setOnClickListener(view -> {

            if (SUtils.isEmpty(et_pixel_size)) {
                SUtils.setToast(et_pixel_size,"is Empty!!!");
            } else if (SUtils.isEmpty(et_focal_lenght)) {
                SUtils.setToast(et_focal_lenght,"is Empty!!!");
            } else {
                float Pixel_size = Float.parseFloat(et_pixel_size.getText().toString());
                float Focal_lenght = Integer.parseInt(et_focal_lenght.getText().toString());
                float Resolution =
                        (float) (Pixel_size / Focal_lenght * 206.265);
                tv_resolution.setText(String.valueOf(Resolution));
            }
        });
    }
}