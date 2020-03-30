package com.zmj.baselibray;

import android.app.Application;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/27
 * Description :
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        baseApplication = this;
    }

    public static BaseApplication getBaseApplication(){
        return baseApplication;
    }
}
