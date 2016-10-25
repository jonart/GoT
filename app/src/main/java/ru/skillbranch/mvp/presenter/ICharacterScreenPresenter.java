package ru.skillbranch.mvp.presenter;

import android.support.annotation.Nullable;

import ru.skillbranch.mvp.view.ICharacterScreenView;

/**
 * Created by root on 23.10.2016.
 */

public interface ICharacterScreenPresenter {


    void takeView(ICharacterScreenView characterScreenView);
    void dropView();
    void initView();

    @Nullable
    ICharacterScreenView getView();


}
