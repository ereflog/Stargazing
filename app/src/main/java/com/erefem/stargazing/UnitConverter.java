package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UnitConverter extends AppCompatActivity {
    EditText
            et_inctomm,et_mmtoinc ;
    TextView
            tv_result_inctomm, tv_result_mmtoinc;
    Button
            btn_calculate_inctomm,btn_calculate_mmtoinc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.unit_converter_title);
        }
        et_inctomm = findViewById(R.id.et_inctomm);
        et_mmtoinc = findViewById(R.id.et_mmtoinc);

        tv_result_inctomm = findViewById(R.id.tv_result_inctomm);
        tv_result_mmtoinc = findViewById(R.id.tv_result_mmtoinc);


        btn_calculate_inctomm = findViewById(R.id.btn_calculate_inctomm);
        btn_calculate_mmtoinc = findViewById(R.id.btn_calculate_mmtoinc);


    }
}