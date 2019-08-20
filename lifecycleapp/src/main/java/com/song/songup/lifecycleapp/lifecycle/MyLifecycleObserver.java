package com.song.songup.lifecycleapp.lifecycle;

import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/7 13:10
 * 修改备注：
 */
public class MyLifecycleObserver extends BaseLifecycleObserver {
    private final String TAG = MyLifecycleObserver.class.getSimpleName();
    @Override
    public void onCreate(LifecycleOwner owner) {
        log("onCreate()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onStart( LifecycleOwner owner) {
        log("onStart()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onResume( LifecycleOwner owner) {
        log("onResume()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onPause( LifecycleOwner owner) {
        log("onPause()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onStop( LifecycleOwner owner) {
        log("onStop()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    @Override
    public void onDestroy( LifecycleOwner owner) {
        log("onDestroy()\t当前生命状态:"+owner.getLifecycle().getCurrentState().name()+"\n");
    }

    private  void log(String info){
        Log.e(TAG,info);
    }
}
