package com.poisonh.poisonh.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by PoisonH on 2016/3/17.
 */
public class ToastUtils
{
    private static Toast mToast;

    public static void showToast(Context context, String contant, int length)
    {
        if (mToast != null)
        {
            mToast.setText(contant);
        } else
        {
            mToast = Toast.makeText(context, contant, length);
        }
        mToast.show();
    }
}
