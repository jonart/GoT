package ru.skillbranch.mvp.presenter;

import javax.annotation.Nullable;

import ru.skillbranch.mvp.model.SplashModel;
import ru.skillbranch.mvp.view.ISplashView;

/**
 * Created by root on 23.10.2016.
 */

public class SplashPresenter implements ISplashPresenter{
    private static SplashPresenter ourInstance = new SplashPresenter();
    private SplashModel mSplashModel;
    private ISplashView mSplashView;

    private SplashPresenter() { mSplashModel = new SplashModel();}

    public static SplashPresenter getInstance(){ return ourInstance;}


    @Override
    public void takeView(ISplashView iSplashView) {
        mSplashView = iSplashView;
    }

    @Override
    public void dropView() {
        mSplashView = null;
    }

    @Override
    public void initView() {
        if(getView()!=null){
            if(isDBEmpty()){
                getView().hideLoad();
            }
            else {
                getView().showLoad();
            }
        }
    }

    @Nullable
    @Override
    public ISplashView getView() {
        return mSplashView;
    }

    @Override
    public boolean isDBEmpty() {
        return mSplashModel.getIsDataNull();
    }

    @Override
    public void addMembersToDB() {
        mSplashModel.addUserToDB();
    }

}
