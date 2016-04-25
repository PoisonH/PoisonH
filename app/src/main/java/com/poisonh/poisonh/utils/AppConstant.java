package com.poisonh.poisonh.utils;

/**
 * Created by PoisonH on 2016/4/11.
 */
public class AppConstant
{
    public static String VIDEO_ID = "VIDEO_ID";
    public static String VIDEO_NAME = "VIDEO_NAME";
    public static String VIDEO_PLAYURL = "VIDEO_PLAYURL";
    public static String VIDEO_DOWNDLOAD_BROADCAST = "com.poisonh.poisonh.DOWNLOAD_VIDEO";
    public static String VIDEO_DOWNLOAD_PATH = "/PoisonH/download/";

    public static final String DOWNLOAD_ACTION_STOP = "DOWNLOAD_ACTION_STOP";
    public static final String DOWNLOAD_ACTION_START = "DOWNLOAD_ACTION_START";

    public static final String DOWNLOAD_FILEINFO = "DOWNLOAD_FILEINFO";

    public static final String DOWNLOAD_soFarBytes = "DOWNLOAD_soFarBytes";
    public static final String DOWNLOAD_totalBytes = "DOWNLOAD_totalBytes";

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    public static final String FRAGMENT_BACK_VALUE = "FRAGMENT_BACK_VALUE";
    public static final String CONNECTION_BT = "CONNECTION_BT";
}
