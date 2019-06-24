package com.example.myfirstandroid;

import android.os.Handler;

public class CustomCountDownTimer implements Runnable{
    private final ICountDownHandler countDownHandler;
    private int time;
    private int countDowntime;
    private final Handler handler;
    private boolean isRun;

    //1、时时回调  这个时候是什么时间 倒计时到几秒  观察着模式
    //2、 支持动态传入总时间
    //3、没过一秒 总秒数减一
    //4、总时间倒计时为0时，要回调完成状态

    public CustomCountDownTimer(int time,ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
//        handler.postDelayed()  延迟发送
    }

    @Override
    public void run() {
        if(isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDowntime);
            }
            if(countDowntime == 0){
                cancel();
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else{
                countDowntime = time -- ;
                handler.postDelayed(this,1000);
            }
        }
    }

    //开启倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }

    //关闭倒计时
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    //观察着回调接口 （IOC 数据回调）
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);
        //完成时回调
        void onFinish();

    }

}
