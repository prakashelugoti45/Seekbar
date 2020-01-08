package com.app.stamuraitask.Models;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class UserRatingLiveData extends AndroidViewModel {

    private MutableLiveData<List<UserRating>> mFavs;

    UserRatingLiveData(Application application) {
        super(application);
    }

    public MutableLiveData<List<UserRating>> getFavs(List<UserRating> userRatings) {
        if (mFavs == null) {
            mFavs = new MutableLiveData<>();
            loadFavs(userRatings);
        }

        return mFavs;
    }

    private void loadFavs(List<UserRating> userRatings) {
        mFavs.setValue(userRatings);
    }


    public void addFav(List<UserRating> oldRatings,UserRating newRating) {
        List<UserRating> allRatings = new ArrayList<>();
        allRatings.add(newRating);
        allRatings.addAll(oldRatings);
        mFavs.setValue(allRatings);
    }

}
