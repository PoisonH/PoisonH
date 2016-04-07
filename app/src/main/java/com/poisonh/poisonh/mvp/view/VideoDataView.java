package com.poisonh.poisonh.mvp.view;

import com.poisonh.poisonh.bean.VideoDataList;

import java.util.List;

/**
 * Created by PoisonH on 2016/4/7.
 */
public interface VideoDataView
{
    //显示进度条
    void showProgress();

    //隐藏进度条
    void hideProgress();

    //添加数据
    void addListData(List<VideoDataList> lists);

    //显示加载失败显示
    void showLoadFailMsg();
}
