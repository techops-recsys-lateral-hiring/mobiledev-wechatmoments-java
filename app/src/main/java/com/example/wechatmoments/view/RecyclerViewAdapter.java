package com.example.wechatmoments.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.databinding.RecyclerViewItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Tweet> tweets = new ArrayList<>();

    public RecyclerViewAdapter() {
        super();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.populate(tweet);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemBinding binding = RecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void setData(List<Tweet> data) {
        tweets.clear();
        tweets.addAll(data);
        notifyDataSetChanged();
    }
}
