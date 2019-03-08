package com.thanosfisherman.wifiutils.wifiConnect;

public interface ConnectionSuccessListener
{
    void isSuccessful(@WifiConnectErrorType int errorType);
}
