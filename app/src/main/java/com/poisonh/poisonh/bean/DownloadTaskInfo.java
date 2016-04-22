package com.poisonh.poisonh.bean;

/**
 * * Created by PoisonH on 2016/4/15.
 */

public class DownloadTaskInfo
{
    //是否正在下载
    private boolean isOnDownloading;
    //任务id
    private int taskID;
    //任务名字
    private String fileName;
    //文件大小
    private int fileSize = 0;
    //下载大小
    private int downFileSize = 0;

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

    public int getTaskID()
    {
        return taskID;
    }

    public void setTaskID(int taskID)
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

    public int getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(int fileSize)
    {
        this.fileSize = fileSize;
    }

    public int getDownFileSize()
    {
        return downFileSize;
    }

    public void setDownFileSize(int downFileSize)
    {
        this.downFileSize = downFileSize;
    }

    public void update(int downloadSize)
    {
        this.downFileSize = downloadSize;
    }

}
