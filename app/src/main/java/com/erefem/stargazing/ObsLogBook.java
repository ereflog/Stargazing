package com.erefem.stargazing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.erefem.stargazing.adapter.LogbookAdapter;
import com.erefem.stargazing.database.AppDatabase;
import com.erefem.stargazing.database.entitas.Logbook;
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
    private AppDatabase database;
    private LogbookAdapter logbookAdapter;
    private List<Logbook> list = new ArrayList<>();
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obs_log_book);
        recyclerView = findViewById(R.id.rvLogBook);
        setTitle("Observation Log Book");
        Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.logbookDao().getAll());
        logbookAdapter = new LogbookAdapter(getApplicationContext(),list);
        logbookAdapter.setDialog(new LogbookAdapter.Dialog() {
            @Override
            public void onClick(int position) {
                final CharSequence[] dialogItem = {"Edit","Delete"};
                dialog = new AlertDialog.Builder(ObsLogBook.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(ObsLogBook.this,AddObsLogBook.class);
                                intent.putExtra("uid", list.get(position).uid);
                                startActivity(intent);
                                break;
                            case 1:
                                Logbook logbook = list.get(position);
                                database.logbookDao().delete(logbook);
                                onStart();

                                Toast.makeText(getApplicationContext(), "Data has been delete (Please Refresh)", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                dialog.show();

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(logbookAdapter);

        FloatingActionButton fab1 = findViewById(R.id.fab1);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ObsLogBook.this,AddObsLogBook.class);
                startActivity(intent);

            }

        });


    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onStart(){
        super.onStart();
        list.addAll(database.logbookDao().getAll());
        logbookAdapter.notifyDataSetChanged();
    }


}

