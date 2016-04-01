package com.poisonh.poisonh.fragment.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.ListNewsAdapter;
import com.poisonh.poisonh.base.BaseFragment;

/**
 * Created by PoisonH on 2016/4/1.
 */
public class ListNewsFragment extends BaseFragment
{
    private RecyclerView mRecyclerView;
    private ListNewsAdapter mAdapter;

    public static ListNewsFragment newInstance(int catid)
    {
        ListNewsFragment fragment = new ListNewsFragment();
        Bundle args = new Bundle();
        args.putInt("catid", catid);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_listnews, null);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_view);
        LinearLayoutManager mManager = new LinearLayoutManager(getActivity());
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mManager);

        mAdapter = new ListNewsAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }
}
