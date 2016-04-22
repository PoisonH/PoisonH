package com.poisonh.poisonh.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by PoisonH on 2016/4/22.
 */
public class BluetoothUtils
{
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;

    public BluetoothUtils(Context context)
    {
        this.mContext = context;
    }

    public void SearchBluetooth()
    {
        //获得默认蓝牙适配器
        if (mBluetoothAdapter == null)
        {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (!mBluetoothAdapter.isEnabled())
        {
            ToastUtils.showToast(mContext, "当前蓝牙不可用，请确认蓝牙是否打开", Toast.LENGTH_SHORT);
        } else
        {
            //获得已经配对的蓝牙
            Set<BluetoothDevice> mSet = mBluetoothAdapter.getBondedDevices();
            if (mSet.size() != 0)
            {
                //使用迭代器进行迭代输出已配对蓝牙设备
                for (Iterator mIterator = mSet.iterator(); mIterator.hasNext(); )
                {
                    BluetoothDevice mDevice = (BluetoothDevice) mIterator.next();
                    Log.i("BluetoothUtils", mDevice.getName());
                }
            }
            mBluetoothAdapter.startDiscovery();

            IntentFilter mIntentFilter = new IntentFilter();
            mIntentFilter.addAction(BluetoothDevice.ACTION_FOUND);
            mContext.registerReceiver(mBluetoothBroacastReceiver, mIntentFilter);
        }
    }

    BroadcastReceiver mBluetoothBroacastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action))
            {
                //只要BluetoothReceiver接收到来自于系统的广播,这个广播是什么呢,是我找到了一个远程蓝牙设备
                //Intent代表刚刚发现远程蓝牙设备适配器的对象,可以从收到的Intent对象取出一些信息
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String name = bluetoothDevice.getName();
                Log.i("BluetoothUtils", "发现:" + bluetoothDevice.getAddress());
            }
        }
    };
}
