package com.app.stamuraitask.Interfaces;

import com.app.stamuraitask.AppConstants;
import com.app.stamuraitask.Models.UserRating;

import java.util.List;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public interface OnUserDataFetched {
    void onDataFetched(List<UserRating> userRatings);
}
