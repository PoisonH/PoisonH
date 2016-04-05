package com.poisonh.poisonh.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PoisonH on 2016/2/22.
 */
public class DataListEntity implements Serializable
{

    private boolean status;
    private String message;
    private DataEntity data;

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setData(DataEntity data)
    {
        this.data = data;
    }

    public boolean isStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }

    public DataEntity getData()
    {
        return data;
    }

    public class DataEntity implements Serializable
    {

        private List<AdDataEntity> ad_data;

        private List<ArticleListEntity> article_list;

        public void setAd_data(List<AdDataEntity> ad_data)
        {
            this.ad_data = ad_data;
        }

        public void setArticle_list(List<ArticleListEntity> article_list)
        {
            this.article_list = article_list;
        }

        public List<AdDataEntity> getAd_data()
        {
            return ad_data;
        }

        public List<ArticleListEntity> getArticle_list()
        {
            return article_list;
        }

    }

    public class AdDataEntity implements Serializable
    {
        private int id;
        private String title;
        private String description;
        private String picurl;
        private String list_ico;
        private String content;
        private String pubdate;
        private int click;
        private String typename;

        public void setId(int id)
        {
            this.id = id;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public void setPicurl(String picurl)
        {
            this.picurl = picurl;
        }

        public void setList_ico(String list_ico)
        {
            this.list_ico = list_ico;
        }

        public void setContent(String content)
        {
            this.content = content;
        }

        public void setPubdate(String pubdate)
        {
            this.pubdate = pubdate;
        }

        public void setClick(int click)
        {
            this.click = click;
        }

        public void setTypename(String typename)
        {
            this.typename = typename;
        }

        public int getId()
        {
            return id;
        }

        public String getTitle()
        {
            return title;
        }

        public String getDescription()
        {
            return description;
        }

        public String getPicurl()
        {
            return picurl;
        }

        public String getList_ico()
        {
            return list_ico;
        }

        public String getContent()
        {
            return content;
        }

        public String getPubdate()
        {
            return pubdate;
        }

        public int getClick()
        {
            return click;
        }

        public String getTypename()
        {
            return typename;
        }
    }

    public class ArticleListEntity implements Serializable
    {
        private int id;
        private String title;
        private String description;
        private String picurl;
        private String list_ico;
        private String content;
        private String pubdate;
        private int click;
        private String typename;
        private String type;
        private String type_color;

        public void setId(int id)
        {
            this.id = id;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        public void setPicurl(String picurl)
        {
            this.picurl = picurl;
        }

        public void setList_ico(String list_ico)
        {
            this.list_ico = list_ico;
        }

        public void setContent(String content)
        {
            this.content = content;
        }

        public void setPubdate(String pubdate)
        {
            this.pubdate = pubdate;
        }

        public void setClick(int click)
        {
            this.click = click;
        }

        public void setTypename(String typename)
        {
            this.typename = typename;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public void setType_color(String type_color)
        {
            this.type_color = type_color;
        }

        public int getId()
        {
            return id;
        }

        public String getTitle()
        {
            return title;
        }

        public String getDescription()
        {
            return description;
        }

        public String getPicurl()
        {
            return picurl;
        }

        public String getList_ico()
        {
            return list_ico;
        }

        public String getContent()
        {
            return content;
        }

        public String getPubdate()
        {
            return pubdate;
        }

        public int getClick()
        {
            return click;
        }

        public String getTypename()
        {
            return typename;
        }

        public String getType()
        {
            return type;
        }

        public String getType_color()
        {
            return type_color;
        }
    }
}
