package com.zmj.baselibray.common

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/26
 * Description :
 */

val isDebug = true
/**
 *设置状态的颜色
 * api 大于等于23设置传来的颜色
 * 否则设置为默认颜色
 */
fun setUserStatusBarColor(activity: Activity,@ColorInt color: Int){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        activity.window.statusBarColor = color
    }else{
        activity.window.statusBarColor = Color.parseColor("#33000000")
    }
    //activity.window.statusBarColor = color
}

/**
 * @param isTransparent 是否沉浸式
 *
 * @param isBlack 字体是否为黑色
 */
fun setStatusBarTextColor(activity: Activity,isTransparent: Boolean,isBlack: Boolean){
    var flag = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isBlack){
        flag = flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
    activity.window.decorView.systemUiVisibility = flag

}