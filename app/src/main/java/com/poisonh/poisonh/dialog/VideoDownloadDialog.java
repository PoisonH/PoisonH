package com.poisonh.poisonh.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.poisonh.poisonh.R;
import com.poisonh.poisonh.adapter.DownloadViewPagerAdapter;
import com.poisonh.poisonh.fragment.downloadfragment.DownloadedFragment;
import com.poisonh.poisonh.fragment.downloadfragment.DownloadingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoisonH on 2016/4/11.
 */
public class VideoDownloadDialog extends DialogFragment implements RadioGroup.OnCheckedChangeListener
{
    private RadioGroup mRadioGroup;
    private RadioButton mRbDownloaded;
    private RadioButton mRbDownloading;
    private ViewPager mViewPager;
    private List<Fragment> mListFragments;
    private DownloadViewPagerAdapter mDownloadViewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mListFragments = new ArrayList<>();
        return inflater.inflate(R.layout.layout_dialog_download_video, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mListFragments.add(new DownloadingFragment());
        mListFragments.add(new DownloadedFragment());
        mDownloadViewPagerAdapter = new DownloadViewPagerAdapter(getChildFragmentManager(), getActivity(), mListFragments);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_toggle);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_download_pager);
        mRbDownloaded = (RadioButton) view.findViewById(R.id.rb_downloaded);
        mRbDownloading = (RadioButton) view.findViewById(R.id.rb_downloading);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(mDownloadViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                switch (position)
                {
                    case 0:
                        mRbDownloading.setChecked(true);
                        mRbDownloaded.setChecked(false);
                        break;
                    case 1:
                        mRbDownloading.setChecked(false);
                        mRbDownloaded.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {
            case R.id.rb_downloading:
                mViewPager.setCurrentItem(0);
                break;

            case R.id.rb_downloaded:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

}
