package com.zmj.baselibray.ui

import com.zmj.baselibray.presenter.IBasePresenter

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/27
 * Description :
 */
abstract class BaseLazyFragment<P: IBasePresenter<*>>:BaseFragment<P>() {

    private var isLoaded: Boolean = false

    override fun onResume() {
        super.onResume()

        if (!isLoaded && !isHidden){

            lazyInit()
            isLoaded = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isLoaded = false
    }

    abstract fun lazyInit()
}