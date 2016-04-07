package com.poisonh.poisonh.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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

    /**
     * 位移动画
     *
     * @param view
     * @param xFrom
     * @param xTo
     * @param yFrom
     * @param yTo
     * @param duration
     */
    public static void translateAnimation(View view, float xFrom, float xTo, float yFrom, float yTo, long duration)
    {

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, xFrom, Animation.RELATIVE_TO_SELF, xTo,
                Animation.RELATIVE_TO_SELF, yFrom, Animation.RELATIVE_TO_SELF, yTo);
        translateAnimation.setFillAfter(false);
        translateAnimation.setDuration(duration);
        view.startAnimation(translateAnimation);
        translateAnimation.startNow();
    }
}
