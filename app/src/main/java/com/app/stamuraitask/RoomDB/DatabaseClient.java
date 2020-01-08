package com.app.stamuraitask.RoomDB;

import android.content.Context;

import androidx.room.Room;

import com.app.stamuraitask.App;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;
    private static String DB_NAME = App.getContext().getPackageName();
    private AppDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, DB_NAME).build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
