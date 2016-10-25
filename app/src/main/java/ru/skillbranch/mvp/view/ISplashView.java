package ru.skillbranch.mvp.view;

import ru.skillbranch.mvp.presenter.ISplashPresenter;

/**
 * Created by root on 23.10.2016.
 */

public interface ISplashView {

    void showMessage(String message);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    ISplashPresenter getPresenter();
}
