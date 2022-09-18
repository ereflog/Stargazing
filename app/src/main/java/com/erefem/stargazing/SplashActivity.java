package com.erefem.stargazing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.huawei.hms.ads.HwAds;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.util.Log;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AudioFocusType;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    // Ad display timeout interval, in milliseconds.
    private static final int AD_TIMEOUT = 10000;

    // Ad display timeout message flag.
    private static final int MSG_AD_TIMEOUT = 1001;

    /**
     * Pause flag.
     * On the splash ad screen:
     * Set this parameter to true when exiting the app to ensure that the app home screen is not displayed.
     * Set this parameter to false when returning to the splash ad screen from another screen to ensure that the app home screen can be displayed properly.
     */
    private boolean hasPaused = false;

    // Callback handler used when the ad display timeout message is received.
    private final Handler timeoutHandler = new Handler(msg -> {
        if (SplashActivity.this.hasWindowFocus()) {
            jump();
        }
        return false;
    });

    private SplashView splashView;

    private final SplashView.SplashAdLoadListener splashAdLoadListener = new SplashView.SplashAdLoadListener() {
        @Override
        public void onAdLoaded() {
            // Called when an ad is loaded successfully.
            Log.i(TAG, "SplashAdLoadListener onAdLoaded.");
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            // Called when an ad fails to be loaded.
            Log.i(TAG, "SplashAdLoadListener onAdFailedToLoad, errorCode: " + errorCode);
            jump();
        }

        @Override
        public void onAdDismissed() {
            // Called when the ad display is complete.
            Log.i(TAG, "SplashAdLoadListener onAdDismissed.");
            jump();
        }
    };

    private final SplashAdDisplayListener adDisplayListener = new SplashAdDisplayListener() {
        @Override
        public void onAdShowed() {
            // Called when an ad is displayed.
            Log.i(TAG, "SplashAdDisplayListener onAdShowed.");
        }

        @Override
        public void onAdClick() {
            // Called when an ad is clicked.
            Log.i(TAG, "SplashAdDisplayListener onAdClick.");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this);
        loadAd();
    }

    private void loadAd() {
        Log.i(TAG, "Start to load ad");
        // Lock the screen orientation on the device. Your app will automatically adapt to the screen orientation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        int orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        AdParam adParam = new AdParam.Builder().build();
        splashView = findViewById(R.id.splash_ad_view);
        splashView.setAdDisplayListener(adDisplayListener);

        String slotId;
        // Set the default slogan and the splash ad unit ID based on the screen orientation on the device.
        splashView.setSloganResId(R.drawable.stargazing_icon);
        slotId = getString(R.string.ad_id_splash);

        splashView.setLogo(findViewById(R.id.logo_area));

        // Set a logo image.
        splashView.setLogoResId(R.mipmap.ic_launcher);
        // Set logo description.
        splashView.setMediaNameResId(R.string.app_name);
        // Set the audio focus type for a video splash ad.
        splashView.setAudioFocusType(AudioFocusType.NOT_GAIN_AUDIO_FOCUS_WHEN_MUTE);

        splashView.load(slotId, orientation, adParam, splashAdLoadListener);
        Log.i(TAG, "End to load ad");

        // Remove the timeout message from the message queue.
        timeoutHandler.removeMessages(MSG_AD_TIMEOUT);
        // Send a delay message to ensure that the app home screen can be displayed when the ad display times out.
        timeoutHandler.sendEmptyMessageDelayed(MSG_AD_TIMEOUT, AD_TIMEOUT);
    }

    /**
     * Switch from the splash ad screen to the app home screen when the ad display is complete.
     */
    private void jump() {
        Log.i(TAG, "jump hasPaused: " + hasPaused);
        if (!hasPaused) {
            hasPaused = true;
            Log.i(TAG, "jump into application");

            startActivity(new Intent(SplashActivity.this, HomeActivity.class));

            Handler mainHandler = new Handler();
            mainHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        }
    }

    /**
     * Set this parameter to true when exiting the app to ensure that the app home screen is not displayed.
     */
    @Override
    protected void onStop() {
        Log.i(TAG, "SplashActivity onStop.");
        // Remove the timeout message from the message queue.
        timeoutHandler.removeMessages(MSG_AD_TIMEOUT);
        hasPaused = true;
        super.onStop();
    }

    /**
     * Called when returning to the splash ad screen from another screen to access the app home screen.
     */
    @Override
    protected void onRestart() {
        Log.i(TAG, "SplashActivity onRestart.");
        super.onRestart();
        hasPaused = false;
        jump();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "SplashActivity onDestroy.");
        super.onDestroy();
        if (splashView != null) {
            splashView.destroyView();
        }
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "SplashActivity onPause.");
        super.onPause();
        if (splashView != null) {
            splashView.pauseView();
        }
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "SplashActivity onResume.");
        super.onResume();
        if (splashView != null) {
            splashView.resumeView();
        }
    }
}