package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FocalLenghtRatioCalc extends AppCompatActivity {

    EditText
            etAperture1,
            etFocalRatio,
            etFocalLength,
            etAperture2;
    TextView
            etFocalLengthRatioResult,
            etFocalRatioResult;
    Button
            btnFocalLength,
            btnFocalRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focal_length_ratio_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.focal_calc_title);
        }

        etAperture1 = findViewById(R.id.et_aperture1);
        etFocalRatio = findViewById(R.id.et_focal_ratio);
        etFocalLength = findViewById(R.id.et_focal_length);
        etAperture2 = findViewById(R.id.et_aperture2);

        etFocalLengthRatioResult = findViewById(R.id.et_focal_length_result);
        etFocalRatioResult = findViewById(R.id.et_focal_ratio_result);

        btnFocalLength = findViewById(R.id.btn_focal_length);
        btnFocalRatio = findViewById(R.id.btn_focal_ratio);

        DecimalFormat decimal = new DecimalFormat("#.##");
        decimal.setRoundingMode(RoundingMode.HALF_EVEN);

        btnFocalLength.setOnClickListener(view -> {
            if (SUtils.isEmpty(etAperture1)) {
                SUtils.setToast(etAperture1, "This field cannot be blank!");
            } if (SUtils.isEmpty(etFocalRatio)) {
                SUtils.setToast(etFocalRatio, "This field cannot be blank!");
            } else {
                float aperture = SUtils.getInteger(etAperture1);
                float focalRatio = SUtils.getInteger(etFocalRatio);
                float focalLength = aperture * focalRatio;
                etFocalLengthRatioResult.setText(decimal.format(focalLength));
            }
        });

        btnFocalRatio.setOnClickListener(view -> {
            if (SUtils.isEmpty(etFocalLength)) {
                SUtils.setToast(etFocalLength, "This field cannot be blank!");
            } else if (SUtils.isEmpty(etAperture2)) {
                SUtils.setToast(etAperture2, "This field cannot be blank!");
            } else {
                float focalLength = SUtils.getInteger(etFocalLength);
                float aperture = SUtils.getInteger(etAperture2);
                float focalRatio = focalLength / aperture;
                etFocalRatioResult.setText(decimal.format(focalRatio));
            }
        });
    }
}

