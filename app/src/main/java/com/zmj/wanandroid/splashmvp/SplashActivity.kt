package com.zmj.wanandroid.splashmvp

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zmj.baselibray.log.LogUtil
import com.zmj.baselibray.presenter.BasePresenter
import com.zmj.baselibray.presenter.IBaseView
import com.zmj.baselibray.ui.BaseActivity
import com.zmj.wanandroid.R
import com.zmj.wanandroid.homemvp.MainActivity
import kotlinx.android.synthetic.main.act_splash.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/26
 * Description :
 */
class SplashActivity: BaseActivity<BasePresenter<*>>(),IBaseView {


    override val layoutRes: Int
        get() = R.layout.act_splash

    override fun createPresenter(): BasePresenter<*>? {
        return null
    }

    override fun getContext(): Context? {
        return this
    }

    override fun onLoading(loadInfo: String) {
    }

    override fun onCloseLoading() {
    }

    override fun initData(savedInstanceState: Bundle?) {
        initAnimator()
    }

    private fun initAnimator(){
        val objectAnimator = ObjectAnimator.ofInt(splashCircle,"progress",0,100)

        objectAnimator.duration = 2000

        objectAnimator.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
                LogUtil.i("SplashActivity","onAnimationRepeat........")
            }

            override fun onAnimationEnd(animation: Animator?) {
                LogUtil.i("SplashActivity","onAnimationEnd........")

                startActivity(Intent(this@SplashActivity,MainActivity::class.java))

                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
                LogUtil.i("SplashActivity","onAnimationCancel........")
            }

            override fun onAnimationStart(animation: Animator?) {
                LogUtil.i("SplashActivity","onAnimationStart........")
            }
        })
        objectAnimator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}