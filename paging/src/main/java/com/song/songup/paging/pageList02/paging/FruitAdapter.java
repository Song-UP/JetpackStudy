package com.song.songup.paging.pageList02.paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.song.songup.paging.R;
import com.song.songup.paging.adapter.BaseRCViewHold;
import com.song.songup.paging.pageList02.been.FruitBeen;

/**
 * @Description：内部已经做了异步刷新数据,所以只需要传入DiffUtil.ItemCallback就可以了
 * @Author：Song UP
 * @Date：2019/8/15 14:03
 * 修改备注：
 */
public class FruitAdapter extends PagedListAdapter<FruitBeen,BaseRCViewHold>{

    private Context context;

    public static DiffUtil.ItemCallback<FruitBeen> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FruitBeen>() {
                @Override
                public boolean areItemsTheSame(FruitBeen oldItem, FruitBeen newItem) {
                    return oldItem.getId() == newItem.getId();
                }
                @Override
                public boolean areContentsTheSame(FruitBeen oldItem, @NonNull FruitBeen newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public FruitAdapter(Context context /*,  AsyncDifferConfig<FruitBeen> asyncListDiff */) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public BaseRCViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseRCViewHold.get(context,parent, R.layout.item_fruit);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRCViewHold baseRCViewHold, int position) {
        FruitBeen dataBean = getItem(position);
        if (dataBean == null) {
            baseRCViewHold.setText(R.id.tv_id, "XXX");
            baseRCViewHold.setText(R.id.fruit_name,"佚名");
            baseRCViewHold.setImageResource(R.id.fruit_image,R.mipmap.ic_launcher);
        } else {
            baseRCViewHold.setText(R.id.tv_id,String.valueOf(dataBean.getId()));
            baseRCViewHold.setText(R.id.fruit_name,dataBean.getName());
            baseRCViewHold.setImageResource(R.id.fruit_image,dataBean.getImage());
        }
    }



}
