package com.thanosfisherman.wifiutils.wifiConnect;

public interface WifiConnectionCallback
{
    void successfulConnect();
    void errorConnect(@WifiConnectErrorType int errorType);
}
