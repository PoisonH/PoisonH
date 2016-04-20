package com.poisonh.poisonh.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.bean.DownloadTaskInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/4/15.
 */
public class DownloadListAdapter extends RecyclerView.Adapter<DownloadListAdapter.MyViewHolder>
{
    private Context mContext;
    private List<DownloadTaskInfo> mList;
    private static int UPDATE_BAR = 0;

    public DownloadListAdapter(Context context)
    {
        this.mContext = context;
        mList = new ArrayList<>();
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.mTvDownloadFileName.setText(mList.get(position).getFileName());
        holder.mPbBar.setProgress(mList.get(position).getDownFileSize());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_download, null);
        return new MyViewHolder(view);
    }


    protected class MyViewHolder extends RecyclerView.ViewHolder
    {
        private CheckBox mCheckBox;
        private ProgressBar mPbBar;
        private ImageButton mIbStartOrPause;
        private ImageButton mIbDelete;
        private TextView mTvDownloadFileName;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb_checked);
            mPbBar = (ProgressBar) itemView.findViewById(R.id.pb_bar);
            mIbStartOrPause = (ImageButton) itemView.findViewById(R.id.ib_start_or_pause);
            mIbDelete = (ImageButton) itemView.findViewById(R.id.ib_delete);
            mTvDownloadFileName = (TextView) itemView.findViewById(R.id.tv_download_filename);
        }
    }

    /**
     * 提供给外部一个数据添加接口
     *
     * @param list
     */
    public void setList(List<DownloadTaskInfo> list)
    {
        mList.addAll(list);
        this.notifyDataSetChanged();
    }

    /**
     * 提供一个外部添加单个下载任务的接口
     *
     * @param task
     */
    public void addTaskData(DownloadTaskInfo task)
    {
//        for (int i=0;i<mList.size();i++)
//        {
//            if (mList.get(i).equals(task.getTaskID()))
//            {
//                mList.remove(i);
//            }
//        }
        mList.clear();
        mList.add(task);
        Message message = Message.obtain();
        message.what = UPDATE_BAR;
        myHandler.sendMessage(message);
        this.notifyDataSetChanged();
    }

    Handler myHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 0:
                    break;
            }
        }
    };
}
