package com.example.wechatmoments.view;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.databinding.RecyclerViewItemBinding;

public class ViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerViewItemBinding binding;

    public ViewHolder(RecyclerViewItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void populate(Tweet tweet) {
        binding.content.setText(tweet.getContent());
        binding.comments.notifyDataSetChanged();
    }
}
