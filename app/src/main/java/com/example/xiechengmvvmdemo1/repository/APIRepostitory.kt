package com.example.xiechengmvvmdemo1.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.xiechengmvvmdemo1.api.ApiClient
import com.example.xiechengmvvmdemo1.api.WanAndroidAPI
import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonse
import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonseWredder

/**
 * 仓库层
 */
class APIRepostitory {
    suspend fun regqeustLogin(username:String,userpwd:String,stateManager:MutableLiveData<String>):
            LoginRegisterResPonseWredder<LoginRegisterResPonse>? {
        if (username.isEmpty() || userpwd.isEmpty()){
            return null
        }

        return ApiClient.instance.instanceRetrofit(WanAndroidAPI::class.java).loginActionCoroutine(username,userpwd)
    }
}