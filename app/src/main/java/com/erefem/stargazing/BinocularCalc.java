package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BinocularCalc extends AppCompatActivity {

    EditText
            et_fov1000m, et_fov, et_ang_fov, et_mag, et_ang_fov2, et_mag2;
    TextView
            tv_real_fov, tv_real_fov2, tv_apparent_fov, tv_apparent_fov2;
    Button
            btn_degrees, btn_1000m, btn_apparent, btn_apparent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binocular_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.binocular_calc_title);
        }
        et_fov1000m     = findViewById(R.id.et_fov1000m);
        et_fov          = findViewById(R.id.et_fov);
        et_ang_fov      = findViewById(R.id.et_ang_fov);
        et_mag          = findViewById(R.id.et_mag);
        et_ang_fov2     = findViewById(R.id.et_ang_fov2);
        et_mag2         = findViewById(R.id.et_mag2);

        tv_real_fov     = findViewById(R.id.tv_real_fov);
        tv_real_fov2    = findViewById(R.id.tv_real_fov2);
        tv_apparent_fov = findViewById(R.id.tv_apparent_fov);
        tv_apparent_fov2 = findViewById(R.id.tv_apparent_fov2);

        btn_degrees     = findViewById(R.id.btn_degrees);
        btn_1000m       = findViewById(R.id.btn_1000m);
        btn_apparent    = findViewById(R.id.btn_apparent);
        btn_apparent2   = findViewById(R.id.btn_apparent2);

        btn_degrees.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_fov1000m)) {
                SUtils.setToast(et_fov1000m,"This field cannot be blank!");
            } else {
                float Fov1000m  = SUtils.getFloat(et_fov1000m);
                float Realfov   = (float) Math.toDegrees(Math.atan(Fov1000m/1000));

                tv_real_fov.setText(decimal.format(Realfov));
            }
        });

        btn_1000m.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_fov)) {
                SUtils.setToast(et_fov,"This field cannot be blank!");
            } else {
                float Fovdegrees    = SUtils.getFloat(et_fov);
                float Realfov1000m  = (float) Math.tan(Math.toRadians(Fovdegrees))*1000;

                tv_real_fov2.setText(decimal.format(Realfov1000m));
            }
        });

        btn_apparent.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_ang_fov)) {
                SUtils.setToast(et_ang_fov,"This field cannot be blank!");
            } else if (SUtils.isEmpty(et_mag)) {
                SUtils.setToast(et_mag,"This field cannot be blank!");
            } else {
                float Anggularfov     = SUtils.getFloat(et_ang_fov);
                float magnification   = SUtils.getFloat(et_mag);
                float Apparent        = Anggularfov * magnification;

                tv_apparent_fov.setText(decimal.format(Apparent));
            }
        });

        btn_apparent2.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_ang_fov2)) {
                SUtils.setToast(et_ang_fov2,"This field cannot be blank!");
            } else if (SUtils.isEmpty(et_mag2)) {
                SUtils.setToast(et_mag2,"This field cannot be blank!");
            } else {
                float Anggularfov2      = SUtils.getFloat(et_ang_fov2);
                float magnification2    = SUtils.getFloat(et_mag2);
                float Apparent2         = (float) (Math.toDegrees( 2 * Math.atan (magnification2 * Math.tan(Math.toRadians( Anggularfov2 / 2 )))));

                tv_apparent_fov2.setText(decimal.format(Apparent2));
            }
        });
    }
}