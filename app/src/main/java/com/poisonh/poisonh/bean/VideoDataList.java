package com.poisonh.poisonh.bean;

/**
 * Created by PoisonH on 2016/4/7.
 */
public class VideoDataList
{
    //视频id
    private String id;
    //标题
    private String mStrVideoTitle;
    //点赞次数
    private String up;
    //低俗
    private String down;
    //转换
    private String forward;
    //时长
    private String duration;
    //播放地址
    private String mStrPlayUrl;
    //图片地址
    private String mStrPicUrl;
    //下载地址
    private String mStrDownloadUrl;
    //出版日期
    private String passtime;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getmStrVideoTitle()
    {
        return mStrVideoTitle;
    }

    public void setmStrVideoTitle(String mStrVideoTitle)
    {
        this.mStrVideoTitle = mStrVideoTitle;
    }

    public String getUp()
    {
        return up;
    }

    public void setUp(String up)
    {
        this.up = up;
    }

    public String getDown()
    {
        return down;
    }

    public void setDown(String down)
    {
        this.down = down;
    }

    public String getForward()
    {
        return forward;
    }

    public void setForward(String forward)
    {
        this.forward = forward;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getmStrPlayUrl()
    {
        return mStrPlayUrl;
    }

    public void setmStrPlayUrl(String mStrPlayUrl)
    {
        this.mStrPlayUrl = mStrPlayUrl;
    }

    public String getmStrPicUrl()
    {
        return mStrPicUrl;
    }

    public void setmStrPicUrl(String mStrPicUrl)
    {
        this.mStrPicUrl = mStrPicUrl;
    }

    public String getmStrDownloadUrl()
    {
        return mStrDownloadUrl;
    }

    public void setmStrDownloadUrl(String mStrDownloadUrl)
    {
        this.mStrDownloadUrl = mStrDownloadUrl;
    }

    public String getPasstime()
    {
        return passtime;
    }

    public void setPasstime(String passtime)
    {
        this.passtime = passtime;
    }
}
