package com.poisonh.poisonh.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.poisonh.poisonh.bean.NewsDataList;
import com.poisonh.poisonh.bean.NewsEntity;
import com.poisonh.poisonh.bean.VideoDataEntity;
import com.poisonh.poisonh.bean.VideoDataList;

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

    public static List<VideoDataList> parseVideoJson(String str)
    {
        List<VideoDataList> mVideoList = new ArrayList<>();
        VideoDataList mVideoDataList;

        //视频id
        String id;
        //标题
        String mStrVideoTitle;
        //点赞次数
        String up;
        //低俗
        int down;
        //转换
        String forward;
        //时长
        int duration;
        //播放地址
        String mStrPlayUrl;
        //图片地址
        String mStrPicUrl;
        //下载地址
        String mStrDownloadUrl;
        //出版日期
        String passtime;

        VideoDataEntity mVideoEntity = mGson.fromJson(str, VideoDataEntity.class);
        if (mVideoEntity.getList().size() != 0)
        {
            for (int i = 0; i < mVideoEntity.getList().size(); i++)
            {
                mVideoDataList = new VideoDataList();
                id = mVideoEntity.getList().get(i).getId();
                mStrVideoTitle = mVideoEntity.getList().get(i).getText();
                up = mVideoEntity.getList().get(i).getUp();
                down = mVideoEntity.getList().get(i).getDown();
                forward = mVideoEntity.getList().get(i).getForward();
                duration = mVideoEntity.getList().get(i).getVideo().getDuration();
                mStrPlayUrl = mVideoEntity.getList().get(i).getVideo().getVideo().get(0);
                mStrPicUrl = mVideoEntity.getList().get(i).getVideo().getThumbnail().get(0);
                mStrDownloadUrl = mVideoEntity.getList().get(i).getVideo().getDownload().get(0);
                passtime = mVideoEntity.getList().get(i).getPasstime();

                mVideoDataList.setId(id);
                mVideoDataList.setmStrVideoTitle(mStrVideoTitle);
                mVideoDataList.setUp(up);
                mVideoDataList.setDown(down + "");
                mVideoDataList.setForward(forward);
                mVideoDataList.setDuration(duration + "");
                mVideoDataList.setmStrPlayUrl(mStrPlayUrl);
                mVideoDataList.setmStrPicUrl(mStrPicUrl);
                mVideoDataList.setmStrDownloadUrl(mStrDownloadUrl);
                mVideoDataList.setPasstime(passtime);

                mVideoList.add(mVideoDataList);
            }
        }
        return mVideoList;
    }
}




