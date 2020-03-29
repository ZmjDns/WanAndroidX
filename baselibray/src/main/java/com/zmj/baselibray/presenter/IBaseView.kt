package com.zmj.baselibray.presenter

import android.content.Context

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/26
 * Description :
 */
interface IBaseView {

    fun getContext(): Context?

    fun onLoading(loadInfo: String)

    fun onCloseLoading()
}