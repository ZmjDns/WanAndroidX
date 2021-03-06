package com.zmj.baselibray

import android.app.Application

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/6
 * Description :
 */
open class BaseApplication: Application() {

    companion object{
        public lateinit var baseApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }
}