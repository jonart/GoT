package ru.skillbranch.mvp.view;

/**
 * Created by root on 23.10.2016.
 */

public interface ICharacterScreenView {

    void showMessage(String message);
    void showError(Throwable e);

    void showLoad();
    void hideLoad();

    ICharacterListView getPresenter();
}
