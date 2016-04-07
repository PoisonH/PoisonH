package com.poisonh.poisonh.mvp.model;

/**
 * Created by PoisonH on 2016/2/29.
 */
public interface INewsModel
{
    void loadDataList(String url, NewsModelImpl.OnLoadDataListListener onLoadDataListListener);
}
