package com.poisonh.poisonh.fragment.newsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.WebViewActivity;
import com.poisonh.poisonh.adapter.NewsListRVAdapter;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.bean.NewsDataList;
import com.poisonh.poisonh.mvp.presenter.INewsPresenter;
import com.poisonh.poisonh.mvp.presenter.NewsPresenterImpl;
import com.poisonh.poisonh.mvp.view.NewsDataView;
import com.poisonh.poisonh.utils.ToastUtils;
import com.poisonh.poisonh.widget.PullLoadMoreRecyclerView;

import java.util.List;

/**
 * Created by PoisonH on 2016/4/1.
 */
public class ListNewsFragment extends BaseFragment implements NewsDataView, NewsListRVAdapter.OnItemClickLitener
{
    private PullLoadMoreRecyclerView mRecyclerView;
    private NewsListRVAdapter mAdapter;
    private INewsPresenter mPresenter;
    private int pageIndex;
    //类别
    private int catid;

    public static ListNewsFragment newInstance(int catid)
    {
        ListNewsFragment fragment = new ListNewsFragment();
        Bundle args = new Bundle();
        args.putInt("catid", catid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mPresenter = new NewsPresenterImpl(this);
        catid = getArguments().getInt("catid");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_listnews, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        mRecyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.rv_view);
        mRecyclerView.setLinearLayout();
        mRecyclerView.setFooterViewText("Loading More...");
        mRecyclerView.setOnPullLoadMoreListener(new LoadMoreListener());
        mAdapter = new NewsListRVAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickLitener(this);
        loadData();
    }

    /**
     * 加载更多的监听函数
     */
    private class LoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener
    {
        @Override
        public void onRefresh()
        {
            pageIndex = 1;
            showProgress();
            mAdapter.cleanListData();
            mPresenter.loadDataList(catid, pageIndex);
            ToastUtils.showToast(getActivity(), "刷新成功", Toast.LENGTH_SHORT);
        }

        @Override
        public void onLoadMore()
        {
            mPresenter.loadDataList(catid, pageIndex);
        }
    }

    @Override
    public void showProgress()
    {
        //显示刷新进度条
        mRecyclerView.setRefreshing(true);
    }

    @Override
    public void hideProgress()
    {
        //隐藏刷新进度条
        mRecyclerView.setRefreshing(false);
        mRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void addListData(List<NewsDataList> lists)
    {
        if (lists == null || lists.size() <= 0)
        {
            ToastUtils.showToast(getActivity(), "Not More Data...", Toast.LENGTH_SHORT);
        } else
        {
            mAdapter.setData(lists);
            mAdapter.setmStrFileName(catid + "");
        }
        pageIndex += 1;
    }

    @Override
    public void showLoadFailMsg()
    {
        ToastUtils.showToast(getActivity(), "数据加载失败...", Toast.LENGTH_SHORT);
        mRecyclerView.setPullLoadMoreCompleted();
    }

    private void loadData()
    {
        pageIndex = 1;
        showProgress();
        mPresenter.loadDataList(catid, pageIndex);
    }

    @Override
    public void onItemClick(View view, int position)
    {
        Intent mIntent = new Intent();
        mIntent.setClass(getContext(), WebViewActivity.class);
        mIntent.putExtra("id", mAdapter.getData().get(position).getId() + "");
        startActivity(mIntent);
    }

    @Override
    public void onItemLongClick(View view, int position)
    {

    }
}
