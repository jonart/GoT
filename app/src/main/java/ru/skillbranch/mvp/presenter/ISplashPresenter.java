package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.view.ISplashView;

public interface ISplashPresenter {

    void takeView(ISplashView iSplashView);
    void dropView();
    void initView();

    @Nullable
    ISplashView getView();
}
