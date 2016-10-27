package ru.skillbranch.mvp.presenter;


import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.CharacterScreenModel;
import ru.skillbranch.data.storage.models.Member;
import ru.skillbranch.mvp.view.ICharacterScreenView;

/**
 * Created by root on 23.10.2016.
 */

public class CharacterScreenPresenter implements ICharacterScreenPresenter{
    private static CharacterScreenPresenter ourInstance = new CharacterScreenPresenter();
    private CharacterScreenModel mCharacterScreenModel;
    private ICharacterScreenView mICharacterScreenView;

    private CharacterScreenPresenter() {mCharacterScreenModel = new CharacterScreenModel();}

    public static CharacterScreenPresenter getInstance() {return ourInstance;}

    @Override
    public void takeView(ICharacterScreenView characterScreenView) {
        mICharacterScreenView = characterScreenView;
    }

    @Override
    public void dropView() {
        mICharacterScreenView = null;
    }

    @Override
    public void initView() {

    }

    @Nullable
    @Override
    public ICharacterScreenView getView() {
        return mICharacterScreenView;
    }

    public Member getUserData(String url){
        return mCharacterScreenModel.getUserByQuery(url);
    }
}
