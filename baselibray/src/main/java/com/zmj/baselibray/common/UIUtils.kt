package com.zmj.baselibray.common

import android.content.Context
import android.widget.Toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/2
 * Description :
 */

fun showToast(context: Context,msg: String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}