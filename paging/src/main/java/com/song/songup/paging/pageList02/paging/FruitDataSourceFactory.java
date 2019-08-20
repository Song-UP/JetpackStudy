package com.song.songup.paging.pageList02.paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
;import com.song.songup.paging.pageList02.been.FruitBeen;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/14 20:01
 * 修改备注：
 */
public class FruitDataSourceFactory extends DataSource.Factory<Integer, FruitBeen> {

    private MutableLiveData<FruitDataSource>  liveData = new MutableLiveData<>();

    //LivePagedListBuilder.create（)方法调用的
    @Override
    public DataSource<Integer, FruitBeen> create() {
        FruitDataSource fruitDataSource = new FruitDataSource();
        liveData.postValue(fruitDataSource);

        return fruitDataSource;
    }
}
