package ru.skillbranch.data.managers;

import android.content.Context;

import retrofit2.Call;
import ru.skillbranch.GameOfThronesApplication;
import ru.skillbranch.data.network.RestApi;
import ru.skillbranch.data.network.ServiceGenerator;
import ru.skillbranch.data.network.responses.HouseModelRes;
import ru.skillbranch.data.network.responses.UserModelRes;
import ru.skillbranch.data.storage.models.DaoSession;

public class DataManager {

    private static DataManager INSTANCE = null;

    private DaoSession mDaoSession;
    private RestApi mRestApi;
    private Context mContext;

    public DataManager() {
        mContext = GameOfThronesApplication.getContext();
        mDaoSession = GameOfThronesApplication.getDaoSession();
        mRestApi = ServiceGenerator.createService(RestApi.class);
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public Context getContext() {
        return mContext;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    //region ======================== Network ========================

    public Call<HouseModelRes> getHouse(String url) {
        return mRestApi.getHouse(url);
    }

    public Call<UserModelRes> getMember(String url) {
        return mRestApi.getMember(url);
    }

    //endregion

}

