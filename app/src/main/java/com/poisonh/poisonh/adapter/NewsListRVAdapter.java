package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.poisonh.poisonh.R;
import com.poisonh.poisonh.bean.DataList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/2/26.
 */
public class NewsListRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private Context mContext;
    private List<DataList> mList;
    private String mStrFileName;
    public OnItemClickLitener mOnItemClickLitener;

    public NewsListRVAdapter(Context context)
    {
        this.mContext = context;
        mList = new ArrayList<>();
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener)
    {
        this.mOnItemClickLitener = onItemClickLitener;
    }

    /**
     * RcyclerView的点击事件
     */
    public interface OnItemClickLitener
    {
        /**
         * 点击
         *
         * @param view
         * @param position
         */
        void onItemClick(View view, int position);

        /**
         * 长按
         *
         * @param view
         * @param position
         */
        void onItemLongClick(View view, int position);
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof RecyclerHolder)
        {
            DataList mDataList = mList.get(position);
            if (null == mDataList)
            {
                return;
            }
            Uri mPicUri = Uri.parse(mList.get(position).getPicurl());
            ((RecyclerHolder) holder).sdv_imageview.setImageURI(mPicUri);
            ((RecyclerHolder) holder).tv_title.setText(mList.get(position).getTitle());
            Spanned txt = Html.fromHtml(mList.get(position).getDescription());
            ((RecyclerHolder) holder).tv_description.setText(txt);
            ((RecyclerHolder) holder).tv_pubDate.setText(mList.get(position).getPubdate());
        }
        /**
         * 分别设置点击事件的回调
         */
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getPosition();
                    mOnItemClickLitener.onItemClick(v, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getPosition();
                    mOnItemClickLitener.onItemLongClick(v, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_layout, null);
        return new RecyclerHolder(view);
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder
    {
        public SimpleDraweeView sdv_imageview;
        public TextView tv_title;
        public TextView tv_description;
        public TextView tv_pubDate;

        public RecyclerHolder(View view)
        {
            super(view);
            sdv_imageview = (SimpleDraweeView) itemView.findViewById(R.id.sdv);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_description = (TextView) itemView.findViewById(R.id.tv_description);
            tv_pubDate = (TextView) itemView.findViewById(R.id.tv_pubDate);
        }
    }

    public void setData(List<DataList> lists)
    {
        mList.addAll(mList.size(), lists);
        this.notifyDataSetChanged();
    }

    public List<DataList> getData()
    {
        return mList;
    }

    public void cleanListData()
    {
        if (mList != null || mList.size() >= 0)
        {
            mList.clear();
        }
    }

    public void setmStrFileName(String mStrFileName)
    {
        this.mStrFileName = mStrFileName;
    }
}
