package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CCDTelescopeCombinationCalc extends AppCompatActivity {

    EditText
            et_pixel_size, et_focal_lenght;
    TextView
            tv_resolution;
    Spinner
            dd_barlow_reducer_ccd_imaging, binning_spinner;

    Button
            btn_resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_telescope_combination_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_telescope_combination_calc_title);
        }
        et_pixel_size       = findViewById(R.id.et_pixel_size);
        et_focal_lenght     = findViewById(R.id.et_focal_lenght);

        dd_barlow_reducer_ccd_imaging   = findViewById(R.id.dd_barlow_reducer_ccd_imaging_dropdown);
        binning_spinner                 = findViewById(R.id.binning_spinner);

        tv_resolution       = findViewById(R.id.tv_resolution_combination);

        btn_resolution      = findViewById(R.id.btn_resolution_combination);

        btn_resolution.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_pixel_size)) {
                SUtils.setToast(et_pixel_size,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_focal_lenght)) {
                SUtils.setToast(et_focal_lenght,"This field cannot be blank!");
            } else {
                float dd_barlow_reducer = SUtils.getFloatSpinnerValue(dd_barlow_reducer_ccd_imaging);
                float binning_spin      = SUtils.getBinningSpinnerValue(binning_spinner);
                float Pixel_size        = SUtils.getFloat(et_pixel_size);
                float Focal_lenght      = SUtils.getFloat(et_focal_lenght) * dd_barlow_reducer;

                float Resolution = (float) (Pixel_size / Focal_lenght * 206.265) * binning_spin;
                
                tv_resolution.setText(decimal.format(Resolution));
            }
        });
    }
}