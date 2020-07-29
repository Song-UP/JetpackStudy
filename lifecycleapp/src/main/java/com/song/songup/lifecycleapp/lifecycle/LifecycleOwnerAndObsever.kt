package com.song.songup.lifecycleapp.lifecycle

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry

/**
 * @Author swift
 * @description
 * @Date on 26/7/2020 3:35 PM.
 */
public class LifecycleOwnerAndObsever : DefaultLifecycleObserver, LifecycleOwner {
    private val lifecycleRegist  =  lazy { LifecycleRegistry(this) }

    override fun onCreate(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun onStart(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun onResume(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onPause(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    override fun onStop(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        lifecycleRegist.value.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegist.value
    }

}