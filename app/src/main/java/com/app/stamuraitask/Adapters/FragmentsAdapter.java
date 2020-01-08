package com.app.stamuraitask.Adapters;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.app.stamuraitask.Fragments.FragmentInstance;
import com.app.stamuraitask.Interfaces.PageSelectCallback;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */

public class FragmentsAdapter extends FragmentPagerAdapter {

    int totalTabs;
    Activity activity;
    PageSelectCallback pageSelectCallback;
    // this is for fragment tabs
    public FragmentsAdapter(Activity activity, FragmentManager fm, int totalTabs,PageSelectCallback pageSelectCallback) {
        super(fm);
        this.activity = activity;
        this.totalTabs = totalTabs;
        this.pageSelectCallback = pageSelectCallback;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return  FragmentInstance.getButtonFragment(pageSelectCallback);
            case 1:
                return FragmentInstance.getSliderFragmen(pageSelectCallback);
            case 2:
                return  FragmentInstance.getRatingsFragment(pageSelectCallback);
            default:
                return null;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
