package com.example.xiechengmvvmdemo1.api

import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonse
import com.example.xiechengmvvmdemo1.entity.LoginRegisterResPonseWredder
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface WanAndroidAPI {

    // TODO >>>>>>>只有协程了 下面是协程API 当Retrofit检测到suspend关键字时，他会调用withContext将当前切换为异步

    /** https://www.wanandroid.com/blog/show/2
     * 登录API
     * username=Derry-vip&password=123456
     */
    @POST("/user/login")
    @FormUrlEncoded
    suspend fun loginActionCoroutine(@Field("username") username: String,
                                     @Field("password") password: String)
            : LoginRegisterResPonseWredder<LoginRegisterResPonse> // 返回值

    /** https://www.wanandroid.com/blog/show/2
     * 注册的API
     */
    @POST("/user/register")
    @FormUrlEncoded
    suspend fun registerActionCoroutine(@Field("username") username: String,
                                        @Field("password") password: String,
                                        @Field("repassword") repassword: String)
            : LoginRegisterResPonseWredder<LoginRegisterResPonse> // 返回值
}