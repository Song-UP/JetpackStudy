package com.song.songup.databinding_study;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.song.songup.databinding_study.databinding.ActivityCollectionBinding;
import com.song.songup.databinding_study.databinding.ActivityMainBindAdapterBinding;
import com.song.songup.databinding_study.databinding.ActivityMainBindingImpl;
import com.song.songup.databinding_study.databinding.ActivityMainEventBinding;
import com.song.songup.databinding_study.databinding.ActivityMainGoodsBinding;
import com.song.songup.databinding_study.databinding.ActivityMainGoodsBindingImpl;
import com.song.songup.databinding_study.databinding.ActivityMainGoodsFieldBindingImpl;
import com.song.songup.databinding_study.databinding.ActivityMainUserDoubleBinding;
import com.song.songup.databinding_study.model.Image;
import com.song.songup.databinding_study.view_data.Goods;
import com.song.songup.databinding_study.view_data.GoodsField;
import com.song.songup.databinding_study.view_data.User;
import com.song.songup.databinding_study.view_data.UserObservable;

import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadGoods();
//        loadGoodsField();
//        loadUserDouble();

//        loadCollection();
        loadUserEvent();
    }

    public void loadUserLayout(){
        ActivityMainBindingImpl activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener((v)->{
            User user = new User("SongUP"+(i++),"123456");
            activityMain2Binding.setUserInfo(user);
        });
    }

    Goods goods;
    public void loadGoods(){
        ActivityMainGoodsBindingImpl activityMainGoodsBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_goods);
        goods = new Goods("user",15,"1234");
        activityMainGoodsBinding.setGoodsHanel(new GoodsHandle());
        activityMainGoodsBinding.setGoodsInfo(goods);

    }

    GoodsField goodsField;
    public void loadGoodsField(){
        ActivityMainGoodsFieldBindingImpl activityMainGoodsFieldBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_goods_field);
        goodsField = new GoodsField(new ObservableField<String>("user"),new ObservableFloat(15),new ObservableField<String>("1234"));
        activityMainGoodsFieldBinding.setClickHandle(this);
        activityMainGoodsFieldBinding.setGoodsInfo(goodsField);

    }

    public void loadUserDouble(){
        ActivityMainUserDoubleBinding activityMainGoodsBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_user_double);
//        activityMainGoodsBinding.
        UserObservable userObservable = new UserObservable("23333",15,"12342134");
        activityMainGoodsBinding.setUserInfo(userObservable);

    }

    private ObservableMap<String,String> map;
    public void loadCollection(){
        ActivityCollectionBinding activityCollectionBinding = DataBindingUtil.setContentView(this, R.layout.activity_collection);
        map = new ObservableArrayMap<>();
        map.put("name","leavesc");
        map.put("age","24");
        activityCollectionBinding.setMap(map);

        ObservableList<String> observableList = new ObservableArrayList<>();
        observableList.add("Ye");
        observableList.add("leaveC");
        activityCollectionBinding.setList(observableList);

        activityCollectionBinding.setKey("name");
        activityCollectionBinding.setIndex(1);


    }


    public class GoodsHandle{
        public void changeGoodsName() {
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            goods.setDetail("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

    }

    public void changeGoodsName() {
       goodsField.getName().set("code" + new Random().nextInt(100));
       goodsField.getPrice().set(new Random().nextInt(100));
    }

    public void changeGoodsDetails() {
        goodsField.getDetails().set("hi" + new Random().nextInt(100));
        goodsField.getPrice().set(new Random().nextInt(100));
    }

    public void onClick(View view){

        map.put("name","songUP  "+new Random().nextInt());

    }


    public void loadUserEvent(){
        activityMainEventBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_event);
        userEvent = new User("23333","123456");
        activityMainEventBinding.setUser(userEvent);
        activityMainEventBinding.setPresent(new UserPresent());

    }

    User userEvent;
    ActivityMainEventBinding activityMainEventBinding;
    UserObservable observable;
    public class UserPresent {
        public void onUserNameClick(User user){
            Toast.makeText(MainActivity.this, user.getName(),Toast.LENGTH_SHORT).show();
        }

        public void onTextAfterChange(Editable editable){
            userEvent.setName(editable.toString());
            activityMainEventBinding.setUser(userEvent);
        }

        public void afterPassWordChange(Editable editable){
            userEvent.setPassword(editable.toString());
            activityMainEventBinding.setUser(userEvent);
        }
    }



}
