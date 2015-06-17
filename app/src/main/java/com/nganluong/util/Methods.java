package com.nganluong.util;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nganluong.config.Variables;

/**
 * Created by DucChinh on 6/17/2015.
 */
public class Methods {

    public static void initVariables(Context pContext) {
        Variables.objFont = Typeface.createFromAsset(pContext.getAssets(), "font/RobotoCondensed-Regular.ttf");
    }

    public static boolean checkInternet(Context pContext) {
        ConnectivityManager cm = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnectedOrConnecting() && netInfo.isConnected() && netInfo.isAvailable());
    }
}
