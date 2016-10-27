package ru.skillbranch.mvp.view;

import ru.skillbranch.mvp.presenter.IFragmentPresenter;

public interface IFragmentView {

    IFragmentPresenter getPresenter();

    void showMemberProfile(int position);

}
