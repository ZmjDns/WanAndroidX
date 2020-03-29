package com.zmj.baselibray.ui

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
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
abstract class BaseActivity<P: IBasePresenter<*>>: AppCompatActivity(){

    protected var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutRes != 0){
            setContentView(layoutRes)
        }
        presenter = createPresenter()
        presenter.let {
            lifecycle.addObserver(it as LifecycleObserver)
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


    //布局
    protected abstract val layoutRes:Int

    //预加载数据
    protected abstract fun initData(savedInstanceState: Bundle?)

    protected abstract fun createPresenter():P?



}