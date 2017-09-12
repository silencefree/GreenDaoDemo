package com.carlos.greendaodemo.application;

import android.app.Application;
import android.content.Context;

import com.carlos.greendaodemo.manager.GreenDaoManager;

/**
 * Created by Carlos on 2017/9/12 0012.
 * Believe yourself always.
 */

public class MyApplication extends Application {

    public static Context context;
    public static int I = 10;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //GreenDao的初始化
        GreenDaoManager.getInstance();
    }

    public static Context getContext(){
        return context;
    }

}
