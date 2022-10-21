package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TelescopeCapabilities extends AppCompatActivity {

    EditText
            etTeleApertureDawes, etTeleApertureRayleigh, etTeleApertureLimitingMag, etLargerTeleAperture, etSmallerTeleAperture;
    TextView
            etMaxResolutionDawes, etMaxResolutionRayleigh, etLimitMagnitude, etLightGraspRatio;
    Button
            btnDawes, btnRayleigh, btnLimitingMag, btnLightGraspRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telescope_capabilities);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.telescope_capabilities_calc_title);
        }

        //EditText for input field
        etTeleApertureDawes = findViewById(R.id.et_tele_aperture_dawes);
        etTeleApertureRayleigh = findViewById(R.id.et_tele_aperture_rayleigh);
        etTeleApertureLimitingMag = findViewById(R.id.et_tele_aperture_limiting_mag);
        etLargerTeleAperture = findViewById(R.id.et_larger_tele_aperture);
        etSmallerTeleAperture = findViewById(R.id.et_smaller_tele_aperture);

        //EditText for result
        etMaxResolutionDawes = findViewById(R.id.et_max_resolution_dawes);
        etMaxResolutionRayleigh = findViewById(R.id.et_max_resolution_rayleigh);
        etLimitMagnitude = findViewById(R.id.et_limit_magnitude);
        etLightGraspRatio = findViewById(R.id.et_light_grasp_ratio);

        //Buttons
        btnDawes = findViewById(R.id.btn_dawes);
        btnRayleigh = findViewById(R.id.btn_rayleigh);
        btnLimitingMag = findViewById(R.id.btn_limiting_mag);
        btnLightGraspRatio = findViewById(R.id.btn_light_grasp_ratio);

        //Decimal rounding format
        DecimalFormat decimal = new DecimalFormat("#.##");
        decimal.setRoundingMode(RoundingMode.HALF_EVEN);

        btnDawes.setOnClickListener(view -> {
            if (SUtils.isEmpty(etTeleApertureDawes)) {
                SUtils.setToast(etTeleApertureDawes,"This field cannot be blank!");
            } else {
                float telescopeAperture = SUtils.getFloat(etTeleApertureDawes);
                float maxResolutionDawes = (float) (116 / telescopeAperture);
                etMaxResolutionDawes.setText(decimal.format(maxResolutionDawes));
            }
        });

        btnRayleigh.setOnClickListener(view -> {
            if (SUtils.isEmpty(etTeleApertureRayleigh)) {
                SUtils.setToast(etTeleApertureRayleigh,"This field cannot be blank!");
            } else {
                float teleApertureRayleigh = SUtils.getFloat(etTeleApertureRayleigh);
                float maxResolutionRayleigh = (float) (138 / teleApertureRayleigh);
                etMaxResolutionRayleigh.setText(decimal.format(maxResolutionRayleigh));
            }
        });

        btnLimitingMag.setOnClickListener(view -> {
            if (SUtils.isEmpty(etTeleApertureLimitingMag)) {
                SUtils.setToast(etTeleApertureLimitingMag,"This field cannot be blank!");
            } else {
                float telescopeAperture = SUtils.getFloat(etTeleApertureLimitingMag);
                float var1 = telescopeAperture / 10;
                float var2 = (float) (5 * (Math.log(var1))/2.302);
                float limitingMagnitude = (float) 7.7 + var2;
                etLimitMagnitude.setText(decimal.format(limitingMagnitude));
            }
        });

        btnLightGraspRatio.setOnClickListener(view -> {
            if (SUtils.isEmpty(etLargerTeleAperture)) {
                SUtils.setToast(etLargerTeleAperture,"This field cannot be blank!");
            } else if (SUtils.isEmpty(etSmallerTeleAperture)) {
                SUtils.setToast(etSmallerTeleAperture,"This field cannot be blank!");
            } else {
                float largerTeleAperture = SUtils.getFloat(etLargerTeleAperture);
                float smallerTeleAperture = SUtils.getFloat(etSmallerTeleAperture);
                float var1 = (float) Math.pow(largerTeleAperture, 2);
                float var2 = (float) Math.pow(smallerTeleAperture, 2);
                float lightGraspRatio = (float) (var1 / var2);
                etLightGraspRatio.setText(decimal.format(lightGraspRatio));
            }
        });
    }
}
