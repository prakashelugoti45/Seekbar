package com.app.stamuraitask.Fragments;

import androidx.fragment.app.Fragment;

import com.app.stamuraitask.Interfaces.PageSelectCallback;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class FragmentInstance {
    static ButtonFragment buttonFragment;
    static SliderFragment sliderFragment;
    static RatingsListFragment ratingsListFragment;

    public static Fragment getButtonFragment(PageSelectCallback pageSelectCallback){
        if(buttonFragment==null){
            buttonFragment = new ButtonFragment(pageSelectCallback);
        }
        return buttonFragment;
    }
    public static Fragment getSliderFragmen(PageSelectCallback pageSelectCallback){
        if(sliderFragment==null){
            sliderFragment = new SliderFragment(pageSelectCallback);
        }
        return sliderFragment;
    }
    public static Fragment getRatingsFragment(PageSelectCallback pageSelectCallback){
        if(ratingsListFragment==null){
            ratingsListFragment = new RatingsListFragment(pageSelectCallback);
        }
        return ratingsListFragment;
    }

    public static void resetFragments(){
        buttonFragment = null;
        sliderFragment = null;
        ratingsListFragment = null;
    }
}
