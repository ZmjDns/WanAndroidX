package com.zmj.baselibray.common

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/2
 * Description : 监听网络变化的类
 */
interface NetConnectListener {
    fun onDicConnect()

    fun onReconnect()
}