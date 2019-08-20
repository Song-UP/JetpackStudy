package com.song.songup.paging.pageList.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/13 9:34
 * 修改备注：
 */
public class ConcertViewModel extends ViewModel {
    private  LiveData<PagedList<String>> convertLiveData;
    private DataSource<Integer, String> dataSource;

    public ConcertViewModel() {
        ConcertFactory concertFactory = new ConcertFactory();
        dataSource = concertFactory.create();
        convertLiveData = new LivePagedListBuilder(concertFactory,20).build();
    }

    public void invalidateDataSource(){
        dataSource.invalidate();
    }

    public LiveData<PagedList<String>> getConvertLiveData() {
        return convertLiveData;
    }

}
