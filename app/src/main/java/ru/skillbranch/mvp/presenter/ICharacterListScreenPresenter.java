package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.view.ICharacterListView;

public interface ICharacterListScreenPresenter {

    void takeView(ICharacterListView iCharacterListView);
    void dropView();
    void initView();

    @Nullable
    ICharacterListView getView();

    void setHousePage(int i);
}
