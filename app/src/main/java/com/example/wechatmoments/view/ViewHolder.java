package com.example.wechatmoments.view;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wechatmoments.R;
import com.example.wechatmoments.databinding.RecyclerViewItemBinding;
import com.example.wechatmoments.data.entity.Image;
import com.example.wechatmoments.data.entity.Tweet;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerViewItemBinding binding;

    public ViewHolder(RecyclerViewItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void populate(Tweet tweet) {
        binding.content.setText(tweet.getContent());
        binding.comments.setList(tweet.getComments());
        binding.comments.notifyDataSetChanged();
        ArrayList<ImageInfo> infoArrayList = new ArrayList<>();
        List<Image> imageList = tweet.getImages();
        if (imageList != null) {
            for (Image image : imageList) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setBigImageUrl(image.getUrl());
                imageInfo.setThumbnailUrl(image.getUrl());
                infoArrayList.add(imageInfo);
            }
        }
        binding.nineGridView.setAdapter(new NineGridViewClickAdapter(itemView.getContext(), infoArrayList) {
        });
        if (tweet.getSender() != null) {
            binding.senderNick.setText(tweet.getSender().getNick());
            Glide.with(itemView.getContext())
                    .load(tweet.getSender().getAvatar())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .into(binding.senderAvatar);
        }

    }
}
