package com.app.stamuraitask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.stamuraitask.AppConstants;
import com.app.stamuraitask.Constants.Utils;
import com.app.stamuraitask.Interfaces.PageSelectCallback;
import com.app.stamuraitask.R;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {
    Button btnRate;
    PageSelectCallback pageSelectCallback;

    public ButtonFragment(PageSelectCallback pageSelectCallback) {
        this.pageSelectCallback = pageSelectCallback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.button_layout, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view == btnRate) {
            Utils.proceed(pageSelectCallback,AppConstants.PAGE_BUTTON,
                    AppConstants.LayoutDirection.FORWARD);
        }
    }

    private void initViews(View rootView) {
        btnRate = rootView.findViewById(R.id.btnRate);
        btnRate.setText(getString(R.string.rate)+" "+AppConstants.lowerLimit+
                getString(R.string.to)+AppConstants.upperLimit);
        btnRate.setOnClickListener(this);
    }

}
