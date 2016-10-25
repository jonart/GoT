package ru.skillbranch.mvp.presenter;



import java.util.List;

import javax.annotation.Nullable;

import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.mvp.view.IFragmentView;

/**
 * Created by root on 23.10.2016.
 */

public interface IFragmentPresenter {
    void takeView(IFragmentView fragmentView);
    void dropView();
    void initView();

    @Nullable
    IFragmentView getView();

    public List<Member> getUser(int id);

}
