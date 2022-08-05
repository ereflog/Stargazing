package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CCD_Calc extends AppCompatActivity {


    EditText
            et_pixsize, et_tfl, et_dim_hor, et_dim_ver, et_res_hor, et_res_ver, et_ccd_pix, et_res_hor2, et_res_ver2;
    TextView
            tv_resolution, tv_pix_hor, tv_pix_ver, tv_ccd_hor, tv_ccd_ver,tv_diagonal;
    Button
            btn_resolution, btn_pixel, btn_ccd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccd_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.ccd_calc_title);
        }
        et_pixsize = findViewById(R.id.et_pixsize);
        et_tfl = findViewById(R.id.et_tfl);
        et_dim_hor = findViewById(R.id.et_dim_hor);
        et_dim_ver = findViewById(R.id.et_dim_ver);
        et_res_hor = findViewById(R.id.et_res_hor);
        et_res_ver = findViewById(R.id.et_res_ver);
        et_ccd_pix = findViewById(R.id.et_ccd_pix);
        et_res_hor2 = findViewById(R.id.et_res_hor2);
        et_res_ver2 = findViewById(R.id.et_res_ver2);

        tv_resolution = findViewById(R.id.tv_resolution);
        tv_pix_hor = findViewById(R.id.tv_pix_hor);
        tv_pix_ver = findViewById(R.id.tv_pix_ver);
        tv_ccd_hor = findViewById(R.id.tv_ccd_hor);
        tv_ccd_ver = findViewById(R.id.tv_ccd_ver);
        tv_diagonal = findViewById(R.id.tv_diagonal);

        btn_resolution = findViewById(R.id.btn_resolution);
        btn_pixel = findViewById(R.id.btn_pixel);
        btn_ccd = findViewById(R.id.btn_ccd);

        btn_resolution.setOnClickListener(view -> {

            if (et_pixsize.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "CCD Pixel Size is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_tfl.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Telescope Focal Length is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float CCDpixel = Float.parseFloat(et_pixsize.getText().toString());
                float TeleFL = Integer.parseInt(et_tfl.getText().toString());
                float Resolution =
                        (float) (CCDpixel / TeleFL * 206.265);
                tv_resolution.setText(String.valueOf(Resolution));
            }
        });

        btn_pixel.setOnClickListener(view -> {

            if (et_dim_hor.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Horizontal Size is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_dim_ver.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Vertical Size is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_res_hor.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Horizontal Resolution is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_res_ver.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Vertical Resolution is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float Dimension_Hor = Integer.parseInt(et_dim_hor.getText().toString());
                float Dimension_Ver = Integer.parseInt(et_dim_ver.getText().toString());
                float Resolution_Hor = Integer.parseInt(et_res_hor.getText().toString());
                float Resolution_Ver = Integer.parseInt(et_res_ver.getText().toString());
                float Hor_Value = Dimension_Hor / Resolution_Hor * 1000;
                float Ver_Value = Dimension_Ver / Resolution_Ver * 1000;

                tv_pix_hor.setText(String.valueOf(Hor_Value));
                tv_pix_ver.setText(String.valueOf(Ver_Value));
            }
        });

        btn_ccd.setOnClickListener(view -> {

            if (et_ccd_pix.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Pixel Size is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_res_hor2.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Horizontal Resolution is Empty!!!", Toast.LENGTH_SHORT).show();
            } else if (et_res_ver2.getText().toString().isEmpty()) {
                Toast.makeText(CCD_Calc.this, "Vertical Resolution is Empty!!!", Toast.LENGTH_SHORT).show();
            } else {
                float CCD_pixel = Float.parseFloat(et_ccd_pix.getText().toString());
                float Resolution_Hor2 = Integer.parseInt(et_res_hor2.getText().toString());
                float Resolution_Ver2 = Integer.parseInt(et_res_ver2.getText().toString());
                float Hor_Size = CCD_pixel * Resolution_Hor2 / 1000;
                float Ver_Size = CCD_pixel * Resolution_Ver2 / 1000;
                float Diagonal =
                        (float) Math.sqrt(Math.pow(Hor_Size, 2) + Math.pow(Ver_Size, 2));

                tv_ccd_hor.setText(String.valueOf(Hor_Size));
                tv_ccd_ver.setText(String.valueOf(Ver_Size));
                tv_diagonal.setText(String.valueOf(Diagonal));
            }
        });
    }
}