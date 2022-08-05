package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ImagingGuidingRatioCalc extends AppCompatActivity {

    EditText
            et_tele_fl, et_tele_ps, et_cam_fl, et_cam_ps;
    TextView
            tv_resolution_tele, tv_cam_resolution, tvImagingGuidingRatioResult, tvImagingGuidingRatioResult2;

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
                float Tele_Fl = Integer.parseInt(et_tele_fl.getText().toString());
                float Tele_Ps = Float.parseFloat(et_tele_ps.getText().toString());
                float Cam_Fl = Integer.parseInt(et_cam_fl.getText().toString());
                float Cam_Ps = Float.parseFloat(et_cam_ps.getText().toString());
                float Resolution_Tele =
                        (float) (Tele_Ps / Tele_Fl * 206.265);
                float Resolution_Cam =
                        (float) (Cam_Ps / Cam_Fl * 206.265);
                float result_value = Resolution_Tele / Resolution_Cam;
                tv_resolution_tele.setText(String.valueOf(Resolution_Tele));
                tv_cam_resolution.setText(String.valueOf(Resolution_Cam));
                tvImagingGuidingRatioResult.setText(String.valueOf(result_value));
                tvImagingGuidingRatioResult2.setText(String.valueOf(result_value));
            }
        });
    }
}