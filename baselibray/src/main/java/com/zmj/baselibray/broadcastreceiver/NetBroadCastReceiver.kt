package com.zmj.baselibray.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.zmj.baselibray.common.NetConnectListener
import com.zmj.baselibray.common.showToast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/2
 * Description :
 */
class NetBroadCastReceiver(var netListener: NetConnectListener): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action

        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            val connectManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = connectManager.activeNetworkInfo

            if (netInfo != null && netInfo.isAvailable){
                //发送网络重新连接
                netListener.onReconnect()
            }else{
                showToast(context,"当前网络不可用")
            }
        }


    }
}