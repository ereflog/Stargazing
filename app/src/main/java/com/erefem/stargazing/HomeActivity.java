package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ListView
            listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        listView = findViewById(R.id.listview);

        String[] values = new String[]{
                "Focal Length/Ratio","Magnification","Field of View","Telescope Capabilities",
                "Binocular Calculators","CCD Calculators","CCD Suitability","CCD Filter Size"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(  this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(view.getContext(),FocalLenghtRatio.class);
                    startActivity(intent);
                }
                if (i == 1){
                    Intent intent = new Intent(view.getContext(),MagnificationCalcActivity.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent(view.getContext(),FieldOfView.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent(view.getContext(),TelescopeCapabilities.class);
                    startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent(view.getContext(),BinocularCalculators.class);
                    startActivity(intent);
                }
                if (i == 5){
                    Intent intent = new Intent(view.getContext(),CCD_Calculators.class);
                    startActivity(intent);
                }
                if (i == 6){
                    Intent intent = new Intent(view.getContext(),CCD_Suitability.class);
                    startActivity(intent);
                }
                if (i == 7){
                    Intent intent = new Intent(view.getContext(),CCD_FilterSize.class);
                    startActivity(intent);
                }
            }
        });

    }
}