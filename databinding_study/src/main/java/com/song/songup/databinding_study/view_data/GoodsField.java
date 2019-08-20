package com.song.songup.databinding_study.view_data;

import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

import java.util.Observable;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/7/18 14:41
 * 修改备注：
 */
public class GoodsField {
    private ObservableField<String> name;
    private ObservableFloat price;
    private ObservableField<String> details;

    public GoodsField(ObservableField<String> name, ObservableFloat price, ObservableField<String> details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableFloat getPrice() {
        return price;
    }

    public void setPrice(ObservableFloat price) {
        this.price = price;
    }

    public ObservableField<String> getDetails() {
        return details;
    }

    public void setDetails(ObservableField<String> details) {
        this.details = details;
    }
}
