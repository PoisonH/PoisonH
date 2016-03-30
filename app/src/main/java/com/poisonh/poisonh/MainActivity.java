package com.poisonh.poisonh;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.poisonh.poisonh.fragment.BluetoothFragment;
import com.poisonh.poisonh.fragment.LocationFragment;
import com.poisonh.poisonh.fragment.MusicFragment;
import com.poisonh.poisonh.fragment.NewsFragment;
import com.poisonh.poisonh.fragment.VedioFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity
{
    private BottomBar mBottomBar;

    private FragmentManager mFragmentManager = null;
    private Fragment mNewsFragment;
    private Fragment mBluetoothFragment;
    private Fragment mMusicFragment;
    private Fragment mVedioFragment;
    private Fragment mLocationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        setTabSelection(0);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener()
        {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId)
            {
                setTabSelection(menuItemId);
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId)
            {
            }
        });

        // Setting colors for different tabs when there's more than three of them.You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
        mBottomBar.mapColorForTab(3, "#FF5252");
        mBottomBar.mapColorForTab(4, "#FF9800");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 0:首页，1：编程开发，2：程序员人生，3：快乐码农，4：开源软件
     */
    private void setTabSelection(int index)
    {
        // 开启一个Fragment事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index)
        {
            case 0:
                if (mNewsFragment == null)
                {
                    // 如果mHomeFragment为空，则创建一个并添加到界面上
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.fl_content, mNewsFragment);
                } else
                {
                    // 如果mHomeFragment不为空，则直接将它显示出来
                    transaction.show(mNewsFragment);
                }
                break;
            case 1:
                if (mBluetoothFragment == null)
                {
                    // 如果mProgrammerFragment为空，则创建一个并添加到界面上
                    mBluetoothFragment = new BluetoothFragment();
                    transaction.add(R.id.fl_content, mBluetoothFragment);
                } else
                {
                    // 如果mProgrammerFragment不为空，则直接将它显示出来
                    transaction.show(mBluetoothFragment);
                }
                break;
            case 2:
                if (mMusicFragment == null)
                {
                    // 如果mProgrammerLifeFragment为空，则创建一个并添加到界面上
                    mMusicFragment = new MusicFragment();
                    transaction.add(R.id.fl_content, mMusicFragment);
                } else
                {
                    // 如果mProgrammerLifeFragment不为空，则直接将它显示出来
                    transaction.show(mMusicFragment);
                }
                break;
            case 3:
                if (mVedioFragment == null)
                {
                    // 如果mWeeklyFragment为空，则创建一个并添加到界面上
                    mVedioFragment = new VedioFragment();
                    transaction.add(R.id.fl_content, mVedioFragment);
                } else
                {
                    // 如果mWeeklyFragment不为空，则直接将它显示出来
                    transaction.show(mVedioFragment);
                }
                break;
            case 4:
                if (mLocationFragment == null)
                {
                    // 如果mOpenSoftwareFragment为空，则创建一个并添加到界面上
                    mLocationFragment = new LocationFragment();
                    transaction.add(R.id.fl_content, mLocationFragment);
                } else
                {
                    // 如果mOpenSoftwareFragment不为空，则直接将它显示出来
                    transaction.show(mLocationFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction)
    {
        if (mNewsFragment != null)
        {
            transaction.hide(mNewsFragment);
        }
        if (mBluetoothFragment != null)
        {
            transaction.hide(mBluetoothFragment);
        }
        if (mMusicFragment != null)
        {
            transaction.hide(mMusicFragment);
        }
        if (mVedioFragment != null)
        {
            transaction.hide(mVedioFragment);
        }
        if (mLocationFragment != null)
        {
            transaction.hide(mLocationFragment);
        }
    }
}

