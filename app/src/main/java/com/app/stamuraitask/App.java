package com.app.stamuraitask;

import android.app.Application;
import android.content.Context;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class App extends Application {

    private static App mInstance;
    private String TAG = "ActivityLifecycle";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public static Context getContext(){
        return getInstance().getApplicationContext();
    }

}
