package com.poisonh.poisonh.mvp.model;

/**
 * Created by PoisonH on 2016/2/29.
 */
public interface INewsHealthListDataModel
{
    void loadDataList(String url, NewsHealthListDataModelImpl.OnLoadDataListListener onLoadDataListListener);
}
