package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ImagingGuidingRatioCalc extends AppCompatActivity {

    EditText
            etTeleFocalLength, etTelePixelSize, etGuideFocalLength, etGuidePixelSize;
    TextView
            tvTeleResolution, tvGuideResolution, tvImagingGuidingRatioResult, tvImagingGuidingRatioResult2;

    Spinner
            ddBarlowReducerImaging, ddBarlowReducerGuide, ddBinningImaging,
            ddBinningGuide;

    Button
            btnCalculateRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imaging_guiding_ratio_calc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.imaging_guiding_ratio_calc_title);
        }
        etTeleFocalLength   = findViewById(R.id.et_tele_focal_length);
        etTelePixelSize     = findViewById(R.id.et_tele_pixel_size);
        etGuideFocalLength  = findViewById(R.id.et_guide_focal_length);
        etGuidePixelSize    = findViewById(R.id.et_guide_pixel_size);

        tvTeleResolution    = findViewById(R.id.tv_resolution_tele);
        tvGuideResolution   = findViewById(R.id.tv_cam_resolution);

        tvImagingGuidingRatioResult  = findViewById(R.id.tv_imaging_guiding_ratio_result);

        ddBarlowReducerImaging = findViewById(R.id.dd_barlow_reducer_imaging);
        ddBarlowReducerGuide   = findViewById(R.id.dd_barlow_reducer_guide);
        ddBinningImaging       = findViewById(R.id.dd_binning_imaging);
        ddBinningGuide         = findViewById(R.id.dd_binning_guide);

        btnCalculateRatio = findViewById(R.id.btn_calculate_ratio);

        btnCalculateRatio.setOnClickListener(view -> {
            DecimalFormat decimal = new DecimalFormat("#.##");
            decimal.setRoundingMode(RoundingMode.HALF_EVEN);
            if (SUtils.isEmpty(etTeleFocalLength)) {
                SUtils.setToast(etTeleFocalLength,"This field cannot be blank!");
            } if (SUtils.isEmpty(etTelePixelSize)) {
                SUtils.setToast(etTelePixelSize,"This field cannot be blank!");
            } if (SUtils.isEmpty(etGuideFocalLength)) {
                SUtils.setToast(etGuideFocalLength,"This field cannot be blank!");
            } if (SUtils.isEmpty(etGuidePixelSize)) {
                SUtils.setToast(etGuidePixelSize,"This field cannot be blank!");

            } else {
                float teleBarlowReducer    = SUtils.getFloatSpinnerValue(ddBarlowReducerImaging);
                float guideBarlowReducer   = SUtils.getFloatSpinnerValue(ddBarlowReducerGuide);
                float binningImaging       = SUtils.getBinningSpinnerValue(ddBinningImaging);
                float binningGuide         = SUtils.getBinningSpinnerValue(ddBinningGuide);
                float teleFocalLength      = SUtils.getFloat(etTeleFocalLength) * teleBarlowReducer;
                float guideFocalLength     = SUtils.getFloat(etGuideFocalLength) * guideBarlowReducer;
                float telePixelSize        = SUtils.getFloat(etTelePixelSize);
                float guidePixelSize       = SUtils.getFloat(etGuidePixelSize);

                float ccdTeleResolution   = (float) ((telePixelSize / teleFocalLength) * 206.265) * binningImaging;
                float ccdGuideResolution  = (float) ((guidePixelSize / guideFocalLength) * 206.265) * binningGuide;
                float imagingGuidingRatio = ccdGuideResolution / ccdTeleResolution;

                tvTeleResolution.setText(decimal.format(ccdTeleResolution));
                tvGuideResolution.setText(decimal.format(ccdGuideResolution));
                tvImagingGuidingRatioResult.setText(decimal.format(imagingGuidingRatio));
            }
        });
    }
}