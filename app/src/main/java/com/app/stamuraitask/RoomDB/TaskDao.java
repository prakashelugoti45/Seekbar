package com.app.stamuraitask.RoomDB;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.app.stamuraitask.Models.UserRating;

import java.util.List;

@Dao
public interface TaskDao {

//    @Query("SELECT rating, date, time, createdAt as mathResult from UserRating " +
//            "order by mathResult desc")
    @Query("SELECT * FROM UserRating")
    List<UserRating> getAll();

    //this is a raw query to fetch latest first
    @RawQuery
    List<UserRating> runtimeQuery(SupportSQLiteQuery sortQuery);

    @Insert
    void insert(UserRating task);

    @Delete
    void delete(UserRating task);

    @Update
    void update(UserRating task);
}
