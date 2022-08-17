package com.erefem.stargazing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class  ObsLogBook extends AppCompatActivity {
    FusedLocationProviderClient
            fusedLocationProviderClient;

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

    HiAnalyticsInstance
            instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);

        LocationRequest
                mLocationRequest;
        mLocationRequest=
                new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        instance=
                HiAnalytics.getInstance(this);
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

        fusedLocationProviderClient=
                LocationServices.getFusedLocationProviderClient(ObsLogBook.this);

        obslogBookPageEvt(new String[]{SUtils.getString(et_object_name),
                SUtils.getString(et_observer),
                SUtils.getString(tv_latitude) + "," + SUtils.getString(tv_longitude)});

        btn_generate.setOnClickListener(view -> {

            if (ActivityCompat.checkSelfPermission(ObsLogBook.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(ObsLogBook.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLocation();

                } else {
                ActivityCompat.requestPermissions(ObsLogBook.this
                        , new String[]{Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION}
                        , 100);
            }

        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && (grantResults[0] + grantResults[1]
                == PackageManager.PERMISSION_GRANTED)) {

            getLocation();

        } else {
            Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void getLocation() {
        LocationManager locationManager=(LocationManager) getSystemService(
                Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))


            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
                Location
                        location=
                        task.getResult();
                if (location != null) {
                    tv_latitude.setText(String.valueOf(location.getLatitude()));
                    tv_longitude.setText(String.valueOf(location.getLongitude()));
                } else {
                    LocationRequest
                            locationRequest=
                            new LocationRequest()
                                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                                    .setInterval(10000)
                                    .setFastestInterval(1000)
                                    .setNumUpdates(1);
                    LocationCallback
                            locationCallback=
                            new LocationCallback() {
                                @Override
                                public void onLocationResult(LocationResult locationResult) {
                                    Location
                                            location1=
                                            locationResult.getLastLocation();
                                    tv_latitude.setText(String.valueOf(location1.getLatitude()));
                                    tv_longitude.setText(String.valueOf(location1.getLongitude()));
                                }
                            };
                    fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                            locationCallback, Looper.myLooper());
                }
            });

        else{

           startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
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


