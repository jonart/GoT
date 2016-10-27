package ru.skillbranch.mvp.presenter;

import java.util.List;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.FragmentModel;
import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.mvp.view.IFragmentView;

import static android.R.attr.id;

public class FragmentPresenter implements IFragmentPresenter {
    private static FragmentPresenter ourInstance = new FragmentPresenter();

    private FragmentModel mFragmentModel;
    private IFragmentView mView;

    private List<Member> mMembers;

    private FragmentPresenter() {
        mFragmentModel = new FragmentModel();
    }

    public static FragmentPresenter getInstance() {
        return ourInstance;
    }

    @Override
    public void takeView(IFragmentView view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void initView() {
        mMembers = mFragmentModel.getUserFromDb(id);
    }

    @Nullable
    @Override
    public IFragmentView getView() {
        return mView;
    }

    public List<Member> getMembers(int id) {
        return mMembers;
    }

    @Override
    public void onListItemClick(int position) {
        mView.showMemberProfile(position);
    }
}
