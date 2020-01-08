package com.app.stamuraitask.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.stamuraitask.AppConstants;
import com.app.stamuraitask.Constants.Utils;
import com.app.stamuraitask.Interfaces.PageSelectCallback;
import com.app.stamuraitask.MainActivity;
import com.app.stamuraitask.Models.UserRating;
import com.app.stamuraitask.R;
import com.app.stamuraitask.RoomDB.DBOperation;
import com.app.stamuraitask.UI.SeekbarWithIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class SliderFragment extends Fragment implements View.OnClickListener {
    private SeekbarWithIntervals seekbarWithIntervals = null;
    PageSelectCallback pageSelectCallback;
    Button btnMyRatings;
    Button btnSubmit;
    ImageView imgBackArrow;

    public SliderFragment(PageSelectCallback pageSelectCallback) {
        this.pageSelectCallback = pageSelectCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.slider_layout, container, false);

        initViews(rootView);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        if(view==btnSubmit){
            submitRating();
        }
        if (view == btnMyRatings) {
            Utils.proceed(pageSelectCallback,AppConstants.PAGE_SLIDER,
                    AppConstants.LayoutDirection.FORWARD);
        }
        if(view==imgBackArrow){
            Utils.proceed(pageSelectCallback,AppConstants.PAGE_SLIDER,
                    AppConstants.LayoutDirection.BACK);
        }

    }

    private void initViews( View rootView) {
        btnMyRatings = rootView.findViewById(R.id.btnMyRatings);
        imgBackArrow = rootView.findViewById(R.id.imgBackArrow);
        btnSubmit = rootView.findViewById(R.id.btnSubmit);

        btnMyRatings.setOnClickListener(this);
        imgBackArrow.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        List<String> seekbarIntervals = getIntervals();
        getSeekbarWithIntervals(rootView).setIntervals(seekbarIntervals);
    }

    private void submitRating() {
        int progress = seekbarWithIntervals.getProgress()+AppConstants.lowerLimit;
//        if(progress==0){
//            Utils.showLongToast("Please select some rating before you rate!");
//            return;
//        }
        UserRating userRating = new UserRating();
        userRating.setRating(""+progress);
        userRating.setDate(Utils.getCurrentDate());
        userRating.setTime(Utils.getCurrentTime());
        userRating.setCreatedAt(System.currentTimeMillis());
        DBOperation.insertRating(userRating);
        seekbarWithIntervals.setProgress(0);
        if(((MainActivity)getActivity())!=null){
            ((MainActivity)getActivity()).updateData();
        }
    }

    private List<String> getIntervals() {
        return new ArrayList<String>() {{
            for(int i=AppConstants.lowerLimit;i<=AppConstants.upperLimit;i++){
                add(""+i);
            }
        }};
    }

    private SeekbarWithIntervals getSeekbarWithIntervals(View rootView) {
        if (seekbarWithIntervals == null) {
            seekbarWithIntervals =
                    (SeekbarWithIntervals) rootView.findViewById(R.id.seekbarWithIntervals);
        }
        return seekbarWithIntervals;
    }
}
