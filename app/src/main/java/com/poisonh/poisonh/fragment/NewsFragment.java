package com.poisonh.poisonh.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.ViewPagerAdapter;
import com.poisonh.poisonh.api.RequestURL;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.fragment.newsfragment.ListNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class NewsFragment extends BaseFragment
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_news, null);
        initView(view);
        return view;
    }

    private void initView(View view)
    {
        mTabLayout = (TabLayout) view.findViewById(R.id.psts_pagertabs);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_viewpager);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setBackgroundColor(getResources().getColor(R.color.colortab1));
        mList.add(ListNewsFragment.newInstance(RequestURL.FOCUS));
        mList.add(ListNewsFragment.newInstance(RequestURL.SEASON));
        mList.add(ListNewsFragment.newInstance(RequestURL.EXERCISE));
        mList.add(ListNewsFragment.newInstance(RequestURL.HAIRDRESSING));

        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), getActivity().getApplicationContext(), mList));
        //  mTabLayout.setViewPager(mViewPager);
        mTabLayout.addTab(mTabLayout.newTab().setText("热点"));
        mTabLayout.addTab(mTabLayout.newTab().setText("时令"));
        mTabLayout.addTab(mTabLayout.newTab().setText("运动"));
        mTabLayout.addTab(mTabLayout.newTab().setText("美容"));
        mTabLayout.setupWithViewPager(mViewPager);
        //设置未选中和选中的字体颜色
        mTabLayout.setTabTextColors(getResources().getColor(R.color.huise), getResources().getColor(R.color.white));
        //设置指示器的高度
        mTabLayout.setSelectedTabIndicatorHeight(5);
        //设置指示器颜色
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        mViewPager.setCurrentItem(0);
    }

}

