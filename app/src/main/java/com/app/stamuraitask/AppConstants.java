package com.app.stamuraitask;

import android.content.Intent;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class AppConstants {

    //lowerlimit <upperlimit
    public static int lowerLimit = 2;
    public static int upperLimit = 6;
    public final static int PAGE_BUTTON = 0;
    public final static int PAGE_SLIDER = 1;
    public final static int PAGE_RATINGS_LIST = 2;
    public final static int TOTAL_TABS = 3;
//
//
//    public static int getLowerLimit() {
//        return lowerLimit;
//    }
//
//    public static int getUpperLimit() {
//        return upperLimit;
//    }

    //next page/previous page
    public enum LayoutDirection {
        FORWARD("FORWARD", 1),
        BACK("BACK", 2)
        ;

        private String stringValue;
        private int intValue;
        private LayoutDirection(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }
}

