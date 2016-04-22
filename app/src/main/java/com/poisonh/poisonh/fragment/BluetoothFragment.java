package com.poisonh.poisonh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/30.
 */
public class BluetoothFragment extends BaseFragment
{
    private TextView mTvLinkMan;
    private ImageButton mIbContacts;
    private ImageButton mIbBluetoothSetting;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_bluetooth, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mTvLinkMan = (TextView) view.findViewById(R.id.tv_linkman);
        mIbContacts = (ImageButton) view.findViewById(R.id.ib_contacts);
        mIbBluetoothSetting = (ImageButton) view.findViewById(R.id.ib_bluetoothsetting);
    }
}
