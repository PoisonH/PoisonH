package com.poisonh.poisonh.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.ViewPagerAdapter;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.fragment.newsfragment.ListNewsFragment;
import com.poisonh.poisonh.utils.DensityUtils;

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
        mList.add(ListNewsFragment.newInstance(0));
        mList.add(ListNewsFragment.newInstance(1));
        mList.add(ListNewsFragment.newInstance(2));
        mList.add(ListNewsFragment.newInstance(3));

        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), getActivity().getApplicationContext(), mList));
      //  mTabLayout.setViewPager(mViewPager);
        mTabLayout.addTab(mTabLayout.newTab().setText("热点"));
        mTabLayout.addTab(mTabLayout.newTab().setText("国内"));
        mTabLayout.addTab(mTabLayout.newTab().setText("国外"));
        mTabLayout.addTab(mTabLayout.newTab().setText("健康"));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

}

