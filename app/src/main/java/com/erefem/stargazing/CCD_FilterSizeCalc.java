package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CCD_FilterSizeCalc extends AppCompatActivity {

    EditText
            et_fs_aperture, et_fs_fl, et_fs_diagonal, et_fs_distance;
    TextView tv_fs_min;

    Spinner dd_barlow_reducer_ccd_dropdown;

    Button btn_fs_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_filter_size_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_filter_size_calc_title);
        }

        et_fs_aperture = findViewById(R.id.et_fs_aperture);
        et_fs_fl = findViewById(R.id.et_fs_fl);
        et_fs_diagonal = findViewById(R.id.et_fs_diagonal);
        et_fs_distance = findViewById(R.id.et_fs_distance);
        dd_barlow_reducer_ccd_dropdown=findViewById(R.id.dd_barlow_reducer_ccd_dropdown);


        tv_fs_min = findViewById(R.id.tv_fs_min);

        btn_fs_min = findViewById(R.id.btn_fs_min);

        btn_fs_min.setOnClickListener(view -> {

            if (SUtils.isEmpty(et_fs_aperture)) {
                SUtils.setToast(et_fs_aperture,"is Empty!!!");
            } else if (SUtils.isEmpty(et_fs_fl)) {
                SUtils.setToast(et_fs_fl,"is Empty!!!");
            } else if (SUtils.isEmpty(et_fs_diagonal)) {
                SUtils.setToast(et_fs_diagonal,"is Empty!!!");
            } else if (SUtils.isEmpty(et_fs_distance)) {
                SUtils.setToast(et_fs_distance,"is Empty!!!");

            } else {
                float dd_barlow_reducer = SUtils.getFloatSpinnerValue(dd_barlow_reducer_ccd_dropdown);
                float Aperture = SUtils.getInteger(et_fs_aperture);
                float Focal_length = SUtils.getFloat(et_fs_fl) * dd_barlow_reducer;
                float diagonal = Float.parseFloat(et_fs_diagonal.getText().toString());
                float Distance = SUtils.getInteger(et_fs_distance);

                float var1 = Focal_length - Distance;
                float var2 = (float) (diagonal / 2) / Focal_length ;
                float var3 =
                        (float) (var2 / 0.5);
                float var4 = Distance / (Focal_length / Aperture);

                float Min = var1 * var3 + var4;
                tv_fs_min.setText(String.valueOf(Min));
            }
        });
    }
}