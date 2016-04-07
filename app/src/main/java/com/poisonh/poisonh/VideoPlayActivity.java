package com.poisonh.poisonh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by PoisonH on 2016/4/7.
 */
public class VideoPlayActivity extends AppCompatActivity
{
    private String mStrMp4Url;
    private VideoView mVideoView;
    private Button mBtnPlay;
    private Button mBtnStop;
    private Button mBtnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (!LibsChecker.checkVitamioLibs(this))
        {
            return;
        }
        mStrMp4Url = this.getIntent().getExtras().getString("PlayUrl");
        setContentView(R.layout.layout_activity_media);
        initView();

    }

    private void initView()
    {
        mVideoView = (VideoView) findViewById(R.id.vv_view);
        mBtnPlay = (Button) findViewById(R.id.btn_play);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnPause = (Button) findViewById(R.id.btn_pause);
        mBtnStop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                videoStop();
            }
        });
        mBtnPause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                videoPause();
            }
        });
        mBtnPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                videoPlay();
            }
        });
    }

    private void videoPlay()
    {
        mVideoView.setVideoPath(mStrMp4Url);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer)
            {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }

        });
    }

    private void videoStop()
    {
        mVideoView.stopPlayback();
    }
    private void videoPause()
    {
        mVideoView.pause();
    }
}

