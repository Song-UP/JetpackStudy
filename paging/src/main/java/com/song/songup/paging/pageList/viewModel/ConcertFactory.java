package com.song.songup.paging.pageList.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.song.songup.paging.pageList.dataSource.ConcertDataSource;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/13 9:28
 * 修改备注：
 */
public class ConcertFactory extends DataSource.Factory<Integer, String> {
    private MutableLiveData<ConcertDataSource> mutableLiveData = new MutableLiveData<>();

    @Override
    public DataSource<Integer, String> create() {
        ConcertDataSource concertDataSource = new ConcertDataSource();
        mutableLiveData.postValue(concertDataSource);
        return concertDataSource;
    }
}
