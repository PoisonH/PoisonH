package com.poisonh.poisonh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.poisonh.poisonh.VideoPlayActivity;
import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.VideoListRVAdapter;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.bean.VideoDataList;
import com.poisonh.poisonh.mvp.presenter.IVideoPresenter;
import com.poisonh.poisonh.mvp.presenter.VideoPresenterImpl;
import com.poisonh.poisonh.mvp.view.VideoDataView;
import com.poisonh.poisonh.utils.ToastUtils;
import com.poisonh.poisonh.widget.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class VedioFragment extends BaseFragment implements VideoDataView, VideoListRVAdapter.onWidgetClickListener
{
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private VideoListRVAdapter mVideoListRVAdapter;
    private List<VideoDataList> mVideoList;
    private IVideoPresenter mVideoPresenter;
    private int start = 0;
    private int end = 10;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_listnews, null);
        mVideoPresenter = new VideoPresenterImpl(this);
        mVideoListRVAdapter = new VideoListRVAdapter(getActivity());
        mVideoList = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.rv_view);
        //设置上拉刷新文字
        mPullLoadMoreRecyclerView.setFooterViewText("Loading Data...");
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new LoadMoreListener());
        mPullLoadMoreRecyclerView.setAdapter(mVideoListRVAdapter);
        mVideoListRVAdapter.setMonWidgetClickListener(this);
        mVideoPresenter.loadDataList(start, end);
    }


    private class LoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener
    {
        @Override
        public void onRefresh()
        {
            end = 10;
            mVideoPresenter.loadDataList(start, end);
        }

        @Override
        public void onLoadMore()
        {
            mVideoPresenter.loadDataList(start, end += 10);
        }
    }

    @Override
    public void showProgress()
    {
        //显示刷新进度条
        mPullLoadMoreRecyclerView.setRefreshing(true);
    }

    @Override
    public void hideProgress()
    {
        //隐藏刷新进度条
        mPullLoadMoreRecyclerView.setRefreshing(false);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void addListData(List<VideoDataList> lists)
    {
        mVideoList = lists;
        if (mVideoListRVAdapter.getData())
        {
            mVideoListRVAdapter.cleanListData();
        }
        mVideoListRVAdapter.setData(lists);
    }

    @Override
    public void showLoadFailMsg()
    {
        ToastUtils.showToast(getActivity(), "数据加载失败...", Toast.LENGTH_SHORT);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void onWidgetClick(View view, int postion)
    {
        switch (view.getId())
        {
            case R.id.ib_play:
                switchAcitivty(postion);
                ToastUtils.showToast(getActivity(), "你点击了播放", Toast.LENGTH_SHORT);
                break;
            case R.id.ib_dianzan:
                ToastUtils.showToast(getActivity(), "你点击了点赞", Toast.LENGTH_SHORT);
                break;
            case R.id.ib_disu:
                ToastUtils.showToast(getActivity(), "你点击了低俗", Toast.LENGTH_SHORT);
                break;
            case R.id.ib_zhuanfa:
                ToastUtils.showToast(getActivity(), "你点击了转发", Toast.LENGTH_SHORT);
                break;
        }
    }

    private void switchAcitivty(int postion)
    {
        Intent mIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("PlayUrl", mVideoList.get(postion).getmStrPlayUrl());
        bundle.putString("DownLoadUrl", mVideoList.get(postion).getmStrDownloadUrl());
        bundle.putString("Duration", mVideoList.get(postion).getDuration());
        mIntent.putExtras(bundle);
        mIntent.setClass(getActivity(), VideoPlayActivity.class);
        startActivity(mIntent);
    }
}
