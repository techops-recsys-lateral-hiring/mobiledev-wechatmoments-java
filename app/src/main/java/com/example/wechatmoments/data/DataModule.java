package com.example.wechatmoments.data;

import static com.example.wechatmoments.data.Constants.LABEL;

import android.util.Log;

import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.data.entity.User;
import com.example.wechatmoments.presenter.PresenterInterface;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModule implements ModuleInterface {

    private final PresenterInterface callback;
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://thoughtworks-mobile-2018.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private final WeChatService service = retrofit.create(WeChatService.class);

    public DataModule(PresenterInterface presenterInterface) {
        this.callback = presenterInterface;
    }

    @Override
    public void getTweets(String username) {

        service.getTweets(username).enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Tweet>> call, Response<List<Tweet>> response) {
                Log.i(LABEL, "tweets response" + response);
                callback.loadTweetsSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<List<Tweet>> call, Throwable t) {
                callback.loadTweetsFailed();
            }
        });
    }

    @Override
    public void getUser(String username) {
        service.getUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                Log.i(LABEL, response.toString());
                callback.loadUserSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {
                callback.loadUserFailed();
            }
        });
    }
}
