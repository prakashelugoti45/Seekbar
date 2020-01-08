package com.app.stamuraitask.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.app.stamuraitask.Models.UserRating;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */

@Database(entities = {UserRating.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
