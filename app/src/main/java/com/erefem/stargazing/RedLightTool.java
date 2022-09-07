package com.erefem.stargazing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Objects;

public class RedLightTool extends AppCompatActivity {

    SeekBar seekBar;
    boolean success = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.red_light_tool);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(255);
        seekBar.setProgress(getBrightness());

        getPermission();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser && success){
                    setBrightness(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(!success){
                    Toast.makeText(RedLightTool.this, "Permission not granted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setBrightness(int brightness){
        if (brightness < 0){
            brightness = 0;
        } else if (brightness > 255){
            brightness = 255;
        }

        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);

    }

    private int getBrightness(){
        int brightness = 255;
        try{
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e){
            e.printStackTrace();
        }
        return brightness;
    }

    private void getPermission(){
        boolean value;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            value = Settings.System.canWrite(getApplicationContext());
            if (value){
                success = true;
            } else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
                startActivityForResult(intent, 1000);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean value = Settings.System.canWrite(getApplicationContext());
            if (value) {
                success = true;
            } else {
                Toast.makeText(this, "Permission not granted!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}