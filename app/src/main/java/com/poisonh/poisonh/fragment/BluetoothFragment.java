package com.poisonh.poisonh.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.dialog.ContactsDialog;
import com.poisonh.poisonh.service.BluetoothChatService;
import com.poisonh.poisonh.utils.AppConstant;

/**
 * Created by Administrator on 2016/3/30.
 */
public class BluetoothFragment extends BaseFragment implements View.OnClickListener
{
    private TextView mTvLinkMan;
    private ImageButton mIbContacts;
    private ImageButton mIbBluetoothSetting;
    private RecyclerView mRecyclerView;
    private EditText mEtChatContent;
    private Button mBtnSend;
    private BluetoothChatService mChatService;
    private BluetoothAdapter mBluetoothAdapter;
    private TextView mTvBtState;
    private ContactsDialog mContactsDialog;

    @Override
    public void onStart()
    {
        super.onStart();
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(AppConstant.CONNECTION_BT);
        getActivity().registerReceiver(mBroadcastReceiver, mIntentFilter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_fragment_bluetooth, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mChatService = new BluetoothChatService(getActivity(), mHandler);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mTvBtState = (TextView) view.findViewById(R.id.tv_bt_state);
        mTvLinkMan = (TextView) view.findViewById(R.id.tv_linkman);
        mIbContacts = (ImageButton) view.findViewById(R.id.ib_contacts);
        mIbBluetoothSetting = (ImageButton) view.findViewById(R.id.ib_bluetoothsetting);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mEtChatContent = (EditText) view.findViewById(R.id.et_content);
        mBtnSend = (Button) view.findViewById(R.id.btn_send);
        mIbContacts.setOnClickListener(this);
        mIbBluetoothSetting.setOnClickListener(this);
        mBtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.ib_contacts:
                showContactsDialog();
                break;
            case R.id.ib_bluetoothsetting:
                break;
            case R.id.btn_send:
                break;
        }
    }

    /**
     * 显示蓝牙联系人dialog
     */
    private void showContactsDialog()
    {
        mContactsDialog = new ContactsDialog();
        mContactsDialog.show(getFragmentManager(), "");
    }

    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            mContactsDialog.dismiss();
            // Get the device MAC address
            String address = intent.getExtras().getString(AppConstant.FRAGMENT_BACK_VALUE);
            // Get the BluetoothDevice object
            BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
            mChatService.connect(device, false);
        }
    };


    private void setStatus(String state)
    {
        mTvBtState.setText(state);
    }

    /**
     * The Handler that gets information back from the BluetoothChatService
     */
    private final Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            FragmentActivity activity = getActivity();
            switch (msg.what)
            {
                case AppConstant.MESSAGE_STATE_CHANGE:
                    switch (msg.arg1)
                    {
                        case BluetoothChatService.STATE_CONNECTED:
                            setStatus(R.string.bt_state_connectioning + "");
                            //mConversationArrayAdapter.clear();
                            break;
                        case BluetoothChatService.STATE_CONNECTING:
                            setStatus(R.string.bt_state_connectioning + "");
                            break;
                        case BluetoothChatService.STATE_LISTEN:
                        case BluetoothChatService.STATE_NONE:
                            //  setStatus(R.string.title_not_connected);
                            break;
                    }
                    break;
                case AppConstant.MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;
                    // construct a string from the buffer
                    String writeMessage = new String(writeBuf);
                    //mConversationArrayAdapter.add("Me:  " + writeMessage);
                    break;
                case AppConstant.MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    // construct a string from the valid bytes in the buffer
                    String readMessage = new String(readBuf, 0, msg.arg1);
                    // mConversationArrayAdapter.add(mConnectedDeviceName + ":  " + readMessage);
                    break;
                case AppConstant.MESSAGE_DEVICE_NAME:
                    // save the connected device's name
//                    mConnectedDeviceName = msg.getData().getString(AppConstant.DEVICE_NAME);
//                    if (null != activity)
//                    {
//                        Toast.makeText(activity, "Connected to " + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
//                    }
                    break;
                case AppConstant.MESSAGE_TOAST:
                    if (null != activity)
                    {
                        Toast.makeText(activity, msg.getData().getString(AppConstant.TOAST), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };


}
