package com.song.songup.livedata

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/8/6 12:34
 * 修改备注：
 */
class TransformtionActivity:AppCompatActivity() {

    private val changeObserver = Observer<String> { value ->
        value?.let {
            tv1.text = it
        }
    }

    val mutableLiveDataA = MutableLiveData<String>();
    val mutableLiveDataB = MutableLiveData<String>();
    val mutableLiveDataBoolea = MutableLiveData<Boolean>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initTranslate()

//        initMediatorLiveData()

        initSwitch()
        mutableLiveDataA.value="A";
        mutableLiveDataB.value = "B"
        button.setOnClickListener {


        }

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            mutableLiveDataBoolea.value = isChecked;
        }

    }
    val transformedLiveData = null;
     fun initTranslate() {
        val transformedLiveData = Transformations.map(mutableLiveDataA) { "改变那之后的内容:---$it" }
        transformedLiveData.observe(this, changeObserver)
    }


    fun initMediatorLiveData(){
        var a = 1;
       var mediatorLiveData =  MediatorLiveData<String>();
        mediatorLiveData.addSource(mutableLiveDataA,{
           mediatorLiveData.value="A转换之后的内容$it"
        });
        mediatorLiveData.addSource(mutableLiveDataB,{
            mediatorLiveData.value = "B转换之后$it"
        });

        mediatorLiveData.observe(this,changeObserver);


    }

    fun initSwitch(){
        val swithTranslateLiveData = Transformations.switchMap(mutableLiveDataBoolea,{
            if(it)
                mutableLiveDataB
            else
                mutableLiveDataA
        });
        swithTranslateLiveData.observe(this,changeObserver);

    }
}