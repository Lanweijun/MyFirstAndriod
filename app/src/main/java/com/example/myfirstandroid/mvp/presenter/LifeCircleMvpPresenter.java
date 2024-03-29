package com.example.myfirstandroid.mvp.presenter;

import android.util.Log;

import com.example.myfirstandroid.mvp.ILifeCircle;
import com.example.myfirstandroid.mvp.IMvpView;
import com.example.myfirstandroid.mvp.MvpController;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {
    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter(){
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if(weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else{
            T view = (T)weakReference.get();
            if(view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.e("LifeCircleMvpPresenter","onDestroy");
        weakReference = null;
    }

    protected T getView(){
        T view = weakReference != null ? (T)weakReference.get() : null;
        if(view == null){
            return  getEmptyView();
        }else{
            return view;
        }
    }

    protected abstract T getEmptyView();
}
