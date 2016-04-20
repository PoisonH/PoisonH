package com.poisonh.poisonh.bean;

import android.content.Context;

import java.io.Serializable;

/**
 * 下载文件信息
 * Created by PoisonH on 2016/4/20.
 */
public class DownloadFileInfo implements Serializable
{
    //文件id
    private int mFileId;
    //文件地址
    private String mFileUrl;
    //文件名字
    private String mFileName;
    //文件长度
    private int mFileLength;
    //下载完成进度
    private int mFileFinished;

    public DownloadFileInfo()
    {
    }

    public DownloadFileInfo(int mFileId, String mFileUrl, String mFileName, int mFileLength, int mFileFinished)
    {
        this.mFileId = mFileId;
        this.mFileUrl = mFileUrl;
        this.mFileName = mFileName;
        this.mFileLength = mFileLength;
        this.mFileFinished = mFileFinished;
    }

    public int getmFileId()
    {
        return mFileId;
    }

    public void setmFileId(int mFileId)
    {
        this.mFileId = mFileId;
    }

    public String getmFileUrl()
    {
        return mFileUrl;
    }

    public void setmFileUrl(String mFileUrl)
    {
        this.mFileUrl = mFileUrl;
    }

    public String getmFileName()
    {
        return mFileName;
    }

    public void setmFileName(String mFileName)
    {
        this.mFileName = mFileName;
    }

    public int getmFileLength()
    {
        return mFileLength;
    }

    public void setmFileLength(int mFileLength)
    {
        this.mFileLength = mFileLength;
    }

    public int getmFileFinished()
    {
        return mFileFinished;
    }

    public void setmFileFinished(int mFileFinished)
    {
        this.mFileFinished = mFileFinished;
    }

}
