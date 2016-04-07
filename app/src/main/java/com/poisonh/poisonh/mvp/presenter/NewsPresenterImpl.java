package com.poisonh.poisonh.mvp.presenter;


import com.poisonh.poisonh.api.RequestURL;
import com.poisonh.poisonh.bean.NewsDataList;
import com.poisonh.poisonh.mvp.model.INewsModel;
import com.poisonh.poisonh.mvp.model.NewsModelImpl;
import com.poisonh.poisonh.mvp.view.NewsDataView;

import java.util.List;

/**
 * Created by PoisonH on 2016/2/29.
 */
public class NewsPresenterImpl implements INewsPresenter, NewsModelImpl.OnLoadDataListListener
{
    private NewsDataView mDataView;
    private INewsModel mListDataModel;

    public NewsPresenterImpl(NewsDataView dataView)
    {
        this.mDataView = dataView;
        this.mListDataModel = new NewsModelImpl();
    }

    @Override
    public void loadDataList(int catid, int page)
    {
        String url = getUrl(catid, page);
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (page == 0)
        {
            mDataView.showProgress();
        }
        mListDataModel.loadDataList(url, this);
    }

    private String getUrl(int catid, int page)
    {
        String str = RequestURL.URL + catid + "&page=" + page + "&pagesize=" + RequestURL.PAGESIZE;
        return str;
    }

    @Override
    public void onSuccess(List<NewsDataList> list)
    {
        mDataView.hideProgress();
        mDataView.addListData(list);
    }

    @Override
    public void onFailure(String msg, Exception e)
    {
        mDataView.hideProgress();
        mDataView.showLoadFailMsg();
    }
}
