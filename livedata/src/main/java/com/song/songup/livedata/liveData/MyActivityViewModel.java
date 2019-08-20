package com.song.songup.livedata.liveData;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/10 9:46
 * 修改备注：
 */
public class MyActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mCurrentName;
    public MyActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getLiveData(){
        if (mCurrentName == null){
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }


}
