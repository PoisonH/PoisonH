package com.poisonh.poisonh.utils;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * 视频下载工具类
 * Created by PoisonH on 2016/4/19.
 */
public class VideoDownloadUtils
{

    public static void videoDownload(String mStrVideoDownloadUrl, String mStrVideoName)
    {
        FileDownloader.getImpl().create(mStrVideoDownloadUrl).setPath(savePath() + mStrVideoName + ".mp4").setListener(new FileDownloadListener()
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
