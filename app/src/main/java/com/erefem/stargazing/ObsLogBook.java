package com.erefem.stargazing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class  ObsLogBook extends AppCompatActivity {

    EditText
            et_object_name,
            et_observer,
            et_time,
            et_instrument,
            et_magnification,
            et_filter,
            et_comment;
    TextView
            tv_latitude,
            tv_longitude;
    RadioGroup
            rg_seeing;
    RadioButton
            excellent,
            poor;
    Button
            btn_generate,
            btn_save_log;

    DatePickerDialog.OnDateSetListener
            setListener;

    private EditText
            et_date;
    private FusedLocationProviderClient
            locationProviderClient;

    HiAnalyticsInstance instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);
        instance = HiAnalytics.getInstance(this);
        et_object_name=
                findViewById(R.id.et_object_name);
        et_observer=
                findViewById(R.id.et_observer);
        tv_latitude=
                findViewById(R.id.tv_latitude);
        tv_longitude=
                findViewById(R.id.tv_longitude);
        et_date=
                findViewById(R.id.et_date);
        et_time=
                findViewById(R.id.et_time);
        rg_seeing=
                findViewById(R.id.rg_seeing);
        excellent=
                findViewById(R.id.excellent);
        poor=
                findViewById(R.id.poor);
        et_instrument=
                findViewById(R.id.et_instrument);
        et_magnification=
                findViewById(R.id.et_magnification);
        et_filter=
                findViewById(R.id.et_filter);
        et_comment=
                findViewById(R.id.et_comment);

        btn_generate=
                findViewById(R.id.btn_generate);
        btn_save_log=
                findViewById(R.id.btn_save_log);

        Calendar
                calendar=
                Calendar.getInstance();
        final int
                year=
                calendar.get(Calendar.YEAR);
        final int
                month=
                calendar.get(Calendar.MONTH);
        final int
                day=
                calendar.get(Calendar.DAY_OF_MONTH);
        et_time.setClickable(true);
        et_time.setLongClickable(false);
        et_time.setInputType(InputType.TYPE_NULL);

        et_date.setClickable(true);
        et_date.setLongClickable(false);
        et_date.setInputType(InputType.TYPE_NULL);

        et_date.setOnClickListener(v -> {

            DatePickerDialog
                    dialog=
                    new DatePickerDialog(ObsLogBook.this, (view, year1, month1, dayOfMonth) -> {

                        month1=
                                month1 + 1;
                        String
                                date=
                                dayOfMonth + "/" + month1 + "/" + year1;
                        et_date.setText(date);

                    }, year, month, day);
            dialog.show();

        });

        et_time.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Calendar
                    mcurrentTime=
                    Calendar.getInstance();
            int
                    hour=
                    mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int
                    minute=
                    mcurrentTime.get(Calendar.MINUTE);

            TimePickerDialog
                    mTimePicker;
            mTimePicker=
                    new TimePickerDialog(ObsLogBook.this, (timePicker, selectedHour, selectedMinute) -> et_time.setText(selectedHour + ":" + selectedMinute), hour, minute, true);
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();

        });

        locationProviderClient=
                LocationServices.getFusedLocationProviderClient(ObsLogBook.this);
        btn_generate.setOnClickListener(v ->
                getLocation());
        obslogBookPageEvt(new String[]{SUtils.getString(et_object_name),
                SUtils.getString(et_observer),
                SUtils.getString(tv_latitude)+","+SUtils.getString(tv_longitude)});
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Your Location Service Not Active", Toast.LENGTH_SHORT).show();
            } else {
                getLocation();
            }
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                }, 10);
            }
        } else {

            locationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        tv_latitude.setText(String.valueOf(location.getLatitude()));
                        tv_longitude.setText(String.valueOf(location.getLongitude()));
                    } else {
                        Toast.makeText(getApplicationContext(), "Your Location Servise Not Active", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void obslogBookPageEvt(String... data) {

        Bundle bundle = new Bundle();
        bundle.putString("object",data[0]);
        bundle.putString("observer",data[1]);
        bundle.putString("latitudeLongitude",data[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        bundle.putString("answerTime",sdf.format(new Date()));

        // Report a custom event.
        instance.onEvent("obsLogBook", bundle);
    }
}


