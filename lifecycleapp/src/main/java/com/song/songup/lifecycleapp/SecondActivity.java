package com.song.songup.lifecycleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.song.songup.lifecycleapp.lifecycle.MyDefaultObserve;
import com.song.songup.lifecycleapp.lifecycle.MyLifecycleObserver;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/7 12:34
 * 修改备注：
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getLifecycle().addObserver(new MyLifecycleObserver());
        getLifecycle().addObserver(new MyDefaultObserve());
    }
}
