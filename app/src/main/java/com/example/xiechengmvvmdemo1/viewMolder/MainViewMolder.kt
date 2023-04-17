package com.example.xiechengmvvmdemo1.viewMolder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonse
import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonseWredder
import androidx.lifecycle.viewModelScope
import com.example.xiechengmvvmdemo1.repository.APIRepostitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewMolder : ViewModel() {

    var s:String = "ss"



    val userLiveData = MutableLiveData<LoginRegisterResPonseWredder<LoginRegisterResPonse>>()  //注册登录返回数据源
    val stateManager = MutableLiveData<String>() //绑定布局的显示



    // 我只有修改 userLiveData 就等价于 修改 UI控件
    fun requestLogin(username:String,pardword:String){
        // GlobalScope 全局作用域 默认是异步线程
        // viewModelScope.launch 默认是主线程

        var  a = s.also {

        }

        viewModelScope.launch(Dispatchers.Main) {
            //这里时main线程
            userLiveData.value =
                    //这里时异步线程
                APIRepostitory().regqeustLogin(username,pardword,stateManager)

        }
    }
}