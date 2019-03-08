package com.thanosfisherman.wifiutils.wifiConnect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef({WifiConnectErrorType.NO_ERROR, WifiConnectErrorType.ENABLE_WIFI_FAIL, WifiConnectErrorType.WRONG_PASSWORD,
        WifiConnectErrorType.CONNECT_WIFI_FAIL, WifiConnectErrorType.SSID_NOT_FOUND})
@Retention(RetentionPolicy.SOURCE)
public @interface WifiConnectErrorType {
    int NO_ERROR = 0;
    int ENABLE_WIFI_FAIL = 1;
    int WRONG_PASSWORD = 2;
    int CONNECT_WIFI_FAIL = 3;
    int SSID_NOT_FOUND = 4;
}
