package ru.skillbranch.mvp.presenter;

import java.util.List;

import javax.annotation.Nullable;

import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.mvp.view.IFragmentView;

public interface IFragmentPresenter {
    void takeView(IFragmentView fragmentView);
    void dropView();
    void initView();

    @Nullable
    IFragmentView getView();

    List<Member> getMembers(int id);

    void onListItemClick(int position);
}
