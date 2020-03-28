package com.zmj.baselibray.log

import android.util.Log
import com.zmj.baselibray.common.isDebug
import java.lang.Exception
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/27
 * Description :
 */
object LogUtil {

    fun v(tag: String,msg: String){
        if (isDebug){
            Log.v(tag,msg)
        }
    }

    fun d(tag: String,msg: String){
        if (isDebug){
            Log.d(tag, msg)
        }
    }

    fun i (tag: String,content:String){
        if (isDebug){
            Log.i(tag,content)
        }
    }

    fun w(tag: String,msg: String){
        if (isDebug){
            Log.w(tag, msg)
        }
    }

    fun e(tag: String,ex: Exception){
        if (isDebug){
            Log.e(tag,ex.message)
            ex.printStackTrace()
        }
    }

    fun log(tag: Level,msg: String){
        i(tag.toString(),msg)
    }


}