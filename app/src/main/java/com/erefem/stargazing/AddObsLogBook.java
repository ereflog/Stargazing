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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.erefem.stargazing.database.AppDatabase;
import com.erefem.stargazing.database.entitas.Logbook;
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

public class AddObsLogBook extends AppCompatActivity {
    FusedLocationProviderClient
            fusedLocationProviderClient;

    EditText
            etObject,
            etObserver,
            etLatitude,
            etLongitude,
            etTime,
            etDate,
            etInstrument,
            etMagnification,
            etFilter,
            etComment;

    RadioGroup
            rgSeeing;

    RadioButton
            rbSeeing,
            rbExceptional,
            rbGood,
            rbOk,
            rbPoor,
            rbVeryPoor;

    Button
            btnGenerate,
            btnSaveLog;

    DatePickerDialog.OnDateSetListener
            setListener;

    private AppDatabase database;
    private int uid = 0;
    private boolean isEdit = false;

    HiAnalyticsInstance instance;
    private Object Logbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obs_log_book);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.obs_log_book_title);
        }

        LocationRequest mLocationRequest;
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        instance        = HiAnalytics.getInstance(this);
        etObject        = findViewById(R.id.et_object_name);
        etObserver      = findViewById(R.id.et_observer);
        etLatitude      = findViewById(R.id.et_latitude);
        etLongitude     = findViewById(R.id.et_longitude);
        etDate          = findViewById(R.id.et_date);
        etTime          = findViewById(R.id.et_time);
        rgSeeing        = findViewById(R.id.rg_seeing);
//        rbExceptional   = findViewById(R.id.rb_seeing_exceptional);
//        rbGood          = findViewById(R.id.rb_seeing_good);
//        rbOk            = findViewById(R.id.rb_seeing_ok);
//        rbPoor          = findViewById(R.id.rb_seeing_poor);
//        rbVeryPoor      = findViewById(R.id.rb_seeing_very_poor);
        etInstrument    = findViewById(R.id.et_instrument);
        etMagnification = findViewById(R.id.et_magnification);
        etFilter        = findViewById(R.id.et_filter);
        etComment       = findViewById(R.id.et_comment);
        btnGenerate     = findViewById(R.id.btn_generate);
        btnSaveLog      = findViewById(R.id.btn_save_log);

        database = AppDatabase.getInstance(getApplicationContext());
        Intent intent = getIntent();
        uid = intent.getIntExtra("uid",0);

        if (uid>0){
            isEdit = true;
            Logbook logbook = database.logbookDao().get(uid);
            etObject.setText(logbook.object);
            etObserver.setText(logbook.observer);
            etLatitude.setText(logbook.latitude);
            etLongitude.setText(logbook.longitude);
            etDate.setText(logbook.date);
            etTime.setText(logbook.time);
            //rbSeeing.setText(logbook.seeing);
            etInstrument.setText(logbook.instrument);
            etMagnification.setText(logbook.magnification);
            etFilter.setText(logbook.filter);
            etComment.setText(logbook.comment);
        } else {
            isEdit = false;
        }

        btnSaveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedRadioButton = rgSeeing.getCheckedRadioButtonId();
                rbSeeing = (RadioButton) findViewById(selectedRadioButton);

                if(isEdit){
                    database.logbookDao().update(uid,
                            etObject.getText().toString(),
                            etObserver.getText().toString(),
                            etLatitude.getText().toString(),
                            etLongitude.getText().toString(),
                            etDate.getText().toString(),
                            etTime.getText().toString(),
                            rbSeeing.getText().toString(),
                            etInstrument.getText().toString(),
                            etMagnification.getText().toString(),
                            etFilter.getText().toString(),
                            etComment.getText().toString());
                }else{
                    database.logbookDao().insertAll(
                            etObject.getText().toString(),
                            etObserver.getText().toString(),
                            etLatitude.getText().toString(),
                            etLongitude.getText().toString(),
                            etDate.getText().toString(),
                            etTime.getText().toString(),
                            rbSeeing.getText().toString(),
                            etInstrument.getText().toString(),
                            etMagnification.getText().toString(),
                            etFilter.getText().toString(),
                            etComment.getText().toString());
                }
                finish();
            }
        });

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

        etTime.setClickable(true);
        etTime.setLongClickable(false);
        etTime.setInputType(InputType.TYPE_NULL);

        etDate.setClickable(true);
        etDate.setLongClickable(false);
        etDate.setInputType(InputType.TYPE_NULL);

        etDate.setOnClickListener(v -> {

            DatePickerDialog
                    dialog=
                    new DatePickerDialog(AddObsLogBook.this, (view, year1, month1, dayOfMonth) -> {

                        month1=
                                month1 + 1;
                        String
                                date=
                                dayOfMonth + "/" + month1 + "/" + year1;
                        etDate.setText(date);

                    }, year, month, day);
            dialog.show();

        });

        etTime.setOnClickListener(v -> {
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
                    new TimePickerDialog(AddObsLogBook.this, (timePicker, selectedHour, selectedMinute) -> etTime.setText(selectedHour + ":" + selectedMinute), hour, minute, true);
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();

        });

        fusedLocationProviderClient=
                LocationServices.getFusedLocationProviderClient(AddObsLogBook.this);

        obslogBookPageEvt(SUtils.getString(etObject),
                SUtils.getString(etObserver),
                SUtils.getString(etLatitude) + "," + SUtils.getString(etLongitude));

        btnGenerate.setOnClickListener(view -> {

            if (ActivityCompat.checkSelfPermission(AddObsLogBook.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(AddObsLogBook.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                getLocation();

            } else {
                ActivityCompat.requestPermissions(AddObsLogBook.this
                        , new String[]{Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION}
                        , 100);
            }
            Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();

        });
        
//        btn_save_log.setOnClickListener(view -> {
//            SQLiteDatabase db = logbookdb.getWritableDatabase();
//            db.execSQL("insert into logbook (object, observer, latitude, longitude, date, time, seeing, instrument, magnification, filter, comment) values ('" +
//                    et_object_name.getText().toString() + "','" +
//                    et_observer.getText().toString() + "','" +
//                    tv_latitude.getText().toString() + "','" +
//                    tv_longitude.getText().toString() + "','" +
//                    et_date.getText().toString() + "','" +
//                    et_time.getText().toString() + "','" +
//                    rg_seeing.getContext().toString() + "','" +
//                    et_instrument.getText().toString() + "','" +
//                    et_magnification.getText().toString() + "','" +
//                    et_filter.getText().toString() + "','" +
//                    et_comment.getText().toString() + "')");
//            Toast.makeText(AddObsLogBook.this, "Data Saved", Toast.LENGTH_SHORT).show();
//            ObsLogBook.olb.refreshDisplayLogbook();
//            finish();
//        });
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
                    etLatitude.setText(String.valueOf(location.getLatitude()));
                    etLongitude.setText(String.valueOf(location.getLongitude()));
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
                                    etLatitude.setText(String.valueOf(location1.getLatitude()));
                                    etLongitude.setText(String.valueOf(location1.getLongitude()));
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


