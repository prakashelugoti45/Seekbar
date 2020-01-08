package com.app.stamuraitask.RoomDB;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class RawQueries {
    public static String query_order_descending ="SELECT * FROM UserRating ORDER BY createdAt" +
            "" + " DESC";
    public static String query_order_ascending ="SELECT * FROM UserRating ORDER BY createdAt" +
            "" + " ASC";
}
