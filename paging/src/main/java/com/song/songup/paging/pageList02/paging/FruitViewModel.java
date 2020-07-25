package com.song.songup.paging.pageList02.paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.song.songup.paging.pageList02.been.FruitBeen;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/15 10:18
 * 修改备注：
 */
public class FruitViewModel extends ViewModel {
    private Executor myExecutable = Executors.newSingleThreadExecutor();

    /** 通过config  设置PageList 从DataSource 加载数据方式 **/
    private PagedList.Config myPagedListConfig = new PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)//设置首次加载的数量
            .setPageSize(10)//设置每一页加载的数量
            .setPrefetchDistance(10)//设置距离多少，开始加载下一页
            .setEnablePlaceholders(false)//是否设置null占位符
            .build();

    private DataSource.Factory<Integer, FruitBeen> myFruitDataSource = new FruitDataSourceFactory();

    /** 通知UI改变 **/
    private LiveData<PagedList<FruitBeen>> fruitLiveDataOfPageList =
            new LivePagedListBuilder(myFruitDataSource, myPagedListConfig)
            .setFetchExecutor(myExecutable)//设置Executor执行器线程
            .build();

    public LiveData<PagedList<FruitBeen>> getLiveData() {
        return fruitLiveDataOfPageList;
    }

    /**
     *数据刷新方法、
     *由于利用MutableLiveData机制，fruitList可以快速相应变化
     */
    public void invaliadataDataSource(){
        PagedList<FruitBeen> pagedList = fruitLiveDataOfPageList.getValue();
        if (pagedList != null){
            pagedList.getDataSource().invalidate();
        }
    }



}
