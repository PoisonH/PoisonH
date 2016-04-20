package com.poisonh.poisonh.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.poisonh.poisonh.bean.DownloadFileInfo;
import com.poisonh.poisonh.utils.AppConstant;
import com.poisonh.poisonh.utils.VideoDownloadUtils;

/**
 * 视频下载后台服务
 * Created by PoisonH on 2016/4/20.
 */
public class DownloadService extends Service
{
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if (AppConstant.DOWNLOAD_ACTION_START.equals(intent.getAction()))
        {
            //下载
            DownloadFileInfo mFileInfo = (DownloadFileInfo) intent.getSerializableExtra(AppConstant.DOWNLOAD_FILEINFO);
            VideoDownloadUtils.videoDownload(mFileInfo.getmFileId(),mFileInfo.getmFileUrl(), mFileInfo.getmFileName());
        } else if (AppConstant.DOWNLOAD_ACTION_STOP.equals(intent.getAction()))
        {
            //暂停
            DownloadFileInfo mFileInfo = (DownloadFileInfo) intent.getSerializableExtra(AppConstant.DOWNLOAD_FILEINFO);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
