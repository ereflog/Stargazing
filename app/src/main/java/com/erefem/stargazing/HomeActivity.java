package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        listView = findViewById(R.id.listview);

//        String[] values = new String[]{
//                "Focal Length/Ratio","Magnification","Field of View","Telescope Capabilities",
//                "Binocular Calculators","CCD Calculators","CCD Suitability","CCD Filter Size",
//                "Guidescope Calculators", "Unit Converter", "Observation Log Book",
//                "Weather Forecast", "Red Light", "About", "Credit and Data Source",
//                "Privacy Policy"
//        };

        String[] titles = new String[]{
                getString(R.string.focal_calc_title),
                getString(R.string.magnification_calc_title),
                getString(R.string.field_of_view_calc_title),
                getString(R.string.telescope_capabilities_calc_title),
                getString(R.string.binocular_calc_title),
                getString(R.string.ccd_calc_title),
                getString(R.string.ccd_telescope_combination_calc_title),
                getString(R.string.ccd_filter_size_calc_title),
                getString(R.string.guidescope_calc_title),
                getString(R.string.unit_converter_title),
                getString(R.string.obs_log_book_title),
                getString(R.string.weather_forecast_title),
                getString(R.string.red_light_tool_title),
                getString(R.string.about_title),
                getString(R.string.credit_and_data_source_title),
                getString(R.string.privacy_policy_title)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(  this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1, titles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(view.getContext(),FocalLenghtRatioCalc.class);
                    startActivity(intent);
                }
                if (i == 1){
                    Intent intent = new Intent(view.getContext(),MagnificationCalc.class);
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent(view.getContext(),FieldOfViewCalc.class);
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent(view.getContext(),TelescopeCapabilities.class);
                    startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent(view.getContext(),BinocularCalc.class);
                    startActivity(intent);
                }
                if (i == 5){
                    Intent intent = new Intent(view.getContext(),CCD_Calc.class);
                    startActivity(intent);
                }
                if (i == 6){
                    Intent intent = new Intent(view.getContext(),CCDTelescopeCombinationCalc.class);
                    startActivity(intent);
                }
                if (i == 7){
                    Intent intent = new Intent(view.getContext(),CCD_FilterSizeCalc.class);
                    startActivity(intent);
                }
                if (i == 8){
                    Intent intent = new Intent(view.getContext(),GuidescopeCalc.class);
                    startActivity(intent);
                }
                if (i == 9){
                    Intent intent = new Intent(view.getContext(),UnitConverter.class);
                    startActivity(intent);
                }
                if (i == 10){
                    Intent intent = new Intent(view.getContext(),ObsLogBook.class);
                    startActivity(intent);
                }
                if (i == 11){
                    Intent intent = new Intent(view.getContext(),WeatherForecast.class);
                    startActivity(intent);
                }
                if (i == 12){
                    Intent intent = new Intent(view.getContext(),RedLightTool.class);
                    startActivity(intent);
                }
                if (i == 13){
                    Intent intent = new Intent(view.getContext(),About.class);
                    startActivity(intent);
                }
                if (i == 14){
                    Intent intent = new Intent(view.getContext(),CreditAndDataSource.class);
                    startActivity(intent);
                }
                if (i == 15){
                    Intent intent = new Intent(view.getContext(),PrivacyPolicy.class);
                    startActivity(intent);
                }
            }
        });

    }
}