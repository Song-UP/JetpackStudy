package com.song.songup.paging.pageList.dataSource;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/13 9:08
 * 修改备注：
 */
public class ConcertDataSource extends PositionalDataSource<String> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<String> callback) {
        callback.onResult(getData(0,20),0,2000);

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<String> callback) {
        callback.onResult(getData(params.startPosition,params.loadSize));

    }


    public List<String> getData(int startPostion, int pageSize){
        List<String> list = new ArrayList<>();
        for (int i = startPostion; i<pageSize; i++){
            list.add("当前是\t"+i);
        }
        return list;
    }
}
