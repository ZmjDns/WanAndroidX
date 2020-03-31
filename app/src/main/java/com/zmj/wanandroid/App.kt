package com.zmj.wanandroid

import com.zmj.baselibray.BaseApplication

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/31
 * Description :
 */
class App: BaseApplication()  {

    companion object{
        lateinit var APP_INSTANCE: App
    }

    override fun onCreate() {
        super.onCreate()

        APP_INSTANCE = this
    }
}