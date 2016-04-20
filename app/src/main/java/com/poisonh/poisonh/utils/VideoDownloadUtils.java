package com.poisonh.poisonh.utils;

import android.content.Intent;
import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.poisonh.poisonh.app.MyApplication;

/**
 * 视频下载工具类
 * Created by PoisonH on 2016/4/19.
 */
public class VideoDownloadUtils
{

    public static void videoDownload(final int id, String mStrVideoDownloadUrl, final String mStrVideoName)
    {
        FileDownloader.getImpl().create(mStrVideoDownloadUrl).setPath(savePath() + mStrVideoName + ".mp4").setListener(new FileDownloadListener()
        {
            long time = System.currentTimeMillis();

            //下载流程：pending -> connected -> (progress <->progress) -> [retry] -> blockComplete -> completed
            //等待，已经进入下载队列
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {
                Log.i("VideoDownloadUtils", "pending");
            }

            //下载进度回调
            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {
                Log.i("VideoDownloadUtils", "progress");
                if (System.currentTimeMillis() - time > 200)
                {
                    time = System.currentTimeMillis();
                    Intent mIntent = new Intent();
                    mIntent.setAction(AppConstant.VIDEO_DOWNDLOAD_BROADCAST);
                    mIntent.putExtra(AppConstant.DOWNLOAD_soFarBytes, soFarBytes);
                    mIntent.putExtra(AppConstant.DOWNLOAD_totalBytes, totalBytes);
                    mIntent.putExtra(AppConstant.VIDEO_NAME, mStrVideoName);
                    mIntent.putExtra(AppConstant.VIDEO_ID, id);
                    MyApplication.getContextObject().sendBroadcast(mIntent);
                }
            }

            //在完成前同步调用该方法，此时已经下载完成
            @Override
            protected void blockComplete(BaseDownloadTask task)
            {
                Log.i("VideoDownloadUtils", "blockComplete");
            }

            //完成整个下载过程
            @Override
            protected void completed(BaseDownloadTask task)
            {
                Log.i("VideoDownloadUtils", "completed");
            }

            //暂停下载
            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {
                Log.i("VideoDownloadUtils", "paused");
            }

            //下载出现错误
            @Override
            protected void error(BaseDownloadTask task, Throwable e)
            {
                Log.i("VideoDownloadUtils", "error");

            }

            //在下载队列中(正在等待/正在下载)已经存在相同下载连接与相同存储路径的任务
            @Override
            protected void warn(BaseDownloadTask task)
            {
                Log.i("VideoDownloadUtils", "warn");

            }
        }).start();
    }

    /**
     * 设置存储位置
     *
     * @return
     */
    public static String savePath()
    {
        if (SDCardUtils.isSDCardEnable())
        {
            return SDCardUtils.getSDCardPath() + AppConstant.VIDEO_DOWNLOAD_PATH;
        } else
        {
            return SDCardUtils.getRootDirectoryPath() + AppConstant.VIDEO_DOWNLOAD_PATH;
        }
    }
}
