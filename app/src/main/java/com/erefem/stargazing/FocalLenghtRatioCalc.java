package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FocalLenghtRatioCalc extends AppCompatActivity {

    EditText
            etapertur,
            etfocalratio,
            etfocallenght,
            etaperturratio;
    TextView
            tvfocallenght,
            tvfocalrasio;
    Button
            btnfl,
            btnfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focal_length_ratio_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.focal_calc_title);
        }

        etapertur = findViewById(R.id.etapertur);
        etfocalratio = findViewById(R.id.etfocalratio);
        etfocallenght = findViewById(R.id.etfocallenght);
        etaperturratio = findViewById(R.id.etaperturratio);

        tvfocallenght = findViewById(R.id.tvfocallenght);
        tvfocalrasio = findViewById(R.id.tvfocalrasio);

        btnfl = findViewById(R.id.btnfl);
        btnfr = findViewById(R.id.btnfr);

        btnfl.setOnClickListener(view -> {

            if (etapertur.getText().toString().isEmpty()) {
                Toast.makeText(FocalLenghtRatioCalc.this, "Aperture is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etfocalratio.getText().toString().isEmpty()) {
                Toast.makeText(FocalLenghtRatioCalc.this, "Focal Ratio is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float Aperture = Integer.parseInt(etapertur.getText().toString());
                float Focalratio = Integer.parseInt(etfocalratio.getText().toString());
                float Focallenght = Aperture * Focalratio;
                tvfocallenght.setText(String.valueOf(Focallenght));
            }
        });

        btnfr.setOnClickListener(view -> {

            if (etfocallenght.getText().toString().isEmpty()) {
                Toast.makeText(FocalLenghtRatioCalc.this, "Focal Lenght is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etaperturratio.getText().toString().isEmpty()) {
                Toast.makeText(FocalLenghtRatioCalc.this, "Aperture is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                //float Focallenght = Integer.parseInt(etfocallenght.getText().toString());
                float Focallenght =SUtils.getInteger(etfocallenght);
                //float Apertureratio = Integer.parseInt(etaperturratio.getText().toString());
                float Apertureratio=SUtils.getInteger(etaperturratio);
                float Focalratio = Focallenght / Apertureratio;
                tvfocalrasio.setText(String.valueOf(Focalratio));
            }
        });
    }
}

