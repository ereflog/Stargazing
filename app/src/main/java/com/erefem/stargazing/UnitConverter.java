package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UnitConverter extends AppCompatActivity {

    EditText
            et_inches,et_millimeter ;
    TextView
            tv_millimetres, tv_inches;
    Button
            btn_calculate_inctomm,btn_calculate_mmtoinc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.unit_converter_title);
        }
        et_inches = findViewById(R.id.et_inches);
        et_millimeter = findViewById(R.id.et_millimeter);

        tv_millimetres = findViewById(R.id.tv_millimetres);
        tv_inches = findViewById(R.id.tv_inches);

        btn_calculate_inctomm = findViewById(R.id.btn_calculate_inctomm);
        btn_calculate_mmtoinc = findViewById(R.id.btn_calculate_mmtoinc);

        btn_calculate_inctomm.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_inches)) {
                SUtils.setToast(et_inches,"is Empty!!!");
            } else {
                float inch = Float.parseFloat(et_inches.getText().toString());
                float millimeter =
                        (float) (inch * 25.4);
                tv_millimetres.setText(String.valueOf(millimeter));
            }
        });

        btn_calculate_mmtoinc.setOnClickListener(view -> {
            if (SUtils.isEmpty(et_millimeter)) {
                SUtils.setToast(et_millimeter,"is Empty!!!");
            } else {
                float milli_meter = Float.parseFloat(et_millimeter.getText().toString());
                float inches =
                        (float) (milli_meter / 25.4);
                tv_inches.setText(String.valueOf(inches));
            }
        });
    }
}