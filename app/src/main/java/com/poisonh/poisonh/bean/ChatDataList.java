package com.poisonh.poisonh.bean;

/**
 * Created by PoisonH on 2016/4/26.
 */
public class ChatDataList
{
    public static final int SEND = 0;
    public static final int RECEIVER = 1;
    private String content;
    private String time;
    private int flag;

    public ChatDataList(String content, int flag, String time)
    {
        this.content = content;
        this.flag = flag;
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }
}
