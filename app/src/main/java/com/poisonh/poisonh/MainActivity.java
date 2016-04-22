package com.poisonh.poisonh;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.poisonh.poisonh.base.BaseActivity;
import com.poisonh.poisonh.fragment.BluetoothFragment;
import com.poisonh.poisonh.fragment.LocationFragment;
import com.poisonh.poisonh.fragment.MusicFragment;
import com.poisonh.poisonh.fragment.NewsFragment;
import com.poisonh.poisonh.fragment.VedioFragment;
import com.poisonh.poisonh.widget.StatusBarCompat;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends BaseActivity
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
                setTabSelection(menuItemId);
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colortab1));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colortab2));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colortab3));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.colortab4));
        mBottomBar.mapColorForTab(4, ContextCompat.getColor(this, R.color.colortab5));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state,
        // otherwise we would lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     */
    private void setTabSelection(int index)
    {
        // 开启一个Fragment事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        setToolBarColor(index);
        switch (index)
        {
            case R.id.bb_menu_news:
                if (mNewsFragment == null)
                {
                    // 如果mNewsFragment为空，则创建一个并添加到界面上
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.fl_content, mNewsFragment);
                } else
                {
                    // 如果mNewsFragment不为空，则直接将它显示出来
                    transaction.show(mNewsFragment);
                }
                break;
            case R.id.bb_menu_bluetooth:
                if (mBluetoothFragment == null)
                {
                    // 如果mBluetoothFragment为空，则创建一个并添加到界面上
                    mBluetoothFragment = new BluetoothFragment();
                    transaction.add(R.id.fl_content, mBluetoothFragment);
                } else
                {
                    // 如果mBluetoothFragment不为空，则直接将它显示出来
                    transaction.show(mBluetoothFragment);
                }
                break;
            case R.id.bb_menu_music:
                if (mMusicFragment == null)
                {
                    // 如果mBluetoothFragment为空，则创建一个并添加到界面上
                    mMusicFragment = new MusicFragment();
                    transaction.add(R.id.fl_content, mMusicFragment);
                } else
                {
                    // 如果mBluetoothFragment不为空，则直接将它显示出来
                    transaction.show(mMusicFragment);
                }
                break;
            case R.id.bb_menu_vedio:
                if (mVedioFragment == null)
                {
                    // 如果mVedioFragment为空，则创建一个并添加到界面上
                    mVedioFragment = new VedioFragment();
                    transaction.add(R.id.fl_content, mVedioFragment);
                } else
                {
                    // 如果mVedioFragment不为空，则直接将它显示出来
                    transaction.show(mVedioFragment);
                }
                break;
            case R.id.bb_menu_location:
                if (mLocationFragment == null)
                {
                    // 如果mLocationFragment为空，则创建一个并添加到界面上
                    mLocationFragment = new LocationFragment();
                    transaction.add(R.id.fl_content, mLocationFragment);
                } else
                {
                    // 如果mLocationFragment不为空，则直接将它显示出来
                    transaction.show(mLocationFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void setToolBarColor(int index)
    {
        switch (index)
        {
            case R.id.bb_menu_news:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colortab1));
                break;
            case R.id.bb_menu_vedio:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colortab2));
                break;
            case R.id.bb_menu_bluetooth:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colortab3));
                break;
            case R.id.bb_menu_music:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colortab4));
                break;
            case R.id.bb_menu_location:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colortab5));
                break;
            default:
                break;
        }
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

