package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Locale;


public class  ObsLogBook extends AppCompatActivity {
    EditText
            et_object_name,
            et_observer,
            et_latitude,
            et_longitude,
             et_time,
            et_instrument,
            et_magnification,
            et_filter,
            et_comment;

    RadioGroup rg_seeing;
    RadioButton
            excellent,
            poor;
    Button
            btn_save_log;

    DatePickerDialog.OnDateSetListener setListener;

    private EditText et_date;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);

        et_object_name = findViewById(R.id.et_object_name);
        et_observer = findViewById(R.id.et_observer);
        et_latitude = findViewById(R.id.et_latitude);
        et_longitude = findViewById(R.id.et_longitude);
        et_date = findViewById(R.id.et_date);
        et_time = findViewById(R.id.et_time);
        rg_seeing = findViewById(R.id.rg_seeing);
        excellent = findViewById(R.id.excellent);
        poor = findViewById(R.id.poor);
        et_instrument = findViewById(R.id.et_instrument);
        et_magnification = findViewById(R.id.et_magnification);
        et_filter = findViewById(R.id.et_filter);
        et_comment = findViewById(R.id.et_comment);

        btn_save_log = findViewById(R.id.btn_save_log);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        et_time.setClickable(true);
        et_time.setLongClickable(false);
        et_time.setInputType(InputType.TYPE_NULL);

        et_date.setClickable(true);
        et_date.setLongClickable(false);
        et_date.setInputType(InputType.TYPE_NULL);

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(ObsLogBook.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = dayOfMonth+"/"+month+"/"+year;
                        et_date.setText(date);

                    }
                },year, month,day);
                dialog.show();

            }
        });

        et_time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ObsLogBook.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        et_time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
    }


}
