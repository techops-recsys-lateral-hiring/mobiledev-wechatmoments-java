package com.example.wechatmoments.presenter;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.wechatmoments.data.ModuleInterface;
import com.example.wechatmoments.data.entity.Tweet;
import com.example.wechatmoments.data.entity.User;
import com.example.wechatmoments.view.ViewInterface;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    private ViewInterface view;

    private ModuleInterface module;

    private Presenter presenter;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void before() {
        view = Mockito.mock(ViewInterface.class);
        module = Mockito.mock(ModuleInterface.class);

        presenter = new Presenter();
        presenter.setView(view);
        presenter.setDataModule(module);
    }

    @Test
    public void test_load_data() {
        presenter.loadData();

        verify(module, times(0)).getUser("smith");
        verify(module, times(1)).getTweets("smith");
    }

    @Test
    public void test_load_user_success() {
        doAnswer(invocation -> {
            presenter.loadUserSuccess(new User());
            return null;
        }).when(module).getUser(anyString());

        presenter.loadData();

        verify(view, times(1)).onUserLoaded(new User());
    }

    @Test
    public void test_load_user_fail() {
        doAnswer(invocation -> {
            presenter.loadUserFailed();
            return null;
        }).when(module).getUser(anyString());

        presenter.loadData();

        verify(view, times(1)).onUserLoadFailed();
    }

    @Test
    public void test_load_tweets() {
        doAnswer(invocation -> {
            Tweet tweet0 = new Tweet();
            Tweet tweet1 = new Tweet();
            Tweet tweet2 = new Tweet();
            Tweet tweet3 = new Tweet();
            Tweet tweet4 = new Tweet();
            Tweet tweet5 = new Tweet();
            Tweet tweet6 = new Tweet();

            List<Tweet> tweets = new ArrayList<>();
            tweets.add(tweet0);
            tweets.add(tweet1);
            tweets.add(tweet2);
            tweets.add(tweet3);
            tweets.add(tweet4);
            tweets.add(tweet5);
            tweets.add(tweet6);

            presenter.loadTweetsSuccess(tweets);

            return null;
        }).when(module).getTweets(anyString());

        presenter.loadData();

        Assert.assertEquals(6, presenter.getBackUpTweets().size());
        Assert.assertEquals(5, presenter.getFirstTweets().size());
    }
}