package com.song.songup.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/6 9:45
 * 修改备注：
 */

class MutableLiveDataActivity : AppCompatActivity() {
    val mutableLiveData = MutableLiveData<String>();

    private var changeObservable = Observer<String>(){ value->
        value?.let{
            tv1.text = value;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        initLiveData();
    }

    var a = 1;
    fun initLiveData(){
        mutableLiveData.observe(this,changeObservable)

        findViewById<View>(R.id.button).setOnClickListener {
            mutableLiveData.value = "点击了"+(a++);
        }

    }

}