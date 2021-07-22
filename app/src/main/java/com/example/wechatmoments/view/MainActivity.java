package com.example.wechatmoments.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wechatmoments.R;
import com.example.wechatmoments.imageloader.GlideImageLoader;
import com.lzy.ninegrid.NineGridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, new MainFragment())
                .commitAllowingStateLoss();
        NineGridView.setImageLoader(new GlideImageLoader());
    }
}