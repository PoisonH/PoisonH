package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.bean.ChatDataList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/4/26.
 */
public class BtChatRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mContext;
    private List<ChatDataList> mChatDataList;

    public BtChatRVAdapter(Context context)
    {
        this.mContext = context;
        mChatDataList = new ArrayList<>();
    }

    @Override
    public int getItemCount()
    {
        return mChatDataList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof LeftViewHolder)
        {
            if (mChatDataList != null)
            {
                ((LeftViewHolder) holder).mTvLsftContent.setText(mChatDataList.get(position).getContent());
            }
        }
        if (holder instanceof RightViewHolder)
        {
            if (mChatDataList != null)
            {
                ((RightViewHolder) holder).mTvRightContent.setText(mChatDataList.get(position).getContent());
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType == ChatDataList.RECEIVER)
        {
            return new LeftViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_chat_left, null));
        } else if (viewType == ChatDataList.SEND)
        {
            return new RightViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_chat_right, null));
        }
        return null;
    }

    @Override
    public int getItemViewType(int position)
    {
        return mChatDataList.get(position).getFlag();
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvLsftContent;

        public LeftViewHolder(View v)
        {
            super(v);
            mTvLsftContent = (TextView) v.findViewById(R.id.tv_left_content);
        }
    }

    public class RightViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvRightContent;

        public RightViewHolder(View v)
        {
            super(v);
            mTvRightContent = (TextView) v.findViewById(R.id.tv_right_content);
        }
    }

    public void setData(ChatDataList item)
    {
        mChatDataList.add(0,item);
        this.notifyDataSetChanged();
    }
}
