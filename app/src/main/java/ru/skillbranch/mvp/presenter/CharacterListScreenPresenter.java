package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.CharacterListScreenModel;
import ru.skillbranch.mvp.view.ICharacterListView;
import ru.skillbranch.utils.ConstantManager;

public class CharacterListScreenPresenter implements ICharacterListScreenPresenter {

    private static CharacterListScreenPresenter ourInstance = new CharacterListScreenPresenter();
    private CharacterListScreenModel mCharacterListScreenModel;
    private ICharacterListView mView;

    private CharacterListScreenPresenter() {
        mCharacterListScreenModel = new CharacterListScreenModel();
    }

    public static CharacterListScreenPresenter getInstance() {
        return ourInstance;
    }

    @Override
    public void takeView(ICharacterListView iCharacterListView) {
        mView = iCharacterListView;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void initView() {

    }

    @Nullable
    @Override
    public ICharacterListView getView() {
        return mView;
    }

    @Override
    public void setHousePage(int houseId) {
        switch (houseId) {
            case ConstantManager.STARKS_HOUSE_ID:
                mView.setPage(0);
                break;
            case ConstantManager.LANNISTERS_HOUSE_ID:
                mView.setPage(1);
                break;
            case ConstantManager.TARGARYENS_HOUSE_ID:
                mView.setPage(2);
                break;
        }
    }
}
