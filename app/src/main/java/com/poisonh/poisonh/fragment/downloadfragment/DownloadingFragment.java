package com.poisonh.poisonh.fragment.downloadfragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.poisonh.poisonh.R;
import com.poisonh.poisonh.VideoPlayActivity;
import com.poisonh.poisonh.utils.VideoDownloadUtils;

/**
 * Created by PoisonH on 2016/4/14.
 */
public class DownloadingFragment extends Fragment
{

    private RecyclerView mRvDownloading;
    private VideoPlayActivity mVideoPlayActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mVideoPlayActivity = new VideoPlayActivity();
        return inflater.inflate(R.layout.layout_fragment_downloading, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mRvDownloading = (RecyclerView) view.findViewById(R.id.rv_downloading);

    }

    public static class MyBroadcast extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String mStrVideoDownloadUrl = intent.getStringExtra("PlayUrl");
            String mStrVideoName = intent.getStringExtra("VideoName");
            VideoDownloadUtils.videoDownload(mStrVideoName, mStrVideoDownloadUrl);
        }
    }
}
