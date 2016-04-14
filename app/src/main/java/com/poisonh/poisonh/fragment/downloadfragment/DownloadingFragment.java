package com.poisonh.poisonh.fragment.downloadfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.poisonh.poisonh.R;

/**
 * Created by PoisonH on 2016/4/14.
 */
public class DownloadingFragment extends Fragment
{

    private RecyclerView mRvDownloading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_downloading, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mRvDownloading = (RecyclerView) view.findViewById(R.id.rv_downloading);

        FileDownloader.getImpl().create("").setPath("").setListener(new FileDownloadListener()
        {
            //下载流程：pending -> connected -> (progress <->progress) -> [retry] -> blockComplete -> completed
            //等待，已经进入下载队列
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {

            }

            //下载进度回调
            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {

            }

            //在完成前同步调用该方法，此时已经下载完成
            @Override
            protected void blockComplete(BaseDownloadTask task)
            {

            }

            //完成整个下载过程
            @Override
            protected void completed(BaseDownloadTask task)
            {

            }

            //暂停下载
            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {

            }

            //下载出现错误
            @Override
            protected void error(BaseDownloadTask task, Throwable e)
            {

            }

            //在下载队列中(正在等待/正在下载)已经存在相同下载连接与相同存储路径的任务
            @Override
            protected void warn(BaseDownloadTask task)
            {

            }
        });
    }
}
