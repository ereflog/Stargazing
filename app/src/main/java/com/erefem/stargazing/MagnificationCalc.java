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

            //if (SUtils.isEmpty(etefl)ettfl.getText().toString().isEmpty()) {
            if (SUtils.isEmpty(ettfl)){
                //Toast.makeText(MagnificationCalc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
                //ettfl.requestFocus();
                //ettfl.setError("Telescope Focal Length is Empty!!!");
                SUtils.setToast(ettfl,"Telescope Focal Length is Empty!!!");
            //} else if (etefl.getText().toString().isEmpty()) {
            } else if (SUtils.isEmpty(etefl)) {
                //Toast.makeText(MagnificationCalc.this, "Eyepiece Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
                SUtils.setToast(ettfl,"Eyepiece Focal Length is Empty!!!");
            } else {
                float Telescopefocallength = SUtils.getInteger(ettfl);
                float Eyepiecefocallength = SUtils.getInteger(etefl);
                float Magnification = Telescopefocallength / Eyepiecefocallength;
                tvmag.setText(String.valueOf(Magnification));
            }
        });

        btneyepiece.setOnClickListener(view -> {

            if (SUtils.isEmpty(ettfl2)) {
                //Toast.makeText(MagnificationCalc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
                SUtils.setToast(ettfl2,"Telescope Focal Length is Empty!!!");
            } else if (SUtils.isEmpty(etta)) {
                //Toast.makeText(MagnificationCalc.this, "Telescope Aperture is Empty!!!", Toast.LENGTH_SHORT).show();
                SUtils.setToast(etta,"Telescope Aperture is Empty!!!");
            } else if (SUtils.isEmpty(etmag2)) {
                //Toast.makeText(MagnificationCalc.this, "Magnification is Empty!!!", Toast.LENGTH_SHORT).show();
                SUtils.setToast(etmag2,"Magnification is Empty!!!");
            } else {
                float Telescopefocallength = SUtils.getInteger(ettfl2);
                float Telescopeaperture = SUtils.getInteger(etta);
                float Magnification = SUtils.getInteger(etmag2);
                float Eyepiece = Telescopefocallength / Magnification;
                tvefl.setText(String.valueOf(Eyepiece));
            }
        });
    }
}