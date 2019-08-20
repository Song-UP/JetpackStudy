package com.song.songup.paging.pageList02.paging;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.song.songup.paging.R;
import com.song.songup.paging.pageList02.been.FruitBeen;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/14 20:14
 * 修改备注：这个类里面获取数据
 */
public class FruitDataSource extends PositionalDataSource<FruitBeen> {

    private int[] imageArray = new int[]{R.drawable.apple_pic, R.drawable.banana_pic,
            R.drawable.cherry_pic, R.drawable.grape_pic, R.drawable.mango_pic,
            R.drawable.orange_pic, R.drawable.pear_pic, R.drawable.pineapple_pic,
            R.drawable.strawberry_pic, R.drawable.watermelon_pic};

    private String[] nameArray = new String[]{"apple", "banana",
            "cherry", "grape", "mango",
            "orange", "pear", "pineapple",
            "strawberry", "watermelon"};

    /**
     * 初始化加载内容
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<FruitBeen> callback) {
        final int startPosition = 0;
        List<FruitBeen> list = buildDataList(startPosition, params.requestedLoadSize);
        //将数据回调
        callback.onResult(list, 0);

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<FruitBeen> callback) {
        List<FruitBeen> list = buildDataList(params.startPosition, params.loadSize);
        callback.onResult(list);

    }

    private List<FruitBeen> buildDataList(int startPosition, int loadSize) {
        List<FruitBeen> list = new ArrayList<>();
        FruitBeen bean;
        for (int i = startPosition; i < startPosition + loadSize; i++) {
            bean = new FruitBeen();
            bean.setId(i);
            bean.setImage(imageArray[i % imageArray.length]);
            bean.setName(nameArray[i % nameArray.length]);
            list.add(bean);
        }
        return list;
    }
}
