package com.song.songup.paging.pageList02;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.song.songup.paging.R;
import com.song.songup.paging.pageList02.been.FruitBeen;
import com.song.songup.paging.pageList02.paging.FruitAdapter;
import com.song.songup.paging.pageList02.paging.FruitViewModel;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/13 19:38
 * 修改备注：
 */
public class PagingActivity extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private SwipeRefreshLayout mRefreshSwipe;
    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paging_activity_main);
        initView();
    }


    public void initView() {

        mRecycleview = (RecyclerView) findViewById(R.id.recycleview);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter fruitAdapter = new FruitAdapter(this);
        mRecycleview.setAdapter(fruitAdapter);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecycleview.addItemDecoration(divider);

        mRefreshSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);


        //将数据与ViewModelProvider构造方法第一个参数传入的对象生命周期绑定。
        ViewModelProvider viewMoldelProvider = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication()));

        FruitViewModel fruitViewModel = viewMoldelProvider.get(FruitViewModel.class);
        //将数据(既被观察者)订阅给观察者。
        fruitViewModel.getLiveData().observe(this, new Observer<PagedList<FruitBeen>>() {
            @Override
            public void onChanged(@Nullable PagedList<FruitBeen> fruitBeens) {
                /** 刷新 Recycleview **/
                fruitAdapter.submitList(fruitBeens);
            }
        });
        mRefreshSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fruitViewModel.invaliadataDataSource();
                mRefreshSwipe.setRefreshing(false);

            }
        });
    }

    public void initPageList() {



    }
}
