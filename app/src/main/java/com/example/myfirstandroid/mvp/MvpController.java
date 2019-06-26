package com.example.myfirstandroid.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpController implements ILifeCircle{

    //存放 P层的实例
    private Set<ILifeCircle> iLifeCircleSet = new HashSet<>();

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.iLifeCircleSet.iterator();
        while ((iterator.hasNext())){
            ILifeCircle next = iterator.next();
            if(intent == null){
                intent = new Intent();
            }
            if(getArguments == null){
                getArguments = new Bundle();
            }
            next.onCreate(savedInstanceState,intent,getArguments);
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator var3 = this.iLifeCircleSet.iterator();
        while (var3.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var3.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            presenter.onActivityCreated(savedInstanceState, intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator var2 = this.iLifeCircleSet.iterator();
        while (var2.hasNext()) {
            ILifeCircle presenter1 = (ILifeCircle) var2.next();
            presenter1.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onDestroy();
            Log.e("MvpController","onDestroy");
        }
        this.iLifeCircleSet.clear();
    }

    @Override
    public void destroyView() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator var2 = this.iLifeCircleSet.iterator();
        while (var2.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var2.next();
            presenter.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator var4 = this.iLifeCircleSet.iterator();
        while (var4.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var4.next();
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator var2 = this.iLifeCircleSet.iterator();
        while (var2.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var2.next();
            presenter.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        Iterator var1 = this.iLifeCircleSet.iterator();
        while (var1.hasNext()) {
            ILifeCircle presenter = (ILifeCircle) var1.next();
            presenter.attachView(iMvpView);
        }
    }


    public void savePresenter(ILifeCircle iLifeCircle) {
        this.iLifeCircleSet.add(iLifeCircle);
    }
}
