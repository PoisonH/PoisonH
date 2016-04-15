package com.poisonh.poisonh.bean;

/**
 * * Created by PoisonH on 2016/4/15.
 */

public class DownloadTaskInfo
{
    //是否正在下载
    private boolean isOnDownloading;
    //任务id
    private String taskID;
    //任务名字
    private String fileName;
    //文件大小
    private long fileSize = 0;
    //下载大小
    private long downFileSize = 0;

    public boolean isOnDownloading()
    {
        return isOnDownloading;
    }

    public void setOnDownloading(boolean isOnDownloading)
    {
        this.isOnDownloading = isOnDownloading;
    }

    public int getProgress()
    {
        if (fileSize == 0)
        {
            return 0;
        } else
        {
            return ((int) (100 * downFileSize / fileSize));
        }

    }

    public String getTaskID()
    {
        return taskID;
    }

    public void setTaskID(String taskID)
    {
        this.taskID = taskID;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getType()
    {
        String type = null;
        if (fileName != null)
        {
            String name = fileName.toLowerCase();
            if (name.contains("."))
            {
                type = name.substring(name.lastIndexOf("."), name.length());
            }
        }

        return type;
    }

    public long getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(long fileSize)
    {
        this.fileSize = fileSize;
    }

    public long getDownFileSize()
    {
        return downFileSize;
    }

    public void setDownFileSize(long downFileSize)
    {
        this.downFileSize = downFileSize;
    }

}
