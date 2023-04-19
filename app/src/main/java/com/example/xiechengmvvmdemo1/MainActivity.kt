package com.example.xiechengmvvmdemo1

import android.app.appsearch.GlobalSearchSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xiechengmvvmdemo1.databinding.ActivityMainBinding
import com.example.xiechengmvvmdemo1.lifecycle.MyLifecycle
import com.example.xiechengmvvmdemo1.lifecycle.MyLifecycle1
import com.example.xiechengmvvmdemo1.liveData.test.MyLiveData
import com.example.xiechengmvvmdemo1.viewMolder.MainViewMolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    val main = MainScope()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding必须是AndroidX的环境  ComponentActivity LifecycleOwner

       // main.launch {  }


        // 绑定DataBinding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MainViewMolder::class.java)

        binding.vm = viewModel

        binding.bt.setOnClickListener { Log.d("zlc","打印的MainActivity主干222")
            viewModel.requestLogin("Derry-vip", "123456")
        }

        lifecycle.addObserver(MyLifecycle())
        lifecycle.addObserver(MyLifecycle1())

        MyLiveData.info1.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {

            }
        })

        MyLiveData.info1.observe(this,{

        })

        Thread{
            MyLiveData.info1.postValue("zzzz")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        main.cancel()
    }
}