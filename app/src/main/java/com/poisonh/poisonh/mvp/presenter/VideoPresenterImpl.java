package com.poisonh.poisonh.mvp.presenter;


import com.poisonh.poisonh.api.RequestURL;
import com.poisonh.poisonh.bean.VideoDataList;
import com.poisonh.poisonh.mvp.model.IVideoModel;
import com.poisonh.poisonh.mvp.model.VideoModelImpl;
import com.poisonh.poisonh.mvp.view.VideoDataView;

import java.util.List;

/**
 * Created by PoisonH on 2016/2/29.
 */
public class VideoPresenterImpl implements IVideoPresenter, VideoModelImpl.OnLoadDataListListener
{
    private VideoDataView mVideoDataView;
    private IVideoModel mVideoModel;

    public VideoPresenterImpl(VideoDataView videoDataView)
    {
        this.mVideoDataView = videoDataView;
        this.mVideoModel = new VideoModelImpl();
    }

    @Override
    public void loadDataList(int start, int end)
    {
        String url = getUrl(start, end);
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (start == 0 && end == 10)
        {
            mVideoDataView.showProgress();
        }
        mVideoModel.loadDataList(url, this);
    }

    private String getUrl(int start, int end)
    {
        String str = RequestURL.BUDEJIE_URL + start + "-" + end + ".json";
        return str;
    }

    @Override
    public void onSuccess(List<VideoDataList> list)
    {
        mVideoDataView.hideProgress();
        mVideoDataView.addListData(list);
    }

    @Override
    public void onFailure(String msg, Exception e)
    {
        mVideoDataView.hideProgress();
        mVideoDataView.showLoadFailMsg();
    }
}
