package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FieldOfViewCalc extends AppCompatActivity {

    EditText
            etEyepieceFOV,
            etEyepieceFocalLength,
            etTelescopeFocalLength;
    TextView
            etActualFOV;
    Button
            btnTrueFOV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_of_view_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.field_of_view_calc_title);
        }
        etEyepieceFOV = findViewById(R.id.et_eyepiece_fov);
        etEyepieceFocalLength = findViewById(R.id.et_eyepiece_focal_length1);
        etTelescopeFocalLength = findViewById(R.id.et_telescope_focal_length1);

        etActualFOV = findViewById(R.id.et_actual_fov);

        btnTrueFOV = findViewById(R.id.btn_true_fov);

        DecimalFormat decimal = new DecimalFormat("#.##");
        decimal.setRoundingMode(RoundingMode.HALF_EVEN);

        btnTrueFOV.setOnClickListener(view -> {

            if (SUtils.isEmpty(etEyepieceFOV)) {
                SUtils.setToast(etEyepieceFOV,"This field cannot be blank!");
            } if (SUtils.isEmpty(etEyepieceFocalLength)) {
                SUtils.setToast(etEyepieceFocalLength,"This field cannot be blank!");
            } if (SUtils.isEmpty(etTelescopeFocalLength)) {
                SUtils.setToast(etTelescopeFocalLength, "This field cannot be blank!");
            } else {
                float eyepieceFOV = SUtils.getInteger(etEyepieceFOV);
                float eyepieceFocalLength = SUtils.getInteger(etEyepieceFocalLength);
                float telescopeFocalLength = SUtils.getInteger(etTelescopeFocalLength);
                float actualFOV = eyepieceFOV / (eyepieceFocalLength / telescopeFocalLength);
                etActualFOV.setText(decimal.format(actualFOV));
            }
        });
    }
}