package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MagnificationCalc extends AppCompatActivity {

    EditText
            etTelescopeFocalLength1, etEyepieceFocalLength1, etTelescopeFocalLength2,
            etTelescopeAperture, etMagnification2, etMaxMagnification;
    TextView
            etMagnification1, etEyepieceFocalLength2;
    Button
            btnMagnification, btnEyepiece, btnMaxMagnification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnification_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.magnification_calc_title);
        }

        etTelescopeFocalLength1 = findViewById(R.id.et_telescope_focal_length1);
        etEyepieceFocalLength1 = findViewById(R.id.et_eyepiece_focal_length1);
        etMagnification1 = findViewById(R.id.et_magnification1);

        etTelescopeFocalLength2 = findViewById(R.id.et_telescope_focal_length2);
        etMagnification2 = findViewById(R.id.et_magnification2);
        etEyepieceFocalLength2 = findViewById(R.id.et_eyepiece_focal_length2);
        etTelescopeAperture = findViewById(R.id.et_telescope_aperture);

        btnMagnification = findViewById(R.id.btn_magnification);
        btnEyepiece = findViewById(R.id.btn_eyepiece);
        btnMaxMagnification = findViewById(R.id.btn_max_magnification);

        DecimalFormat decimal = new DecimalFormat("#.##");
        decimal.setRoundingMode(RoundingMode.HALF_EVEN);

        btnMagnification.setOnClickListener(view -> {
            if (SUtils.isEmpty(etTelescopeFocalLength1)){
                SUtils.setToast(etTelescopeFocalLength1,"This field cannot be blank!");
            } if (SUtils.isEmpty(etEyepieceFocalLength1)) {
                SUtils.setToast(etEyepieceFocalLength1,"This field cannot be blank!");
            } else {
                float telescopeFocalLength = SUtils.getInteger(etTelescopeFocalLength1);
                float eyepieceFocalLength = SUtils.getInteger(etEyepieceFocalLength1);
                float magnification = telescopeFocalLength / eyepieceFocalLength;
                etMagnification1.setText(decimal.format(magnification));
            }
        });

        btnEyepiece.setOnClickListener(view -> {
            if (SUtils.isEmpty(etTelescopeFocalLength2)) {
                SUtils.setToast(etTelescopeFocalLength2,"This field cannot be blank!");
            } if (SUtils.isEmpty(etTelescopeAperture)) {
                SUtils.setToast(etTelescopeAperture,"This field cannot be blank!");
            } if (SUtils.isEmpty(etMagnification2)) {
                SUtils.setToast(etMagnification2,"This field cannot be blank!");
            } else {
                float telescopeFocalLength = SUtils.getInteger(etTelescopeFocalLength2);
                float magnification = SUtils.getInteger(etMagnification2);
                float eyepieceFocalLength = telescopeFocalLength / magnification;
                etEyepieceFocalLength2.setText(decimal.format(eyepieceFocalLength));
            }
        });

        btnMaxMagnification.setOnClickListener(view -> {
            if (SUtils.isEmpty(etMaxMagnification)) {
                SUtils.setToast(etMaxMagnification, "This field cannot be blank!");
            } else {
                float telescopeAperture = SUtils.getInteger(etTelescopeAperture);
                float maxMagnification = (float) (telescopeAperture * 2.5);
                if (maxMagnification > 350) { maxMagnification = 350; }
                etMaxMagnification.setText(decimal.format(maxMagnification));
            }
        });
    }
}