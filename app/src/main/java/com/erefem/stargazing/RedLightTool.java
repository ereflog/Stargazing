package com.erefem.stargazing;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Objects;

public class RedLightTool extends AppCompatActivity {

    private SeekBar seekBar;
    private int brightness;
    private ContentResolver contentResolver;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.red_light_tool);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        contentResolver = getContentResolver();
        window = getWindow();
        boolean success = true;

        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (Settings.System.canWrite(getApplicationContext())){
                Toast.makeText(this, "You can change the brightness", Toast.LENGTH_SHORT).show();
            }else{
//                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//                intent.setData(Uri.parse("package" + getApplication().getPackageName()));
//                startActivity(intent);
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS)
                        .setData(Uri.parse("package:" + getApplication().getPackageName()))
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //Log.d(TAG, "Open activity new task");
            }
        }

        try {
            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
            seekBar.setProgress(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brightness = progress;
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS,brightness);
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.screenBrightness = brightness / (float) 300;
                window.setAttributes(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}