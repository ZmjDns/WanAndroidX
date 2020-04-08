package com.zmj.baselibray.ui

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.zmj.baselibray.broadcastreceiver.NetBroadCastReceiver
import com.zmj.baselibray.common.NetConnectListener
import com.zmj.baselibray.common.setUserStatusBarColor
import com.zmj.baselibray.presenter.IBasePresenter
import com.zmj.baselibray.presenter.IBaseView

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/26
 * Description :
 */
abstract class BaseActivity<P: IBasePresenter<*>>: AppCompatActivity(),NetConnectListener{

    protected var presenter: P? = null
    private val netReceiver: NetBroadCastReceiver by lazy { NetBroadCastReceiver(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar.let {
            it?.hide()
        }

        if (layoutRes != 0){
            setContentView(layoutRes)
        }
        presenter = createPresenter()
        /*presenter.let {
            lifecycle.addObserver(it as LifecycleObserver)
        }*/

        if (presenter != null){
            lifecycle.addObserver(presenter!!)
        }

        setWindowStatusBarColor()
        setStatusBarTextColor()

        initData(savedInstanceState)
    }

    //设置状态栏背景色，无色透明
    protected fun setWindowStatusBarColor(){
        setUserStatusBarColor(this,Color.parseColor("#00ffffff"))
    }

    //设置状态栏字体颜色
    protected fun setStatusBarTextColor(){
        com.zmj.baselibray.common.setStatusBarTextColor(this,true,true)
    }

    //断网或网络重新连接操作，可以由子类重写做自己的逻辑
    override fun onDicConnect() {

    }
    override fun onReconnect() {

    }


    //布局
    protected abstract val layoutRes:Int

    //预加载数据
    protected abstract fun initData(savedInstanceState: Bundle?)

    protected abstract fun createPresenter():P?



}