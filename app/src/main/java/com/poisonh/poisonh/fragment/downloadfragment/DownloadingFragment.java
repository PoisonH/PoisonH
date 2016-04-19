package com.poisonh.poisonh.fragment.downloadfragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.DownloadListAdapter;
import com.poisonh.poisonh.utils.AppConstant;
import com.poisonh.poisonh.utils.VideoDownloadUtils;

/**
 * Created by PoisonH on 2016/4/14.
 */
public class DownloadingFragment extends Fragment
{

    private RecyclerView mRvDownloading;
    private DownloadListAdapter mDownloadListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_downloading, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mDownloadListAdapter = new DownloadListAdapter(getActivity());
        mRvDownloading = (RecyclerView) view.findViewById(R.id.rv_downloading);
        LinearLayoutManager mManger = new LinearLayoutManager(getActivity());
        mManger.setOrientation(LinearLayoutManager.VERTICAL);
        mRvDownloading.setLayoutManager(mManger);
        mRvDownloading.setAdapter(mDownloadListAdapter);
    }

    BroadcastReceiver MyBroadcast = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String mStrVideoDownloadUrl = intent.getStringExtra("PlayUrl");
            String mStrVideoName = intent.getStringExtra("VideoName");
            VideoDownloadUtils.videoDownload(mStrVideoDownloadUrl, mStrVideoName);
        }
    };
    public void registerBroadcase()
    {
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(AppConstant.VIDEO_DOWNDLOAD_BROADCAST);
        getActivity().registerReceiver(MyBroadcast, mIntentFilter);
    }

}
