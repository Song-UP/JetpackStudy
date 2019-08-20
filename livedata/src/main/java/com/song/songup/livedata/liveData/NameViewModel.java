package com.song.songup.livedata.liveData;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/5 13:04
 * 修改备注：
 */
public class NameViewModel extends ViewModel {
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getmCurrentName() {
        if (mCurrentName == null)
            mCurrentName = new MutableLiveData<>();
        return mCurrentName;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
