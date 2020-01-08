package com.app.stamuraitask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.app.stamuraitask.Adapters.FragmentsAdapter;
import com.app.stamuraitask.Fragments.FragmentInstance;
import com.app.stamuraitask.Interfaces.DataUpdateListener;
import com.app.stamuraitask.Interfaces.PageSelectCallback;
import com.app.stamuraitask.UI.SeekbarWithIntervals;

public class MainActivity extends AppCompatActivity implements PageSelectCallback {

    ViewPager viewPager;
    int currentPagePosition;
    FragmentsAdapter fragmentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onPageSelected(int pagePosition, AppConstants.LayoutDirection layoutDirection) {
        if (layoutDirection != null) {
            switch (layoutDirection) {
                case FORWARD:
                    viewPager.setCurrentItem(pagePosition + 1);
                    break;
                case BACK:
                    viewPager.setCurrentItem(pagePosition - 1);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        currentPagePosition = viewPager.getCurrentItem();
        if(currentPagePosition>0){
            viewPager.setCurrentItem(currentPagePosition-1);
        }else {
            FragmentInstance.resetFragments();
            super.onBackPressed();
            finish();
        }
    }

    private void initViews() {
        fragmentsAdapter = new FragmentsAdapter(this, getSupportFragmentManager(),
                AppConstants.TOTAL_TABS, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(fragmentsAdapter);

        //comment this if you want swiping
        disableSwipping();
        //updateData();
    }

    private void disableSwipping() {
        viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
    }

    public void updateData() {
        DataUpdateListener fragmentToHide =
                (DataUpdateListener)fragmentsAdapter.getItem(AppConstants.PAGE_RATINGS_LIST);
        fragmentToHide.onInsert();
    }

}
