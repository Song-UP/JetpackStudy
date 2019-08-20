package com.song.songup.lifecycleapp.lifecycle;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/7 12:18
 * 修改备注：
 */
public class MyDefaultObserve implements DefaultLifecycleObserver {
    private final String TAG = MyDefaultObserve.class.getSimpleName();
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        log("onCreate()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        log("onStart()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        log("onResume()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        log("onPause()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        log("onStop()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        log("onDestroy()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    private  void log(String info){
        Log.e(TAG,info);
    }
}
