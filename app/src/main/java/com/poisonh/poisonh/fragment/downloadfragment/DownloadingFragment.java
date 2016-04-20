package com.poisonh.poisonh.fragment.downloadfragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.DownloadListAdapter;
import com.poisonh.poisonh.bean.DownloadTaskInfo;
import com.poisonh.poisonh.utils.AppConstant;

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
    public void onStart()
    {
        super.onStart();
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(AppConstant.VIDEO_DOWNDLOAD_BROADCAST);
        getActivity().registerReceiver(mReceiver, mIntentFilter);
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

    BroadcastReceiver mReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            int id = intent.getExtras().getInt(AppConstant.VIDEO_ID);
            int soFarBytes = intent.getExtras().getInt(AppConstant.DOWNLOAD_soFarBytes);
            int totalBytes = intent.getExtras().getInt(AppConstant.DOWNLOAD_totalBytes);
            String mStrVideoName = intent.getExtras().getString(AppConstant.VIDEO_NAME);

            DownloadTaskInfo mTaskInfo = new DownloadTaskInfo();
            mTaskInfo.setTaskID(id);
            mTaskInfo.setFileName(mStrVideoName);
            mTaskInfo.setDownFileSize(soFarBytes);
            mTaskInfo.setFileSize(totalBytes);
            mDownloadListAdapter.addTaskData(mTaskInfo);
            mDownloadListAdapter.notifyDataSetChanged();
            Log.i("DownloadingFragment", "soFarBytes:" + soFarBytes + "///" + "totalBytes" + totalBytes);
        }
    };
}
