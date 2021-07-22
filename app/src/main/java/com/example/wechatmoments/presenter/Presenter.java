package com.example.wechatmoments.presenter;

import static com.example.wechatmoments.data.Constants.LABEL;

import android.util.Log;

import com.example.wechatmoments.data.DataModule;
import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.data.entity.User;
import com.example.wechatmoments.view.ViewInterface;

import java.util.ArrayList;
import java.util.List;


public class Presenter implements PresenterInterface {

    private static final int INIT_NUM_OF_TWEETS = 5;

    private static final int TOTAL_NUM_OF_TWEETS = 15;

    private final ViewInterface viewInterface;

    private int record = INIT_NUM_OF_TWEETS;


    private final List<Tweet> firstTweets = new ArrayList<>();

    private final List<Tweet> initTweets = new ArrayList<>();

    private final List<Tweet> backUpTweets = new ArrayList<>();

    private final DataModule dataModule = new DataModule(this);

    public Presenter(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    public void loadData() {
        dataModule.getTweets("jsmith");
        dataModule.getUser("jsmith");
    }


    @Override
    public void loadTweetsSuccess(List<Tweet> tweets) {
        backUpTweets.addAll(tweets);

        for (int i = 0; i < INIT_NUM_OF_TWEETS; i++) {
            firstTweets.add(backUpTweets.get(i));
            viewInterface.onTweetsLoaded(firstTweets);
        }
        Log.i(LABEL, "loadTweetsSuccess");
    }

    @Override
    public void loadTweetsFailed() {
        viewInterface.onTweetsLoadFailed();
    }

    @Override
    public void loadUserSuccess(User user) {
        viewInterface.onUserLoaded(user);
    }

    @Override
    public void loadUserFailed() {
        viewInterface.onUserLoadFailed();
    }

    @Override
    public void refreshTweets() {
        Log.i(LABEL, "refreshTweets");

        if (backUpTweets.size() > 0) {
            Log.i(LABEL, "onRefresh on refreshTweets");
            record = INIT_NUM_OF_TWEETS;
            Log.i(LABEL, "onRefresh");
            initTweets.clear();
            for (int i = 0; i < record; i++) {
                initTweets.add(backUpTweets.get(i));
            }
            Log.i(LABEL, initTweets.toString());
            viewInterface.onTweetsLoaded(initTweets);
        }
    }

    @Override
    public void loadMoreTweets() {

        if (backUpTweets.size() > 0) {
            if (record < TOTAL_NUM_OF_TWEETS) {
                record = record + INIT_NUM_OF_TWEETS;
                initTweets.clear();
                Log.i(LABEL, "mBackUpTweets" + backUpTweets.toString());
                for (int i = 0; i < record; i++) {
                    initTweets.add(backUpTweets.get(i));
                }
                Log.i(LABEL, initTweets.toString());
                viewInterface.onTweetsLoaded(initTweets);
            }
        }
    }
}
