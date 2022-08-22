package com.erefem.stargazing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class  ObsLogBook extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;

    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);
        setTitle("Observation Log Book");
        displayLogbook();
        Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();

        FloatingActionButton fab1 = findViewById(R.id.fab1);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ObsLogBook.this,AddObsLogBook.class);
                startActivity(intent);

            }

        });



    }

    private void displayLogbook() {
        recyclerView = findViewById(R.id.rvLogBook);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myModelList = new ArrayList<>();
        myModelList.add(new MyModel("Moon","John Doe", "112.123456,-7.123456","23/08/2022","1:47","Good","Camera","60x","Original","Blue Moon"));
        myModelList.add(new MyModel("Moon","John Travolta", "112.123456,-7.123456","23/08/2022","1:47","Good","Camera","60x","Original","Blue Moon"));
        customAdapter = new CustomAdapter(this, myModelList);
        recyclerView.setAdapter(customAdapter);
    }


}

