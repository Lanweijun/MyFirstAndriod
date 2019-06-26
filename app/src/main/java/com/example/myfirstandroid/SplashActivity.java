package com.example.myfirstandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.myfirstandroid.mvp.ISplashActivityContract;

import java.io.File;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview {

    @BindView(R.id.vv_play)
    FullScreenVideoView vvPlay;
    @BindView(R.id.tv_splash_timer)
    TextView tvSplashTimer;
    private ISplashActivityContract.IPresenter timerPresenter;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //把初始化 Timer及相关内容抽取到 Presenter层种
////        initTimer();
//
//        //ctrl + alt + f; 抽取
//
//    }

    @Override
    public void afterBindView() {
        initTimerPresenter();
        initListener();
        initVideo();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }



    private void initVideo() {
        vvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
    }

    private void initListener() {
        tvSplashTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }


    @Override
    public void setTvTimer(String s) {
        tvSplashTimer.setText(s);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
