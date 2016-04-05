package com.poisonh.poisonh.utils;


import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PoisonH on 2016/2/19.
 */
public class HttpUtils
{
    private OkHttpClient mOkHttpClient;
    private static HttpUtils mInstance;
    private Handler mHandler;

    private HttpUtils()
    {
        mOkHttpClient = new OkHttpClient();
        //表示放到主UI线程去处理
        mHandler = new Handler(Looper.getMainLooper());
    }

    public synchronized static HttpUtils getInstance()
    {
        if (null == mInstance)
        {
            mInstance = new HttpUtils();
        }
        return mInstance;
    }

    public static abstract class ResultCallback
    {
        /**
         * 请求成功回调
         *
         * @param response
         */
        public abstract void onSuccess(String response);

        /**
         * 请求失败回调
         *
         * @param e
         */
        public abstract void onFailure(Exception e);
    }


    private void getRequest(String url, final ResultCallback callback)
    {
        final Request request = new Request.Builder().url(url).build();
        deliveryResult(callback, request);
    }

    private void deliveryResult(final ResultCallback callback, Request request)
    {
        mOkHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                sendFailCallback(callback, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String str = response.body().string();
                sendSuccessCallBack(callback, str);
            }
        });
    }


    private void sendFailCallback(final ResultCallback callback, final Exception e)
    {
        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                if (callback != null)
                {
                    callback.onFailure(e);
                }
            }
        });
    }

    private void sendSuccessCallBack(final ResultCallback callback, final String str)
    {
        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                if (callback != null)
                {
                    callback.onSuccess(str);
                }
            }
        });
    }

    /**********************对外接口************************/

    /**
     * get请求
     *
     * @param url      请求url
     * @param callback 请求回调
     */
    public static void get(String url, ResultCallback callback)
    {
        getInstance().getRequest(url, callback);
    }

}
