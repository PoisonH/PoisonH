package com.poisonh.poisonh.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poisonh.poisonh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class BTBondedDeviceAdapter extends RecyclerView.Adapter<BTBondedDeviceAdapter.MyViewHolde>
{
    private Context mContext;
    private List<BluetoothDevice> mBondedDeviceList;
    private onItemClickListener monItemClickListener;

    public void setMonItemClickListener(onItemClickListener monItemClickListener)
    {
        this.monItemClickListener = monItemClickListener;
    }

    public BTBondedDeviceAdapter(Context context)
    {
        this.mContext = context;
        mBondedDeviceList = new ArrayList<>();
    }

    @Override
    public int getItemCount()
    {
        return mBondedDeviceList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolde holder, final int position)
    {
        holder.mTvBTName.setText(mBondedDeviceList.get(position).getName());
        holder.mTvBTAddress.setText(mBondedDeviceList.get(position).getAddress());
        holder.mLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                monItemClickListener.onClickListener(position);
            }
        });
    }

    @Override
    public MyViewHolde onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_bt_bondeddevice, null);
        return new MyViewHolde(view);
    }


    public class MyViewHolde extends RecyclerView.ViewHolder
    {
        private TextView mTvBTName;
        private TextView mTvBTAddress;
        private RelativeLayout mLayout;


        public MyViewHolde(View view)
        {
            super(view);
            mTvBTName = (TextView) view.findViewById(R.id.tv_btname);
            mTvBTAddress = (TextView) view.findViewById(R.id.tv_btaddress);
            mLayout = (RelativeLayout) view.findViewById(R.id.rl_layout);
        }
    }

    public void addData(List<BluetoothDevice> list)
    {
        mBondedDeviceList.addAll(list);
        this.notifyDataSetChanged();
    }

    public interface onItemClickListener
    {
        void onClickListener(int poision);
    }
}
