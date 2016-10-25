package ru.skillbranch.mvp.view;

import android.support.v4.view.ViewPager;

/**
 * Created by root on 23.10.2016.
 */

public interface ICharacterListView {

    void setupToolbar();
    void setupViewPager(ViewPager viewPager);


    ICharacterListView getPresenter();
}
