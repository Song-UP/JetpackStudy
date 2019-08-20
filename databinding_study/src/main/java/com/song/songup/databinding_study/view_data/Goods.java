package com.song.songup.databinding_study.view_data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.song.songup.databinding_study.BR;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/7/18 13:56
 * 修改备注：
 * @Bindable：用来关联view和改变的属性，然后再BR找到对应的id, 通过notifyPropertyChanged(id)更新
 *
 *notify:
 * BaseObservable:通知界面刷新的方式有两种
 * 1.notifyPropertyChanged(): 通知改变属性
 * 2.notifyChange():通知改变所有
 */
public class Goods extends BaseObservable {
    @Bindable
    public String name;
    private int price;
    private String detail;

    public Goods(String name, int price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        只更新本字段(同时界面刷新)
        notifyPropertyChanged(BR.name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Bindable
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
//        更新所有字段
        this.detail = detail;
        notifyChange();
    }
}
