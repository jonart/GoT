package ru.skillbranch.mvp.view;

import android.support.v4.view.ViewPager;

import ru.skillbranch.mvp.presenter.CharacterListScreenPresenter;

public interface ICharacterListView {

    void setupToolbar();

    CharacterListScreenPresenter getPresenter();

    void setPage(int pageNumber);
}
