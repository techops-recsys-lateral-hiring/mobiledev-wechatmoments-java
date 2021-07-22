package com.example.wechatmoments.presenter;

import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.data.entity.User;

import java.util.List;

public interface PresenterInterface {

    void loadData();

    void loadTweetsSuccess(List<Tweet> tweets);

    void loadTweetsFailed();

    void loadUserSuccess(User user);

    void loadUserFailed();

    void refreshTweets();

    void loadMoreTweets();
}
