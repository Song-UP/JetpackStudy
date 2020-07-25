package com.song.songup.paging.pageList;

//import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.song.songup.paging.R;
import com.song.songup.paging.pageList.dataSource.MyPagedListAdapter;
import com.song.songup.paging.pageList.SimpleDividerDecoration;
import com.song.songup.paging.pageList.viewModel.ConcertViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private MyPagedListAdapter myPagedListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPaging();
    }

    private void initView() {
        mRecycleview = (RecyclerView) findViewById(R.id.recycleview);


    }


    public void initPaging() {
        myPagedListAdapter = new MyPagedListAdapter(this);
//        ConcertViewModel concertViewModel = ViewModelProviders.of(this).get(ConcertViewModel.class);
//        concertViewModel.getConvertLiveData().observe(this, convert->{
//            myPagedListAdapter.submitList(convert);
//        });

        mRecycleview.setAdapter(myPagedListAdapter);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        mRecycleview.addItemDecoration(new SimpleDividerDecoration(this));
    }
}
