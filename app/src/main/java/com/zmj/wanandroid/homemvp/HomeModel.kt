package com.zmj.wanandroid.homemvp

import com.google.gson.Gson
import com.zmj.netlibrary.core.CommonRequest
import com.zmj.wanandroid.entry.Article
import com.zmj.wanandroid.entry.BaseResponse
import com.zmj.wanandroid.entry.SecondLevelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/7
 * Description :
 */
class HomeModel {

    private val gson = Gson()

    //首页文章列表  https://www.wanandroid.com/article/list/0/json
    @ExperimentalCoroutinesApi
    fun firstPageArticles(){
        MainScope().launch(Dispatchers.IO){
            kotlin.runCatching {
                CommonRequest.getRequestData<BaseResponse<*>>("0",null)
            }.onSuccess {
                val body = it.string()

                val data = gson.fromJson(body.toString(),BaseResponse::class.java)

                data.errorCode

            }.onFailure {
                it.printStackTrace()
            }
        }
    }

}