package com.thanosfisherman.wifiutils.sample;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.thanosfisherman.wifiutils.WifiUtils;
import com.thanosfisherman.wifiutils.wifiConnect.WifiConnectErrorType;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 555);
        final Button button = findViewById(R.id.button);
        WifiUtils.enableLog(true);
        //TODO: CHECK IF LOCATION SERVICES ARE ON
        button.setOnClickListener(v -> connectWithWpa());
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private void connectWithWps() {
//        WifiUtils.withContext(getApplicationContext()).connectWithWps("d8:74:95:e6:f5:f8", "51362485")
//                .onConnectionWpsResult(this::checkResult).start();
//    }

    private void connectWithWpa() {
        String ote = "WeWorkk";
        String otePass = "P@ssw0rd";

        WifiUtils.withContext(getApplicationContext())
                .connectWith(ote, otePass)
                .setTimeout(40000)
                .onConnectionResult(this::checkResult)
                .start();
    }

    private void enableWifi() {
        WifiUtils.withContext(getApplicationContext()).enableWifi(this::checkEnableWifiResult);
        //or without the callback
        //WifiUtils.withContext(getApplicationContext()).enableWifi();
    }

    private void checkResult(@WifiConnectErrorType int errorType) {
        if (errorType == WifiConnectErrorType.NO_ERROR)
            Toast.makeText(MainActivity.this, "SUCCESS!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "EPIC FAIL! " + errorType, Toast.LENGTH_SHORT).show();
    }

    private void checkEnableWifiResult(boolean result) {
        if (result)
            Toast.makeText(MainActivity.this, "SUCCESS!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "EPIC FAIL!", Toast.LENGTH_SHORT).show();
    }
}
