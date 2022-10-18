package com.erefem.stargazing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import static com.huawei.hms.analytics.type.HAEventType.*;
import static com.huawei.hms.analytics.type.HAParamType.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    ListView listView;

    // TODO: Define a variable for the Analytics Kit instance.
    HiAnalyticsInstance instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        // TODO: Initialize Analytics Kit.
        // Enable Analytics Kit logging.
        HiAnalyticsTools.enableLog();
        // Generate an Analytics Kit instance.
        instance = HiAnalytics.getInstance(this);

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
                getString(R.string.imaging_guiding_ratio_calc_title),
                getString(R.string.unit_converter_title),
                getString(R.string.obs_log_book_title),
                getString(R.string.weather_forecast_title),
                getString(R.string.red_light_tool_title)
/*                getString(R.string.about_title),
                getString(R.string.credit_and_data_source_title),
                getString(R.string.privacy_policy_title)*/
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(  this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1, titles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                instance.setUserProfile("viewOnClick_homePageResult",instance.getAAID().getResult()); // Obtains the execution result of a task if it is completed.
                if (i == 0){
                    Intent intent = new Intent(view.getContext(),FocalLenghtRatioCalc.class);
                    reportPageEvt(FocalLenghtRatioCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 1){
                    Intent intent = new Intent(view.getContext(),MagnificationCalc.class);
                    reportPageEvt(MagnificationCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 2){
                    Intent intent = new Intent(view.getContext(),FieldOfViewCalc.class);
                    reportPageEvt(FieldOfViewCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 3){
                    Intent intent = new Intent(view.getContext(),TelescopeCapabilities.class);
                    reportPageEvt(TelescopeCapabilities.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent(view.getContext(),BinocularCalc.class);
                    reportPageEvt(BinocularCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 5){
                    Intent intent = new Intent(view.getContext(),CCD_Calc.class);
                    reportPageEvt(CCD_Calc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 6){
                    Intent intent = new Intent(view.getContext(),CCDTelescopeCombinationCalc.class);
                    reportPageEvt(CCDTelescopeCombinationCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 7){
                    Intent intent = new Intent(view.getContext(),CCD_FilterSizeCalc.class);
                    reportPageEvt(CCD_FilterSizeCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 8){
                    Intent intent = new Intent(view.getContext(),ImagingGuidingRatioCalc.class);
                    reportPageEvt(ImagingGuidingRatioCalc.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 9){
                    Intent intent = new Intent(view.getContext(),UnitConverter.class);
                    reportPageEvt(UnitConverter.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 10){
                    Intent intent = new Intent(view.getContext(),ObsLogBook.class);
                    reportPageEvt(ObsLogBook.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 11){
                    Intent intent = new Intent(view.getContext(),WeatherForecast.class);
                    reportPageEvt(WeatherForecast.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 12){
                    Intent intent = new Intent(view.getContext(),RedLightTool.class);
                    reportPageEvt(RedLightTool.class.getSimpleName());
                    startActivity(intent);
                }
                /*if (i == 13){
                    Intent intent = new Intent(view.getContext(),About.class);
                    reportPageEvt(About.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 14){
                    Intent intent = new Intent(view.getContext(),CreditAndDataSource.class);
                    reportPageEvt(CreditAndDataSource.class.getSimpleName());
                    startActivity(intent);
                }
                if (i == 15){
                    Intent intent = new Intent(view.getContext(),PrivacyPolicy.class);
                    reportPageEvt(PrivacyPolicy.class.getSimpleName());
                    startActivity(intent);
                }*/
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent1 = new Intent(HomeActivity.this, About.class);
                startActivity(intent1);
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(HomeActivity.this, CreditAndDataSource.class);
                startActivity(intent2);
                return true;
            case R.id.item3:
                Intent intent3 = new Intent(HomeActivity.this, PrivacyPolicy.class);
                startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reportPageEvt(String page) {
        // TODO: Report a psge event.
        // Event name: Page
        // Event parameters:
        //  -- page: String
        //  -- answerTime: String

        // Initialize parameters.
        Bundle bundle = new Bundle();
        bundle.putString("page",page);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        bundle.putString("answerTime",sdf.format(new Date()));

        // Report a custom event.
        instance.onEvent("Page", bundle);
    }
}