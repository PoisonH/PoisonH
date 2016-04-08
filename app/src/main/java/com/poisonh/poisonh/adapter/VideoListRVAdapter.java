package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.poisonh.poisonh.R;
import com.poisonh.poisonh.bean.VideoDataList;
import com.poisonh.poisonh.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/31.
 */
public class VideoListRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mContext;
    private List<VideoDataList> list;

    private onWidgetClickListener monWidgetClickListener;

    public void setMonWidgetClickListener(onWidgetClickListener monWidgetClickListener)
    {
        this.monWidgetClickListener = monWidgetClickListener;
    }

    public VideoListRVAdapter(Context context)
    {
        this.mContext = context;
        list = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_vedio, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)
    {
        if (holder instanceof MyViewHolder)
        {
            ((MyViewHolder) holder).mTvVedioTitle.setText(list.get(position).getmStrVideoTitle());
            Uri mPicUri = Uri.parse(list.get(position).getmStrPicUrl());
            ((MyViewHolder) holder).mSdvBackground.setImageURI(mPicUri);
            ((MyViewHolder) holder).mTvDianZan.setText(list.get(position).getUp());
            ((MyViewHolder) holder).mTvDiSu.setText(list.get(position).getDown());
            ((MyViewHolder) holder).mTvZhuanFa.setText(list.get(position).getForward());
            ((MyViewHolder) holder).mTvDuration.setText(list.get(position).getDuration());

            final int pos = holder.getPosition();
            ((MyViewHolder) holder).mIbPlay.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    monWidgetClickListener.onWidgetClick(v, pos);
                }
            });
            ((MyViewHolder) holder).mIbDianZan.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    monWidgetClickListener.onWidgetClick(v, pos);
                }
            });
            ((MyViewHolder) holder).mIbDiSu.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    monWidgetClickListener.onWidgetClick(v, pos);
                }
            });
            ((MyViewHolder) holder).mIbZhuanFa.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    monWidgetClickListener.onWidgetClick(v, pos);
                }
            });


        }

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvVedioTitle;
        private SimpleDraweeView mSdvBackground;
        private ImageButton mIbPlay;
        private ImageButton mIbDianZan;
        private ImageButton mIbDiSu;
        private ImageButton mIbZhuanFa;
        private TextView mTvDianZan;
        private TextView mTvDiSu;
        private TextView mTvZhuanFa;
        private TextView mTvDuration;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            mTvVedioTitle = (TextView) itemView.findViewById(R.id.tv_vedio_title);
            mSdvBackground = (SimpleDraweeView) itemView.findViewById(R.id.sdv_background);

            mIbPlay = (ImageButton) itemView.findViewById(R.id.ib_play);
            mIbDianZan = (ImageButton) itemView.findViewById(R.id.ib_dianzan);
            mIbDiSu = (ImageButton) itemView.findViewById(R.id.ib_disu);
            mIbZhuanFa = (ImageButton) itemView.findViewById(R.id.ib_zhuanfa);

            mTvDianZan = (TextView) itemView.findViewById(R.id.tv_dianzan);
            mTvDiSu = (TextView) itemView.findViewById(R.id.tv_disu);
            mTvZhuanFa = (TextView) itemView.findViewById(R.id.tv_zhuanfa);
            mTvDuration = (TextView) itemView.findViewById(R.id.tv_duration);
        }
    }

    public void setData(List<VideoDataList> lists)
    {
        list.addAll(list.size(), lists);
        this.notifyDataSetChanged();

    }

    public boolean getData()
    {
        if (list.size() != 0)
        {
            return true;
        } else
        {
            return false;
        }

    }

    public void cleanListData()
    {
        if (list != null || list.size() >= 0)
        {
            list.clear();
        }
    }

    /**
     * items上面控件点击事件
     */
    public interface onWidgetClickListener
    {
        void onWidgetClick(View view, int postion);
    }
}
