package com.poisonh.poisonh.mvp.model;

/**
 * Created by PoisonH on 2016/2/29.
 */
public interface IVideoModel
{
    void loadDataList(String url, VideoModelImpl.OnLoadDataListListener onLoadDataListListener);
}
