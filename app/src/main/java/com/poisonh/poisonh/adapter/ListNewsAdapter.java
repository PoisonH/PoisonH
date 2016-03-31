package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poisonh.poisonh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/31.
 */
public class ListNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mContext;

    private List<String> list = new ArrayList<>();

    public ListNewsAdapter(Context context)
    {
        this.mContext = context;
        list = GetData();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_news_items, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof MyViewHolder)
        {
            ((MyViewHolder) holder).mTv.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTv;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    private List<String> GetData()
    {
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            mList.add("PoisonH" + i);
        }
        return mList;
    }
}
