package com.carlos.greendaodemo.manager;

import android.database.sqlite.SQLiteDatabase;

import com.carlos.gen.DaoMaster;
import com.carlos.gen.DaoSession;
import com.carlos.greendaodemo.MainActivity;
import com.carlos.greendaodemo.application.MyApplication;

/**
 * Created by Carlos on 2017/9/12 0012.
 * Believe yourself always.
 */

public class GreenDaoManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance; //单例

    private GreenDaoManager(){
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(MyApplication.getContext(), "user1-db", null);//此处为自己需要处理的表
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {//保证异步处理安全操作

                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }
    public DaoSession getSession() {
        return mDaoSession;
    }
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}