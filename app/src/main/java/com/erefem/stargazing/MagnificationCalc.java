package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MagnificationCalc extends AppCompatActivity {

    EditText
            ettfl,
            etefl, ettfl2, etta, etmag2;
    TextView
            tvmag, tvefl;
    Button
            btnmag, btneyepiece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnification_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.magnification_calc_title);
        }

        ettfl = findViewById(R.id.ettfl);
        etefl = findViewById(R.id.etefl);
        ettfl2 = findViewById(R.id.ettfl2);
        etta = findViewById(R.id.etta);
        etmag2 = findViewById(R.id.etmag2);

        tvmag = findViewById(R.id.tvmag);
        tvefl = findViewById(R.id.tvefl);

        btnmag = findViewById(R.id.btnmag);
        btneyepiece = findViewById(R.id.btneyepiece);


        btnmag.setOnClickListener(view -> {

            if (ettfl.getText().toString().isEmpty()) {
                Toast.makeText(MagnificationCalc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etefl.getText().toString().isEmpty()) {
                Toast.makeText(MagnificationCalc.this, "Eyepiece Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                int Telescopefocallength = Integer.valueOf(ettfl.getText().toString());
                int Eyepiecefocallength = Integer.valueOf(etefl.getText().toString());
                int Magnification = Telescopefocallength / Eyepiecefocallength;
                tvmag.setText(String.valueOf(Magnification));
            }
        });

        btneyepiece.setOnClickListener(view -> {

            if (ettfl2.getText().toString().isEmpty()) {
                Toast.makeText(MagnificationCalc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etta.getText().toString().isEmpty()) {
                Toast.makeText(MagnificationCalc.this, "Telescope Aperture is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etmag2.getText().toString().isEmpty()) {
                Toast.makeText(MagnificationCalc.this, "Magnification is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                int Telescopefocallength = Integer.valueOf(ettfl2.getText().toString());
                int Telescopeaperture = Integer.valueOf(etta.getText().toString());
                int Magnification = Integer.valueOf(etmag2.getText().toString());
                int Eyepiece = Telescopefocallength / Magnification;
                tvefl.setText(String.valueOf(Eyepiece));
            }
        });
    }
}