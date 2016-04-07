package com.poisonh.poisonh.mvp.model;


import com.poisonh.poisonh.bean.NewsDataList;
import com.poisonh.poisonh.utils.GsonUtils;
import com.poisonh.poisonh.utils.HttpUtils;

import java.util.List;

/**
 * Created by PoisonH on 2016/2/29.
 */
public class NewsModelImpl implements INewsModel
{

    @Override
    public void loadDataList(String url, final OnLoadDataListListener listener)
    {
        HttpUtils.ResultCallback mResultCallback = new HttpUtils.ResultCallback()
        {
            @Override
            public void onSuccess(String response)
            {
                //这儿调用json解析工具。将string解析成list
                List<NewsDataList> mList = GsonUtils.parseJson(response);
                listener.onSuccess(mList);
            }

            @Override
            public void onFailure(Exception e)
            {
                listener.onFailure("load data list failure", e);
            }
        };
        HttpUtils.get(url, mResultCallback);
    }

    public interface OnLoadDataListListener
    {
        void onSuccess(List<NewsDataList> list);

        void onFailure(String msg, Exception e);
    }
}
