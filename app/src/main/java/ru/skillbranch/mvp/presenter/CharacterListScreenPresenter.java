package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.CharacterListScreenModel;
import ru.skillbranch.mvp.view.ICharacterListView;

/**
 * Created by root on 23.10.2016.
 */

public class CharacterListScreenPresenter implements ICharacterListScreenPresenter{

    private static CharacterListScreenPresenter ourInstance = new CharacterListScreenPresenter();
    private CharacterListScreenModel mCharacterListScreenModel;
    private ICharacterListView mICharacterListView;

    private CharacterListScreenPresenter(){ mCharacterListScreenModel = new CharacterListScreenModel();}
    public static CharacterListScreenPresenter getInstance() {return ourInstance;}

    @Override
    public void takeView(ICharacterListView iCharacterListView) {
        mICharacterListView = iCharacterListView;

    }

    @Override
    public void dropView() {
        mICharacterListView = null;
    }

    @Override
    public void initView() {

    }

    @Nullable
    @Override
    public ICharacterListView getView() {
        return mICharacterListView;
    }

}
