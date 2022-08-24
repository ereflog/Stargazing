package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
        et_pixsize      = findViewById(R.id.et_pixsize);
        et_tfl          = findViewById(R.id.et_tfl);
        et_dim_hor      = findViewById(R.id.et_dim_hor);
        et_dim_ver      = findViewById(R.id.et_dim_ver);
        et_res_hor      = findViewById(R.id.et_res_hor);
        et_res_ver      = findViewById(R.id.et_res_ver);
        et_ccd_pix      = findViewById(R.id.et_ccd_pix);
        et_res_hor2     = findViewById(R.id.et_res_hor2);
        et_res_ver2     = findViewById(R.id.et_res_ver2);

        tv_resolution   = findViewById(R.id.tv_resolution);
        tv_pix_hor      = findViewById(R.id.tv_pix_hor);
        tv_pix_ver      = findViewById(R.id.tv_pix_ver);
        tv_ccd_hor      = findViewById(R.id.tv_ccd_hor);
        tv_ccd_ver      = findViewById(R.id.tv_ccd_ver);
        tv_diagonal     = findViewById(R.id.tv_diagonal);

        btn_resolution  = findViewById(R.id.btn_resolution);
        btn_pixel       = findViewById(R.id.btn_pixel);
        btn_ccd         = findViewById(R.id.btn_ccd);

        btn_resolution.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_pixsize)) {
                SUtils.setToast(et_pixsize,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_tfl)) {
                SUtils.setToast(et_tfl,"This field cannot be blank!");
            } else {
                float CCDpixel      = SUtils.getFloat(et_pixsize);
                float TeleFL        = SUtils.getFloat(et_tfl);
                float Resolution    = (float) (CCDpixel / TeleFL * 206.265);

                tv_resolution.setText(decimal.format(Resolution));
            }
        });

        btn_pixel.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_dim_hor)) {
                SUtils.setToast(et_dim_hor,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_dim_ver)) {
                SUtils.setToast(et_dim_ver,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_res_hor)) {
                SUtils.setToast(et_res_hor,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_res_ver)) {
                SUtils.setToast(et_res_ver,"This field cannot be blank!");
            } else {
                float Dimension_Hor     = SUtils.getFloat(et_dim_hor);
                float Dimension_Ver     = SUtils.getFloat(et_dim_ver);
                float Resolution_Hor    = SUtils.getFloat(et_res_hor);
                float Resolution_Ver    = SUtils.getFloat(et_res_ver);
                float Hor_Value         = Dimension_Hor / Resolution_Hor * 1000;
                float Ver_Value         = Dimension_Ver / Resolution_Ver * 1000;

                tv_pix_hor.setText(decimal.format(Hor_Value));
                tv_pix_ver.setText(decimal.format(Ver_Value));
            }
        });

        btn_ccd.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);

            if (SUtils.isEmpty(et_ccd_pix)) {
                SUtils.setToast(et_ccd_pix,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_res_hor2)) {
                SUtils.setToast(et_res_hor2,"This field cannot be blank!");
            } if (SUtils.isEmpty(et_res_ver2)) {
                SUtils.setToast(et_res_ver2,"This field cannot be blank!");
            } else {
                float CCD_pixel         = SUtils.getFloat(et_ccd_pix);
                float Resolution_Hor2   = SUtils.getFloat(et_res_hor2);
                float Resolution_Ver2   = SUtils.getFloat(et_res_ver2);
                float Hor_Size          = CCD_pixel * Resolution_Hor2 / 1000;
                float Ver_Size          = CCD_pixel * Resolution_Ver2 / 1000;
                float Diagonal          = (float) Math.sqrt(Math.pow(Hor_Size, 2) + Math.pow(Ver_Size, 2));

                tv_ccd_hor.setText(decimal.format(Hor_Size));
                tv_ccd_ver.setText(decimal.format(Ver_Size));
                tv_diagonal.setText(decimal.format(Diagonal));
            }
        });
    }
}