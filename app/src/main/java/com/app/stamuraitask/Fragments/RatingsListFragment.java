package com.app.stamuraitask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.stamuraitask.Adapters.RatingAdapter;
import com.app.stamuraitask.AppConstants;
import com.app.stamuraitask.Constants.Utils;
import com.app.stamuraitask.Interfaces.DataUpdateListener;
import com.app.stamuraitask.Interfaces.OnUserDataFetched;
import com.app.stamuraitask.Interfaces.PageSelectCallback;
import com.app.stamuraitask.Models.UserRating;
import com.app.stamuraitask.Models.UserRatingLiveData;
import com.app.stamuraitask.R;
import com.app.stamuraitask.RoomDB.DBOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class RatingsListFragment extends Fragment implements View.OnClickListener,
        OnUserDataFetched, DataUpdateListener {
    PageSelectCallback pageSelectCallback;
    ImageView imgBackArrow;
    RecyclerView rvRatings;
    TextView tvNoRatingsFound;
    LinearLayoutManager linearLayoutManager;
    RatingAdapter ratingAdapter ;

    public RatingsListFragment(PageSelectCallback pageSelectCallback) {
        this.pageSelectCallback = pageSelectCallback;
    }

    public void test(){
        Utils.showLongToast("hello");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.ratings_layout, container, false);

        initViews(rootView);
        initData();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(view==imgBackArrow){
            Utils.proceed(pageSelectCallback,AppConstants.PAGE_RATINGS_LIST,
                    AppConstants.LayoutDirection.BACK);
        }
    }

    @Override
    public void onDataFetched(List<UserRating> userRatings) {
        if(ratingAdapter!=null){
         if(userRatings!=null&&userRatings.size()>0){
             rvRatings.setVisibility(View.VISIBLE);
             tvNoRatingsFound.setVisibility(View.GONE);
             ratingAdapter.updateInfo(userRatings);
             rvRatings.setAdapter(ratingAdapter);
         }else {
             rvRatings.setVisibility(View.GONE);
             tvNoRatingsFound.setVisibility(View.VISIBLE);
         }
        }
    }

    @Override
    public void onInsert() {
        rvRatings.setAdapter(null);
        DBOperation.getUserRatings(this);
    }

    private void initViews(View rootView) {
        imgBackArrow = rootView.findViewById(R.id.imgBackArrow);
        rvRatings = rootView.findViewById(R.id.rvRatings);
        tvNoRatingsFound = rootView.findViewById(R.id.tvNoRatingFound);
        setRecyclerviewAttributes();
        imgBackArrow.setOnClickListener(this);
    }

    private void setRecyclerviewAttributes() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvRatings.setHasFixedSize(true);
        rvRatings.setLayoutManager(linearLayoutManager);
        rvRatings.setNestedScrollingEnabled(false);
        rvRatings.setHasFixedSize(false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvRatings.getContext(),
                linearLayoutManager.getOrientation());
        rvRatings.addItemDecoration(dividerItemDecoration);
    }

    private void initData() {
        ratingAdapter = new RatingAdapter(getActivity(),new ArrayList<UserRating>());
        DBOperation.getUserRatings(this);
    }

}
