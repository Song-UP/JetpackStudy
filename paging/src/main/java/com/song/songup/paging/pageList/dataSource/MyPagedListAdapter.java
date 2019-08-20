package com.song.songup.paging.pageList.dataSource;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.song.songup.paging.R;
import com.song.songup.paging.adapter.BaseRCViewHold;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/13 9:43
 * 修改备注：
 */
public class MyPagedListAdapter extends PagedListAdapter<String, BaseRCViewHold> {
    Context context;
    public MyPagedListAdapter(Context context) {
        super(DiFF_CALLBACK);
        this.context = context;
    }
    public MyPagedListAdapter() {
        super(DiFF_CALLBACK);
    }


    protected MyPagedListAdapter(@NonNull AsyncDifferConfig<String> config) {
        super(config);
    }

    @NonNull
    @Override
    public BaseRCViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return BaseRCViewHold.get(context,viewGroup, R.layout.listitem_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRCViewHold baseRCViewHold, int i) {
        String text = getItem(i);
        baseRCViewHold.setText(R.id.textview,text);

    }


    private static DiffUtil.ItemCallback<String> DiFF_CALLBACK = new DiffUtil.ItemCallback<String>() {
        @Override
        public boolean areItemsTheSame(@NonNull String oldConcert, @NonNull String newConcert) {//item 是否属于同一类
            return oldConcert.equals(newConcert);
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldConcert, @NonNull String newConcert) {//内容是否完全一致
            return oldConcert.equals(newConcert);
        }
    };
}
