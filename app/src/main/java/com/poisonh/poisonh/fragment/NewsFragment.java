package com.poisonh.poisonh.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.ListNewsAdapter;
import com.poisonh.poisonh.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/30.
 */
public class NewsFragment extends BaseFragment
{
    private RecyclerView mRecyclerView;
    private ListNewsAdapter mNewsAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_news, null);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_view);

        LinearLayoutManager mManager = new LinearLayoutManager(getActivity());
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);

        mNewsAdapter=new ListNewsAdapter(getActivity());

        mRecyclerView.setAdapter(mNewsAdapter);
    }
}
