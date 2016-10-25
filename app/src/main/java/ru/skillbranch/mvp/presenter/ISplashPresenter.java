package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.view.ISplashView;

/**
 * Created by root on 23.10.2016.
 */

public interface ISplashPresenter {

    void takeView(ISplashView iSplashView);
    void dropView();
    void initView();

    @Nullable
    ISplashView getView();

    boolean isDBEmpty();

    void addMembersToDB();
}
