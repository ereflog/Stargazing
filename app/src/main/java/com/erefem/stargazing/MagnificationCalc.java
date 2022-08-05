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
            if (SUtils.isEmpty(ettfl)){
                SUtils.setToast(ettfl,"is Empty!!!");
            } else if (SUtils.isEmpty(etefl)) {
                SUtils.setToast(ettfl,"is Empty!!!");
            } else {
                float Telescopefocallength = SUtils.getInteger(ettfl);
                float Eyepiecefocallength = SUtils.getInteger(etefl);
                float Magnification = Telescopefocallength / Eyepiecefocallength;
                tvmag.setText(String.valueOf(Magnification));
            }
        });

        btneyepiece.setOnClickListener(view -> {

            if (SUtils.isEmpty(ettfl2)) {
                SUtils.setToast(ettfl2,"is Empty!!!");
            } else if (SUtils.isEmpty(etta)) {
                SUtils.setToast(etta,"is Empty!!!");
            } else if (SUtils.isEmpty(etmag2)) {
                SUtils.setToast(etmag2,"is Empty!!!");
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