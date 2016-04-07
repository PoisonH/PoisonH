package com.poisonh.poisonh.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.poisonh.poisonh.bean.NewsDataList;
import com.poisonh.poisonh.bean.NewsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/3/1.
 */
public class GsonUtils
{

    private static Gson mGson = new Gson();
    private static Context mContext;

    public static List<NewsDataList> parseJson(String str)
    {
        List<NewsDataList> mList = new ArrayList<>();
        NewsDataList mNewsDataList;
        int id;
        String title;
        String description;
        String picurl;
        String list_ico;
        String pubdate;
        int click;
        String typename;

        NewsEntity mEntity = mGson.fromJson(str, NewsEntity.class);
        if (null != mEntity.getData().getAd_data())
        {
            for (int i = 0; i < mEntity.getData().getAd_data().size(); i++)
            {
                mNewsDataList = new NewsDataList();
                id = mEntity.getData().getAd_data().get(i).getId();
                title = mEntity.getData().getAd_data().get(i).getTitle();
                description = mEntity.getData().getAd_data().get(i).getDescription();
                picurl = mEntity.getData().getAd_data().get(i).getPicurl();
                list_ico = mEntity.getData().getAd_data().get(i).getList_ico();
                pubdate = mEntity.getData().getAd_data().get(i).getPubdate();
                click = mEntity.getData().getAd_data().get(i).getClick();
                typename = mEntity.getData().getAd_data().get(i).getTypename();

                mNewsDataList.setId(id);
                mNewsDataList.setTitle(title);
                String desc = description.replace("&#8203;", "  ");
                mNewsDataList.setDescription(desc);
                mNewsDataList.setPicurl(picurl);
                mNewsDataList.setList_ico(list_ico);
                mNewsDataList.setPubdate(pubdate);
                mNewsDataList.setClick(click);
                mNewsDataList.setTypename(typename);

                mList.add(mNewsDataList);
            }
        }
        for (int i = 0; i < mEntity.getData().getArticle_list().size(); i++)
        {
            mNewsDataList = new NewsDataList();
            id = mEntity.getData().getArticle_list().get(i).getId();
            title = mEntity.getData().getArticle_list().get(i).getTitle();
            description = mEntity.getData().getArticle_list().get(i).getDescription();
            picurl = mEntity.getData().getArticle_list().get(i).getPicurl();
            list_ico = mEntity.getData().getArticle_list().get(i).getList_ico();
            pubdate = mEntity.getData().getArticle_list().get(i).getPubdate();
            click = mEntity.getData().getArticle_list().get(i).getClick();
            typename = mEntity.getData().getArticle_list().get(i).getTypename();

            mNewsDataList.setId(id);
            mNewsDataList.setTitle(title);
            mNewsDataList.setDescription(description);
            mNewsDataList.setPicurl(picurl);
            mNewsDataList.setList_ico(list_ico);
            mNewsDataList.setPubdate(pubdate);
            mNewsDataList.setClick(click);
            mNewsDataList.setTypename(typename);

            mList.add(mNewsDataList);
        }
        return mList;
    }
}




