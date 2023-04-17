package com.example.xiechengmvvmdemo1.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifecycle : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onstart() = Log.d("zlc","onStart")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onstop() = Log.d("zlc","onStop")
}