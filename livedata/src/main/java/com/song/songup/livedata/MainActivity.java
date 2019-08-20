package com.song.songup.livedata;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.song.songup.livedata.liveData.MyActivityViewModel;
import com.song.songup.livedata.liveData.NameViewModel;

public class MainActivity extends AppCompatActivity {

    TextView mNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView(){
        mNameTextView = findViewById(R.id.tv1);


//        initLiveData();
        initAndroidViewModel();
    }

    Observer<String> nameObservable = str->{
        mNameTextView.setText(str);
    };

    NameViewModel nameViewModel;
    public void initLiveData(){
        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);

        nameViewModel.getmCurrentName().observe(this,nameObservable);

        findViewById(R.id.button).setOnClickListener(view->{
            String another = "song up";
            nameViewModel.getmCurrentName().setValue(another);

        });


    }

    MyActivityViewModel androidViewModel;
    public void initAndroidViewModel(){
        MyActivityViewModel androidViewModel = ViewModelProviders.of(this).get(MyActivityViewModel.class);
        androidViewModel.getLiveData().observe(this,nameObservable);

        findViewById(R.id.button).setOnClickListener(view->{
            String another = "song up";
            androidViewModel.getLiveData().setValue(another);

        });

    }
}
