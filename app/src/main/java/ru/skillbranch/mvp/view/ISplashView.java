package ru.skillbranch.mvp.view;

import ru.skillbranch.mvp.presenter.ISplashPresenter;

public interface ISplashView {

    void showMessage(String message);
    void showMessage(int stringId);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    ISplashPresenter getPresenter();

    void nextActivity();
}
