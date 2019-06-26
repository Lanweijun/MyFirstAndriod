package com.example.myfirstandroid.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myfirstandroid.mvp.IMvpView;
import com.example.myfirstandroid.mvp.MvpController;

public class LifeCircleMvpActivity extends AppCompatActivity implements IMvpView {

    private MvpController mvpController;

    @Override
    public MvpController getMvpController() {
        if(this.mvpController == null){
            this.mvpController = new MvpController();
        }
        return this.mvpController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent == null){
            intent = new Intent();
        }
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onCreate(savedInstanceState,intent,null);
            mvpController.onActivityCreated(savedInstanceState,intent,null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onResume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onDestroy();
        }
        Log.e("LifeCircleMvpActivity","onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpController mvpController = this.getMvpController();
        if(mvpController == null){
            mvpController.onActivityResult(requestCode, resultCode, data);
        }
    }

}
