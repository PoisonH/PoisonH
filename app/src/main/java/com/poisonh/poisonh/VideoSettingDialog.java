package com.poisonh.poisonh;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.poisonh.poisonh.utils.AppConstant;

/**
 * Created by PoisonH on 2016/4/11.
 */
public class VideoSettingDialog extends DialogFragment implements RadioGroup.OnCheckedChangeListener
{
    private RadioGroup mRadioGroup;
    private RadioButton mRBStandard;
    private RadioButton mRBClear;
    private RadioButton mRBHB;

    private VideoSettingListener mVideoSettingListener;

    public void setmVideoSettingListener(VideoSettingListener mVideoSettingListener)
    {
        this.mVideoSettingListener = mVideoSettingListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.layout_dialog_video_setting, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_group);
        mRBStandard = (RadioButton) view.findViewById(R.id.rb_clear);
        mRBClear = (RadioButton) view.findViewById(R.id.rb_clear);
        mRBHB = (RadioButton) view.findViewById(R.id.rb_hd);

        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        int radioBtnId = group.getCheckedRadioButtonId();
        switch (radioBtnId)
        {
            case R.id.rb_standard:
                mVideoSettingListener.chooseClarity(AppConstant.VIDEO_CLARITY_STANDARD);
                break;
            case R.id.rb_clear:
                mVideoSettingListener.chooseClarity(AppConstant.VIDEO_CLARITY_CLEAR);
                break;
            case R.id.rb_hd:
                mVideoSettingListener.chooseClarity(AppConstant.VIDEO_CLARITY_HD);
                break;
        }
    }

    /**
     * video设置清晰度的监听接口
     */
    public interface VideoSettingListener
    {
        void chooseClarity(int type);
    }
}
