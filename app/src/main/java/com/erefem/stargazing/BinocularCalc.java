package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        et_fov1000m = findViewById(R.id.et_fov1000m);
        et_fov = findViewById(R.id.et_fov);
        et_ang_fov = findViewById(R.id.et_ang_fov);
        et_mag = findViewById(R.id.et_mag);
        et_ang_fov2 = findViewById(R.id.et_ang_fov2);
        et_mag2 = findViewById(R.id.et_mag2);

        tv_real_fov = findViewById(R.id.tv_real_fov);
        tv_real_fov2 = findViewById(R.id.tv_real_fov2);
        tv_apparent_fov = findViewById(R.id.tv_apparent_fov);
        tv_apparent_fov2 = findViewById(R.id.tv_apparent_fov2);

        btn_degrees = findViewById(R.id.btn_degrees);
        btn_1000m = findViewById(R.id.btn_1000m);
        btn_apparent = findViewById(R.id.btn_apparent);
        btn_apparent2 = findViewById(R.id.btn_apparent2);

        btn_degrees.setOnClickListener(view -> {

            if (et_fov1000m.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Field of View @ 1000m is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float Fov1000m = Integer.parseInt(et_fov1000m.getText().toString());
                float Realfov = (float) Math.toDegrees(Math.atan(Fov1000m/1000));
                tv_real_fov.setText(String.valueOf(Realfov));
            }
        });

        btn_1000m.setOnClickListener(view -> {

            if (et_fov.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Field of View degrees is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float Fovdegrees = Integer.parseInt(et_fov.getText().toString());
                float Realfov1000m =(float) Math.tan(Math.toRadians(Fovdegrees))*1000;
                tv_real_fov2.setText(String.valueOf(Realfov1000m));
            }
        });

        btn_apparent.setOnClickListener(view -> {

            if (et_ang_fov.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Angular FOV is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_mag.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Magnification is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                int Anggularfov = Integer.parseInt(et_ang_fov.getText().toString());
                int magnification = Integer.parseInt(et_mag.getText().toString());
                int Apparent = Anggularfov * magnification;
                tv_apparent_fov.setText(String.valueOf(Apparent));
            }
        });

        btn_apparent2.setOnClickListener(view -> {

            if (et_ang_fov2.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Angular FOV is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_mag2.getText().toString().isEmpty()) {
                Toast.makeText(BinocularCalc.this, "Magnification is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                int Anggularfov2 = Integer.parseInt(et_ang_fov2.getText().toString());
                int magnification2 = Integer.parseInt(et_mag2.getText().toString());
                int Apparent2 = Anggularfov2 * magnification2;
                tv_apparent_fov2.setText(String.valueOf(Apparent2));
            }
        });
    }
}