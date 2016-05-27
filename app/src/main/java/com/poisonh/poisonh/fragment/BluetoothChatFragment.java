package com.poisonh.poisonh.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
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
import com.poisonh.poisonh.adapter.BtChatRVAdapter;
import com.poisonh.poisonh.base.BaseFragment;
import com.poisonh.poisonh.bean.ChatDataList;
import com.poisonh.poisonh.dialog.ContactsDialog;
import com.poisonh.poisonh.service.BluetoothChatService;
import com.poisonh.poisonh.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class BluetoothChatFragment extends BaseFragment implements View.OnClickListener
{
    private TextView mTvLinkMan;
    private ImageButton mIbContacts;
    private ImageButton mIbBluetoothSetting;
    private RecyclerView mRecyclerView;
    private EditText mEtChatContent;
    private Button mBtnSend;
    private BluetoothChatService mChatService;
    private BluetoothAdapter mBluetoothAdapter;
    private ContactsDialog mContactsDialog;
    private BluetoothDevice device;
    private String mStrBtAddress;
    private String mStrBtName;
    private List<ChatDataList> mList;
    private BtChatRVAdapter mBtChatRVAdapter;

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
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mChatService = new BluetoothChatService(getActivity(), mHandler);
        mTvLinkMan = (TextView) view.findViewById(R.id.tv_linkman);
        mIbContacts = (ImageButton) view.findViewById(R.id.ib_contacts);
        mIbBluetoothSetting = (ImageButton) view.findViewById(R.id.ib_bluetoothsetting);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mEtChatContent = (EditText) view.findViewById(R.id.et_content);
        mBtnSend = (Button) view.findViewById(R.id.btn_send);
        mIbContacts.setOnClickListener(this);
        mIbBluetoothSetting.setOnClickListener(this);
        mBtnSend.setOnClickListener(this);
        mList = new ArrayList<>();
        mBtChatRVAdapter = new BtChatRVAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        //底部填充数据
        manager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mBtChatRVAdapter);
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
                String mStrContent = mEtChatContent.getText().toString();
                sendMessage(mStrContent);
                break;
        }
    }

    /**
     * 发送消息
     */
    private void sendMessage(String mStrContent)
    {
        // Check that we're actually connected before trying anything
        if (mChatService.getState() != BluetoothChatService.STATE_CONNECTED)
        {
            Toast.makeText(getActivity(), "已断开连接", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check that there's actually something to send
        if (mStrContent.length() > 0)
        {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = mStrContent.getBytes();
            mChatService.write(send);
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
            mStrBtAddress = intent.getExtras().getString(AppConstant.CONNECTION_BT_ADDRESS);
            mStrBtName = intent.getExtras().getString(AppConstant.CONNECTION_BT_NAME);
            // Get the BluetoothDevice object
            device = mBluetoothAdapter.getRemoteDevice(mStrBtAddress);
            mChatService.connect(device, true);
        }
    };


    private void setStatus(String state)
    {
        mTvLinkMan.setText(state);
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
                            setStatus(getString(R.string.bt_connectioned, mStrBtName));
                            //mConversationArrayAdapter.clear();
                            break;
                        case BluetoothChatService.STATE_CONNECTING:
                            setStatus(getString(R.string.bt_connectioning, mStrBtName));
                            break;
                        case BluetoothChatService.STATE_LISTEN:
                        case BluetoothChatService.STATE_NONE:
                            setStatus(getString(R.string.bt_connection_failed, mStrBtName));
                            break;
                    }
                    break;
                case AppConstant.MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;
                    // construct a string from the buffer
                    String writeMessage = new String(writeBuf);
                    ChatDataList mChatDataList = new ChatDataList(writeMessage, ChatDataList.SEND, null);
                    mBtChatRVAdapter.setData(mChatDataList);
                    mBtChatRVAdapter.notifyDataSetChanged();
                    mEtChatContent.setText("");
                    break;
                case AppConstant.MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    // construct a string from the valid bytes in the buffer
                    String readMessage = new String(readBuf);
                    ChatDataList mChatread = new ChatDataList(readMessage, ChatDataList.RECEIVER, null);
                    mBtChatRVAdapter.setData(mChatread);
                    mBtChatRVAdapter.notifyDataSetChanged();
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
