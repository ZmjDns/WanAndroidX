package com.zmj.baselibray.presenter

import java.lang.ref.WeakReference

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/26
 * Description :
 */
open class BasePresenter<V: IBaseView>: IBasePresenter<V> {

    private lateinit var weakRef: WeakReference<IBaseView>
    protected var view: IBaseView? = null

    constructor(view : IBaseView){
        this.weakRef = WeakReference(view)
        this.view = weakRef.get() as IBaseView
    }


    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
        view = null
        weakRef.clear()
    }
}