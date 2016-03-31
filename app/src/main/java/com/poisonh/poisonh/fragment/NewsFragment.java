package com.poisonh.poisonh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/30.
 */
public class NewsFragment extends BaseFragment
{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_common, null);
        return view;
    }
}
