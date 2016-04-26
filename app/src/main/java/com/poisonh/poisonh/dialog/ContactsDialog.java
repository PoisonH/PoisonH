package com.poisonh.poisonh.dialog;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.BTBondedDeviceAdapter;
import com.poisonh.poisonh.utils.AppConstant;
import com.poisonh.poisonh.utils.BluetoothUtils;
import com.poisonh.poisonh.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class ContactsDialog extends DialogFragment implements BTBondedDeviceAdapter.onItemClickListener
{
    private RecyclerView mRecyclerView;
    private BTBondedDeviceAdapter mBTBondedDeviceAdapter;
    private List<BluetoothDevice> mBondedDeviceList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.layout_dialog_bt_bondeddevice, null);
        BluetoothUtils mBluetoothUtils = new BluetoothUtils(getActivity());
        mBondedDeviceList = mBluetoothUtils.getBondedDevice();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_bt_bonded_device);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        mBTBondedDeviceAdapter = new BTBondedDeviceAdapter(getActivity());
        mRecyclerView.setAdapter(mBTBondedDeviceAdapter);
        update();
        return view;
    }

    private void update()
    {
        mBTBondedDeviceAdapter.addData(mBondedDeviceList);
        mBTBondedDeviceAdapter.notifyDataSetChanged();
        mBTBondedDeviceAdapter.setMonItemClickListener(this);
    }

    @Override
    public void onClickListener(int poision)
    {
        //ToastUtils.showToast(getActivity(), "你点击了：" + mBondedDeviceList.get(poision).getAddress(), Toast.LENGTH_SHORT);
        Intent mIntent = new Intent();
        mIntent.setAction(AppConstant.CONNECTION_BT);
        mIntent.putExtra(AppConstant.CONNECTION_BT_ADDRESS, mBondedDeviceList.get(poision).getAddress());
        mIntent.putExtra(AppConstant.CONNECTION_BT_NAME, mBondedDeviceList.get(poision).getName());
        getActivity().sendBroadcast(mIntent);
    }

}
