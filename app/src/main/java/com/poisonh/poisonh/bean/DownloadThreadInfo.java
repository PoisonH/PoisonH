package com.poisonh.poisonh.bean;

/**
 * 下载线程信息
 * Created by PoisonH on 2016/4/20.
 */
public class DownloadThreadInfo
{
    private int mThreadId;
    private int mFileUrl;
    private int mStart;
    private int mEnd;
    private int mFinished;

    public DownloadThreadInfo()
    {
    }

    public DownloadThreadInfo(int mFinished, int mThreadId, int mFileUrl, int mStart, int mEnd)
    {
        this.mFinished = mFinished;
        this.mThreadId = mThreadId;
        this.mFileUrl = mFileUrl;
        this.mStart = mStart;
        this.mEnd = mEnd;
    }

    public int getmThreadId()
    {
        return mThreadId;
    }

    public void setmThreadId(int mThreadId)
    {
        this.mThreadId = mThreadId;
    }

    public int getmFileUrl()
    {
        return mFileUrl;
    }

    public void setmFileUrl(int mFileUrl)
    {
        this.mFileUrl = mFileUrl;
    }

    public int getmStart()
    {
        return mStart;
    }

    public void setmStart(int mStart)
    {
        this.mStart = mStart;
    }

    public int getmEnd()
    {
        return mEnd;
    }

    public void setmEnd(int mEnd)
    {
        this.mEnd = mEnd;
    }

    public int getmFinished()
    {
        return mFinished;
    }

    public void setmFinished(int mFinished)
    {
        this.mFinished = mFinished;
    }
}
