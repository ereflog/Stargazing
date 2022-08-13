package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ImagingGuidingRatioCalc extends AppCompatActivity {

    EditText
            et_tele_fl, et_tele_ps, et_cam_fl, et_cam_ps;
    TextView
            tv_resolution_tele, tv_cam_resolution, tvImagingGuidingRatioResult, tvImagingGuidingRatioResult2;

    Spinner
            barlow_reducer_imaging_dropdown, barlow_reducer_guide_dropdown, binning_imaging_dropdown,
            binning_guide_dropdown;

    Button
            btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imaging_guiding_ratio_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.imaging_guiding_ratio_calc_title);
        }
        et_tele_fl = findViewById(R.id.et_tele_fl);
        et_tele_ps = findViewById(R.id.et_tele_ps);
        et_cam_fl = findViewById(R.id.et_cam_fl);
        et_cam_ps = findViewById(R.id.et_cam_ps);

        tv_resolution_tele = findViewById(R.id.tv_resolution_tele);
        tv_cam_resolution = findViewById(R.id.tv_cam_resolution);
        tvImagingGuidingRatioResult = findViewById(R.id.tvImagingGuidingRatioResult);
        tvImagingGuidingRatioResult2 = findViewById(R.id.tvImagingGuidingRatioResult2);
        barlow_reducer_imaging_dropdown=findViewById(R.id.dd_barlow_reducer_imaging_dropdown);
        barlow_reducer_guide_dropdown=findViewById(R.id.dd_barlow_reducer_guide_dropdown);
        binning_guide_dropdown=findViewById(R.id.binning_guide_dropdown);
        binning_imaging_dropdown=findViewById(R.id.binning_imaging_dropdown);

        btn_enter = findViewById(R.id.btn_enter);

        btn_enter.setOnClickListener(view -> {

            if (SUtils.isEmpty(et_tele_fl)) {
                SUtils.setToast(et_tele_fl,"is Empty!!!");
            } else if (SUtils.isEmpty(et_tele_ps)) {
                SUtils.setToast(et_tele_ps,"is Empty!!!");
            } else if (SUtils.isEmpty(et_cam_fl)) {
                SUtils.setToast(et_cam_fl,"is Empty!!!");
            } else if (SUtils.isEmpty(et_cam_ps)) {
                SUtils.setToast(et_cam_ps,"is Empty!!!");

            } else {
                float dd_barlow_reducer_imaging = SUtils.getBinningSpinnerValue(barlow_reducer_imaging_dropdown);
                float dd_barlow_reducer_guide_dropdown = SUtils.getBinningSpinnerValue(barlow_reducer_guide_dropdown);
                float binning_guide =SUtils.getBinningSpinnerValue(binning_guide_dropdown);
                float binning_imaging =SUtils.getBinningSpinnerValue(binning_imaging_dropdown);
                float Tele_Fl = SUtils.getFloat(et_tele_fl) * dd_barlow_reducer_guide_dropdown;
                float Tele_Ps = Float.parseFloat(et_tele_ps.getText().toString());
                float Cam_Fl = SUtils.getFloat(et_cam_fl) * dd_barlow_reducer_imaging;
                float Cam_Ps = Float.parseFloat(et_cam_ps.getText().toString());
                float Resolution_Tele =
                        (float) (Tele_Ps / Tele_Fl * 206.265) * binning_guide;
                float Resolution_Cam =
                        (float) (Cam_Ps / Cam_Fl * 206.265) * binning_imaging;
                float result_value = Resolution_Tele / Resolution_Cam;
                tv_resolution_tele.setText(String.valueOf(Resolution_Tele));
                tv_cam_resolution.setText(String.valueOf(Resolution_Cam));
                tvImagingGuidingRatioResult.setText(String.valueOf(result_value));
                tvImagingGuidingRatioResult2.setText(String.valueOf(result_value));
            }
        });
    }
}