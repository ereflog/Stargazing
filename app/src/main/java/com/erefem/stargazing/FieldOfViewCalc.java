package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FieldOfViewCalc extends AppCompatActivity {

    EditText
            etefov,
            etefl,
            ettfl;
    TextView
            tvafov;
    Button
            btnfov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_of_view_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.field_of_view_calc_title);
        }
        etefov = findViewById(R.id.etefov);
        etefl = findViewById(R.id.etefl);
        ettfl = findViewById(R.id.ettfl);

        tvafov = findViewById(R.id.tvafov);

        btnfov = findViewById(R.id.btnfov);

        btnfov.setOnClickListener(view -> {

            if (etefov.getText().toString().isEmpty()) {
                Toast.makeText(FieldOfViewCalc.this, "Eyepiece Field of View is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (etefl.getText().toString().isEmpty()) {
                Toast.makeText(FieldOfViewCalc.this, "Eyepiece Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (ettfl.getText().toString().isEmpty()) {
                Toast.makeText(FieldOfViewCalc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float Eyepiecefov = Integer.parseInt(etefov.getText().toString());
                float Eyepiecefocallength = Integer.parseInt(etefl.getText().toString());
                float Telescopefocallength = Integer.parseInt(ettfl.getText().toString());
                float Actualvieldofview = Eyepiecefov * Eyepiecefocallength / Telescopefocallength ;
                tvafov.setText(String.valueOf(Actualvieldofview));
            }
        });
    }
}