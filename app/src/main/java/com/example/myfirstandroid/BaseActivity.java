package com.example.myfirstandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.myfirstandroid.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCircleMvpActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if(annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid >0 ){
                setContentView(mainlayoutid);
                bindView();
                afterBindView();
                ButterKnife.bind(this);
            }else{
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
    }
    //模板方法 设计模式
    public abstract void afterBindView();

    //View 的依赖注入
    private void bindView() {
        ButterKnife.bind(this);
    }
}
