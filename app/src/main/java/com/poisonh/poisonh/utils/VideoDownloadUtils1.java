package com.poisonh.poisonh.utils;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频下载工具类
 * Created by PoisonH on 2016/4/19.
 */
public class VideoDownloadUtils1
{

    public static int SERIAL_OR_PARALLEL = 1;
    private FileDownloadListener mFileDownloadListener;
    private List<BaseDownloadTask> mTask = new ArrayList<>();

    public void videoDownload(String mStrVideoDownloadUrl, String mStrVideoName)
    {
        int count = 10;
        //配置默认的存储路径
        FileDownloadUtils.setDefaultSaveRootPath(savePath());
        mFileDownloadListener = createFileDownloadListener();
        FileDownloadQueueSet mFileDownloadQueueSet = new FileDownloadQueueSet(mFileDownloadListener);
        for (int i = 0; i < mTask.size(); i++)
        {
            mTask.add(FileDownloader.getImpl().create(mStrVideoDownloadUrl).setTag(mStrVideoName));
        }
        //由于是队列任务, 这里是我们假设了现在不需要每个任务都回调`FileDownloadListener#progress`,
        // 我们只关系每个任务是否完成, 所以这里这样设置可以很有效的减少ipc.
        // mFileDownloadQueueSet.disableCallbackProgressTimes();
        //所有任务在下载失败的时候都自动重试一次
        mFileDownloadQueueSet.setAutoRetryTimes(1);

        if (SERIAL_OR_PARALLEL == 0)
        {
            // 串行执行该任务队列
            mFileDownloadQueueSet.downloadSequentially(mTask);
        } else if (SERIAL_OR_PARALLEL == 1)
        {
            // 并行执行该任务队列
            mFileDownloadQueueSet.downloadTogether(mTask);

        }
        //开启下载任务
        mFileDownloadQueueSet.start();
    }

    /**
     * 暂停下载
     */
    public void pause()
    {
        FileDownloader.getImpl().pause(mFileDownloadListener);
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

    private FileDownloadListener createFileDownloadListener()
    {
        return new FileDownloadListener()
        {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {
                // 之所以加这句判断，是因为有些异步任务在pause以后，会持续回调pause回来，而有些任务在pause之前已经完成，
                // 但是通知消息还在线程池中还未回调回来，这里可以优化
                // 后面所有在回调中加这句都是这个原因
                if (task.getListener() != mFileDownloadListener)
                {
                    return;
                }
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {
            }

            @Override
            protected void blockComplete(BaseDownloadTask task)
            {

            }

            @Override
            protected void completed(BaseDownloadTask task)
            {

            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes)
            {

            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e)
            {

            }

            @Override
            protected void warn(BaseDownloadTask task)
            {

            }
        };
    }
}
