package com.song.songup.databinding_study.view_data;

import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/7/19 10:11
 * 修改备注：
 */
public class UserObservable {
    private ObservableField<String> nameObsevable;
    private ObservableField<String> detailObservable;
    private ObservableFloat priceObservable;

    public UserObservable(String name, float price, String detail) {
        nameObsevable = new ObservableField<>(name);
        detailObservable = new ObservableField<>(detail);
        priceObservable = new ObservableFloat(price);
    }

    public ObservableField<String> getNameObsevable() {
        return nameObsevable;
    }

    public void setNameObsevable(String name) {
        if (nameObsevable == null){
            nameObsevable = new ObservableField<>();
        }
        this.nameObsevable.set(name);
    }

    public ObservableField<String> getDetailObservable() {
        return detailObservable;
    }

    public void setDetailObservable(String detail) {
        if (detailObservable == null){
            detailObservable = new ObservableField<String>();
        }
        this.detailObservable.set(detail);
    }

    public ObservableFloat getPriceObservable() {
        return priceObservable;
    }

    public void setPriceObservable(float price) {
        if (priceObservable == null){
            priceObservable = new ObservableFloat();
        }
        this.priceObservable.set(price);
    }
}
