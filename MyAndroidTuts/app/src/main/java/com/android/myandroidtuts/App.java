package com.android.myandroidtuts;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by akanksha on 8/1/17.
 */

public class App extends Application {

    public static App mInstance;
    private static SharedPreferences mPrefs;

    public static App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initSharedPreferences();
    }

    private void initSharedPreferences() {
        mPrefs = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
    }

    public static SharedPreferences getprefs() {
        return mPrefs;
    }

}
