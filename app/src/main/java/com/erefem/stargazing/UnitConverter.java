package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class UnitConverter extends AppCompatActivity {

    EditText et_inches,et_millimeter;

    TextView tv_millimetres, tv_inches;

    Button  btn_calculate_inctomm,
            btn_calculate_mmtoinc,
            btnCalculateConversion;

    Spinner ddLengthUnitInput;
    Spinner ddLengthUnitOutput;

    String [] unit = {"millimeters","centimeters","inches","meters","kilometers","miles","astronomical unit","light-year","parsec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.unit_converter_title);
        }
//        et_inches       = findViewById(R.id.et_inches);
//        et_millimeter   = findViewById(R.id.et_millimeter);
//
//        tv_millimetres  = findViewById(R.id.tv_millimetres);
//        tv_inches       = findViewById(R.id.tv_inches);

//        btn_calculate_inctomm = findViewById(R.id.btn_calculate_inctomm);
//        btn_calculate_mmtoinc = findViewById(R.id.btn_calculate_mmtoinc);
        btnCalculateConversion = findViewById(R.id.btn_calculate_conversion);

        //spinner for unit selection
        ddLengthUnitInput = (Spinner)findViewById(R.id.dd_length_unit_input);
        ddLengthUnitOutput = (Spinner)findViewById(R.id.dd_length_unit_output);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unit);

        ddLengthUnitInput.setAdapter(spinnerAdapter);
        ddLengthUnitOutput.setAdapter(spinnerAdapter);

        /*btn_calculate_inctomm.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_inches)) {
                SUtils.setToast(et_inches,"This field cannot be blank!");
            } else {
                float inch          = SUtils.getFloat(et_inches);
                float millimeter    = (float) (inch * 25.4);

                tv_millimetres.setText(decimal.format(millimeter));
            }
        });

        btn_calculate_mmtoinc.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_millimeter)) {
                SUtils.setToast(et_millimeter,"This field cannot be blank!");
            } else {
                float milli_meter   = SUtils.getFloat(et_millimeter);
                float inches        = (float) (milli_meter / 25.4);

                tv_inches.setText(decimal.format(inches));
            }
        });*/
    }


    public void btnCalculateConversion(View view){
        double inputNumbers;
        double outputNumbers;
        String inputUnitType;
        String outputUnitType;

        EditText etConversionInput = (EditText) findViewById(R.id.et_conversion_input);
        EditText etConversionOutput = (EditText) findViewById(R.id.et_conversion_result);

        ConverterCalc unitConverter = new ConverterCalc(); //create object for unit converter

        if(SUtils.isEmpty(etConversionInput)){
           SUtils.setToast(etConversionInput, "Please enter the number");
        } else {
            //get input numbers from edit text
            inputNumbers = SUtils.getDouble(etConversionInput);
            inputUnitType = ddLengthUnitInput.getSelectedItem().toString();
            outputUnitType = ddLengthUnitOutput.getSelectedItem().toString();

            //input numbers into object
            unitConverter.setInputNumbers(inputNumbers);
            unitConverter.setInputUnitType(inputUnitType);
            unitConverter.setOutputUnitType(outputUnitType);

            //calculate the conversion
            outputNumbers = unitConverter.calculateOutputNumbers();
            unitConverter.setOutputNumbers(outputNumbers);

            //view the result in edit text
            etConversionOutput.setText(unitConverter.toString());
        }
    }
}