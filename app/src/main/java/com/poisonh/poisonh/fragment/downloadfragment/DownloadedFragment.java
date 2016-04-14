package com.poisonh.poisonh.fragment.downloadfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;

/**
 * Created by PoisonH on 2016/4/14.
 */
public class DownloadedFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_downloaded, null);
    }
}
