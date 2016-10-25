package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.view.ICharacterListView;

/**
 * Created by root on 23.10.2016.
 */

public interface ICharacterListScreenPresenter {

    void takeView(ICharacterListView iCharacterListView);
    void dropView();
    void initView();

    @Nullable
    ICharacterListView getView();
}
