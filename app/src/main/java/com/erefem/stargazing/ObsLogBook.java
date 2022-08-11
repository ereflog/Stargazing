package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class  ObsLogBook extends AppCompatActivity {
    EditText
            et_object_name,
            et_observer,
            et_latitude,
            et_longitude,
            et_date,
            et_time,
            et_instrument,
            et_magnification,
            et_filter,
            et_comment;

    RadioButton
            excellent,
            poor;
    Button
            btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.obs_log_book_title);


        }
        et_object_name = findViewById(R.id.et_object_name);
        et_observer = findViewById(R.id.et_observer);
        et_latitude = findViewById(R.id.et_latitude);
        et_longitude = findViewById(R.id.et_longitude);
        et_date = findViewById(R.id.et_date);
        et_time = findViewById(R.id.et_time);
        excellent = findViewById(R.id.excellent);
        poor = findViewById(R.id.poor);
        et_instrument = findViewById(R.id.et_instrument);
        et_magnification = findViewById(R.id.et_magnification);
        et_filter = findViewById(R.id.et_filter);
        et_comment = findViewById(R.id.et_comment);
        btn_save = findViewById(R.id.btn_save);


    }
}