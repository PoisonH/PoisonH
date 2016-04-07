package com.poisonh.poisonh.bean;

import java.io.Serializable;

/**
 * Created by PoisonH on 2016/3/1.
 */
public class NewsDataList implements Serializable
{
    private int id;
    private String title;
    private String description;
    private String picurl;
    private String list_ico;
    private String pubdate;
    private int click;
    private String typename;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPicurl()
    {
        return picurl;
    }

    public void setPicurl(String picurl)
    {
        this.picurl = picurl;
    }

    public String getList_ico()
    {
        return list_ico;
    }

    public void setList_ico(String list_ico)
    {
        this.list_ico = list_ico;
    }

    public String getPubdate()
    {
        return pubdate;
    }

    public void setPubdate(String pubdate)
    {
        this.pubdate = pubdate;
    }

    public int getClick()
    {
        return click;
    }

    public void setClick(int click)
    {
        this.click = click;
    }

    public String getTypename()
    {
        return typename;
    }

    public void setTypename(String typename)
    {
        this.typename = typename;
    }
}
