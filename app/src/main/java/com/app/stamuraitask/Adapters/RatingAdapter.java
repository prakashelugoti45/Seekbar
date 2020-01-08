package com.app.stamuraitask.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.app.stamuraitask.Models.UserRating;
import com.app.stamuraitask.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prakash Reddy on 1/8/2020.
 */
public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {
    private List<UserRating> listdata;
    private Activity activity;

    // RecyclerView recyclerView;
    public RatingAdapter(Activity activity, List<UserRating> listdata) {
        this.activity = activity;
        this.listdata = listdata;
    }

    public void updateInfo(List<UserRating> listdata){
        this.listdata = new ArrayList<>();
        this.listdata.addAll(listdata);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_rating, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RatingAdapter.ViewHolder holder, int position) {
        final UserRating rating = listdata.get(position);
        holder.tvRating.setText(rating.getRating());
        holder.tvDate.setText(rating.getDate());
        holder.tvTime.setText(rating.getTime());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRating;
        public TextView tvDate;
        public TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }
}
