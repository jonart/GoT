package ru.skillbranch.mvp.presenter;

import android.content.Intent;
import android.os.Handler;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.SplashModel;
import ru.skillbranch.mvp.view.ISplashView;
import ru.skillbranch.ui.activity.CharacterListScreen;
import ru.skillbranch.ui.activity.SplashActivity;

public class SplashPresenter implements ISplashPresenter {

    private static SplashPresenter ourInstance = new SplashPresenter();

    private SplashModel mModel;
    private ISplashView mView;

    private SplashPresenter() {
        mModel = new SplashModel();
    }

    public static SplashPresenter getInstance() {
        return ourInstance;
    }

    @Override
    public void takeView(ISplashView view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void initView() {
        if (getView() == null) return;
        getView().showLoad();
        if (mModel.isDbEmpty()) {
            mModel.loadUsersToDB();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().hideLoad();
                mView.nextActivity();
            }
        }, 3000);
    }

    @Nullable
    @Override
    public ISplashView getView() {
        return mView;
    }

}
