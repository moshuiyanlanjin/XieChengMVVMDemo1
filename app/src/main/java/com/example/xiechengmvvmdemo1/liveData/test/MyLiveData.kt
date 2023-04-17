package com.example.xiechengmvvmdemo1.liveData.test

import androidx.lifecycle.MutableLiveData

object MyLiveData {//单例

    //by lazy 懒加载
    val info1 : MutableLiveData<String> by lazy { MutableLiveData() }
}