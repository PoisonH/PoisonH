package com.poisonh.poisonh.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.poisonh.poisonh.bean.DataList;
import com.poisonh.poisonh.bean.DataListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/3/1.
 */
public class GsonUtils
{

    private static Gson mGson = new Gson();
    private static Context mContext;

    public static List<DataList> parseJson(String str)
    {
        List<DataList> mList = new ArrayList<>();
        DataList mDataList;
        int id;
        String title;
        String description;
        String picurl;
        String list_ico;
        String pubdate;
        int click;
        String typename;

        DataListEntity mEntity = mGson.fromJson(str, DataListEntity.class);
        if (null != mEntity.getData().getAd_data())
        {
            for (int i = 0; i < mEntity.getData().getAd_data().size(); i++)
            {
                mDataList = new DataList();
                id = mEntity.getData().getAd_data().get(i).getId();
                title = mEntity.getData().getAd_data().get(i).getTitle();
                description = mEntity.getData().getAd_data().get(i).getDescription();
                picurl = mEntity.getData().getAd_data().get(i).getPicurl();
                list_ico = mEntity.getData().getAd_data().get(i).getList_ico();
                pubdate = mEntity.getData().getAd_data().get(i).getPubdate();
                click = mEntity.getData().getAd_data().get(i).getClick();
                typename = mEntity.getData().getAd_data().get(i).getTypename();

                mDataList.setId(id);
                mDataList.setTitle(title);
                String desc = description.replace("&#8203;", "  ");
                mDataList.setDescription(desc);
                mDataList.setPicurl(picurl);
                mDataList.setList_ico(list_ico);
                mDataList.setPubdate(pubdate);
                mDataList.setClick(click);
                mDataList.setTypename(typename);

                mList.add(mDataList);
            }
        }
        for (int i = 0; i < mEntity.getData().getArticle_list().size(); i++)
        {
            mDataList = new DataList();
            id = mEntity.getData().getArticle_list().get(i).getId();
            title = mEntity.getData().getArticle_list().get(i).getTitle();
            description = mEntity.getData().getArticle_list().get(i).getDescription();
            picurl = mEntity.getData().getArticle_list().get(i).getPicurl();
            list_ico = mEntity.getData().getArticle_list().get(i).getList_ico();
            pubdate = mEntity.getData().getArticle_list().get(i).getPubdate();
            click = mEntity.getData().getArticle_list().get(i).getClick();
            typename = mEntity.getData().getArticle_list().get(i).getTypename();

            mDataList.setId(id);
            mDataList.setTitle(title);
            mDataList.setDescription(description);
            mDataList.setPicurl(picurl);
            mDataList.setList_ico(list_ico);
            mDataList.setPubdate(pubdate);
            mDataList.setClick(click);
            mDataList.setTypename(typename);

            mList.add(mDataList);
        }
        return mList;
    }
}




