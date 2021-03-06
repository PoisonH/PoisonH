package com.poisonh.poisonh.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by PoisonH on 2016/4/6.
 */
public class MyApplication extends Application
{
    private static Context mContext;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(this);
        /**
         * 仅仅是缓存Application的Context，不耗时
         */
        FileDownloader.init(getApplicationContext());
    }

    //返回
    public static Context getContextObject()
    {
        return mContext;
    }
}
