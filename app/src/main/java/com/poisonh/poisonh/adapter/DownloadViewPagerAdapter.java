package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager适配器
 * Created by PoisonH on 2016/2/18.
 */
public class DownloadViewPagerAdapter extends FragmentPagerAdapter
{
    private FragmentManager mFragmentManager = null;
    private Context mContext;
    private List<Fragment> mListFragments;

    public DownloadViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> list)
    {
        super(fm);
        this.mFragmentManager = fm;
        this.mContext = context;
        this.mListFragments = list;
    }

    @Override
    public int getCount()
    {
        return mListFragments.size();
    }

    @Override
    public Fragment getItem(int position)
    {

        return mListFragments.get(position);
    }
}
