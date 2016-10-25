package ru.skillbranch.mvp.presenter;


import java.util.List;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.FragmentModel;
import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.mvp.view.IFragmentView;

/**
 * Created by root on 23.10.2016.
 */

public class FragmentPresenter implements IFragmentPresenter {
    private static FragmentPresenter ourInstance = new FragmentPresenter();
    private FragmentModel mFragmentModel;
    private IFragmentView mFramentView;
    private List<Member> mMembers;

    private FragmentPresenter() {mFragmentModel = new FragmentModel();}

    public static FragmentPresenter getInstance() {return ourInstance;}


    @Override
    public void takeView(IFragmentView fragmentView) {
        mFramentView = fragmentView;
    }

    @Override
    public void dropView() {
        mFramentView = null;
    }

    @Override
    public void initView() {

    }

    @Nullable
    @Override
    public IFragmentView getView() {
        return null;
    }

    public List<Member> getUser(int id){
        mMembers = mFragmentModel.getUserFromDb(id);
        return mMembers;
    }
}
