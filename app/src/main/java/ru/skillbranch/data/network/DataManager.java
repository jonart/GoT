package ru.skillbranch.data.network;

/**
 * Created by root on 18.10.2016.
 */

import android.content.Context;

import ru.skillbranch.data.IceAndFire;
import ru.skillbranch.data.RestApi;
import ru.skillbranch.data.network.database.DaoSession;


/**
 * Created by root on 17.10.2016.
 */

public class DataManager {
    private static DataManager INSTANCE = null;
    private DaoSession mDaoSession;
    private Context mContext;

    public DataManager() {
        this.mContext = IceAndFire.getContext();
        this.mDaoSession = IceAndFire.getDaoSession();
    }
    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public Context getContext() {
        return IceAndFire.getContext();
    }

    public DaoSession getDaoSession() {
        return IceAndFire.getDaoSession();

    }


}

