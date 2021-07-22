package com.example.wechatmoments.data;

import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.data.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeChatService {
    @GET("user/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("user/{username}/tweets")
    Call<List<Tweet>> getTweets(@Path("username") String username);
}
